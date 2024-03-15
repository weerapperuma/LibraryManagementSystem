package lk.penguin.service.custom.impl;

import lk.penguin.dto.BooksDto;
import lk.penguin.dto.TransactionDetailDto;
import lk.penguin.dto.TransactionDto;
import lk.penguin.dto.UserDto;
import lk.penguin.entity.Books;
import lk.penguin.entity.User;
import lk.penguin.repository.RepositoryFactory;
import lk.penguin.repository.custom.BooksRepository;
import lk.penguin.repository.custom.TransactionDetailRepository;
import lk.penguin.repository.custom.TransactionRepository;
import lk.penguin.repository.custom.UserRepository;
import lk.penguin.repository.custom.impl.BooksRepositoryImpl;
import lk.penguin.repository.custom.impl.TransactionDetailRepositoryImpl;
import lk.penguin.repository.custom.impl.TransactionRepositoryImpl;
import lk.penguin.repository.custom.impl.UserRepositoryImpl;
import lk.penguin.service.custom.Pane1Service;
import lk.penguin.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Pane1ServiceImpl implements Pane1Service {
    private Session session;
    public static TransactionDto transactionDto=null;
    UserRepository userRepository= (UserRepositoryImpl) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryType.USER);
    TransactionRepository transactionRepository= (TransactionRepositoryImpl) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryType.TRANSACTION);
    TransactionDetailRepository transactionDetailRepository= (TransactionDetailRepositoryImpl) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryType.TRANSACTIONDETAIL);
    BooksRepository booksRepository= (BooksRepositoryImpl) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryType.BOOKS);
    @Override
    public UserDto isExistsUser(String text, String text1) {
        session= SessionFactoryConfig.getInstance().getSession();
        try{
            userRepository.setSession(session);
            User user=userRepository.ifExists(text);

            if(user.getUserPassword().equals(text1)){
                return user.toDto();
            }
            else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        finally {
            session.close();
        }
    }
    public boolean updateBookStatus(ArrayList<BooksDto> addedCartBookDtos) {
        ArrayList<Books>books= new ArrayList<>();
        for(BooksDto booksDto:addedCartBookDtos){
            books.add(booksDto.toEntity());
        }
        try {

            booksRepository.setSession(session);
            for(Books books1:books){
                Books books2=new Books(
                        books1.getBookId(),
                        books1.getBookTitle(),
                        books1.getGenre(),
                        books1.getAuthor(),
                        "unavailable",
                        null
                );
                booksRepository.update(books2);
            }
            return true;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    private boolean saveTransactionDetails(TransactionDto transactionDto1, ArrayList<BooksDto> addedCartBookDtos) {


        transactionDetailRepository.setSession(session);
        for(BooksDto booksDto:addedCartBookDtos){
            TransactionDetailDto transactionDetailDto=new TransactionDetailDto(
                    0,
                    LocalDateTime.now(),
                    booksDto,
                    transactionDto1
            );
            transactionDetailRepository.save(transactionDetailDto.toEntity());
        }
        return true;
    }
    @Override
    public void commitTransactions(TransactionDto transactionDto, ArrayList<BooksDto> addedCartBookDtos) {
        session=SessionFactoryConfig.getInstance().getSession();
        org.hibernate.Transaction transaction = session.beginTransaction();
        try {
            transactionRepository.setSession(session);
            int savedTransaction=transactionRepository.save(transactionDto.toEntity());
            TransactionDto transactionDto1=new TransactionDto(
                    savedTransaction,
                    transactionDto.getOrderTime(),
                    transactionDto.getDueDate(),
                    transactionDto.getCompletenceStatus(),
                    transactionDto.getUserDto()

            );

            //updateBooks
            ArrayList<Books>books= new ArrayList<>();
            for(BooksDto booksDto:addedCartBookDtos){
                books.add(booksDto.toEntity());
            }
            booksRepository.setSession(session);
            for(Books books1:books) {
                Books books2 = new Books(
                        books1.getBookId(),
                        books1.getBookTitle(),
                        books1.getGenre(),
                        books1.getAuthor(),
                        "unavailable",
                        null
                );
                booksRepository.update(books2);
            }

            session.clear();
            //save trasaction details
            transactionDetailRepository.setSession(session);
            for(BooksDto booksDto:addedCartBookDtos){
                TransactionDetailDto transactionDetailDto=new TransactionDetailDto(
                        0,
                        LocalDateTime.now(),
                        booksDto,
                        transactionDto1
                );
                transactionDetailRepository.save(transactionDetailDto.toEntity());
            }

            transaction.commit();


        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
    }
}
