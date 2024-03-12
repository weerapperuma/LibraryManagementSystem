package lk.penguin.service.custom.impl;

import lk.penguin.dto.BooksDto;
import lk.penguin.entity.Books;
import lk.penguin.repository.RepositoryFactory;
import lk.penguin.repository.custom.AdminRepository;
import lk.penguin.repository.custom.BooksRepository;
import lk.penguin.service.custom.BookManageService;
import lk.penguin.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.security.PrivateKey;
import java.util.ArrayList;

public class BookManageServiceImpl implements BookManageService {
    BooksRepository booksRepository= (BooksRepository) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryType.BOOKS);
    AdminRepository adminRepository= (AdminRepository) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryType.ADMIN);
    private Session session;
    @Override
    public ArrayList<BooksDto> getAllBooks() {
        ArrayList<Books>booksAll=booksRepository.getAll();
        System.out.println(booksAll.size());

        ArrayList<BooksDto> booksDtos = new ArrayList<>();
        for(Books books1:booksAll){
            BooksDto booksDTO=new BooksDto(
              books1.getBookId(),
              books1.getBookTitle(),
              books1.getGenre(),
              books1.getAuthor(),
              books1.getAvailability(),
              books1.getAdmin()
            );
            booksDtos.add(booksDTO);
        }
        return booksDtos;
    }

    @Override
    public Long save(BooksDto booksDTO) {
        session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        try{
            booksRepository.setSession(session);
            Long save = booksRepository.save(booksDTO.toEntity());
            transaction.commit();
            System.out.println("commit una");
            return save;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return -1L;
        }
        finally {
            session.close();
        }
    }

    @Override
    public boolean delete(int lblBookID) {
        return booksRepository.delete(lblBookID);
    }

    @Override
    public boolean update(BooksDto booksDTO) {
        //Admin admin=adminRepository.ifExists(String.valueOf(WelcomeFormController.admin));
        Books books=new Books(booksDTO.getBookId(),booksDTO.getBookTitle(),booksDTO.getGenre(),booksDTO.getAuthor(),booksDTO.getAvailability(),booksDTO.getAdmin());
        return booksRepository.update(books);
    }
}
