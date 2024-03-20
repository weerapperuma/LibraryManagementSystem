package lk.penguin.service.custom.impl;

import lk.penguin.dto.BooksDto;
import lk.penguin.dto.TransactionDetailDto;
import lk.penguin.dto.TransactionDto;
import lk.penguin.dto.UserDto;
import lk.penguin.embeddable.TransactionDetailPk;
import lk.penguin.entity.Books;
import lk.penguin.entity.TransactionDetail;
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

    @Override
    public void commitTransactions(TransactionDto transactionDto, ArrayList<BooksDto> addedCartBookDtos) {
        session=SessionFactoryConfig.getInstance().getSession();
        org.hibernate.Transaction transaction = session.beginTransaction();


        lk.penguin.entity.Transaction entity = transactionDto.toEntity();

        try {
            //save transaction
            transactionRepository.setSession(session);
            int save = transactionRepository.save(entity);
            //session.flush();


            System.out.println("transaction saved id : "+save);
            for(BooksDto booksDto:addedCartBookDtos){

                //update books
                booksRepository.setSession(session);
                booksDto.setAvailability("unavailable");
                booksRepository.update(booksDto.toEntity());
                //session.flush();

                //transaction-detail save
                transactionDetailRepository.setSession(session);
                TransactionDetail transactionDetail = new TransactionDetail();

                System.out.println("pane 1 service "+transactionDto.toEntity().getTransactionId());
                System.out.println("pane 1 service 2 "+booksDto.toEntity().getBookId());

                transactionDetail.setTransaction(entity);
                transactionDetail.setBooks(booksDto.toEntity());
                transactionDetail.setTransactionDetailId(
                        new TransactionDetailPk(
                                entity.getTransactionId(),
                                booksDto.toEntity().getBookId()
                        )

                );
                transactionDetailRepository.save(transactionDetail);
                //session.flush();
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
