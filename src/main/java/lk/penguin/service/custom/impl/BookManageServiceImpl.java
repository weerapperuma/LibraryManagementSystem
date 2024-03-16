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

import java.util.ArrayList;

public class BookManageServiceImpl implements BookManageService {
    BooksRepository booksRepository= (BooksRepository) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryType.BOOKS);
    AdminRepository adminRepository= (AdminRepository) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryType.ADMIN);
    private Session session;
    @Override
    public ArrayList<BooksDto> getAllBooks() {
        session=SessionFactoryConfig.getInstance().getSession();
        try{
            booksRepository.setSession(session);
            ArrayList<Books>booksAll=booksRepository.getAll();

            ArrayList<BooksDto> booksDtos = new ArrayList<>();
            for(Books books1:booksAll){
                booksDtos.add(books1.toDto());
            }
            return booksDtos;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }

    }

    @Override
    public int save(BooksDto booksDTO) {
        session=SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            booksRepository.setSession(session);
            int save = booksRepository.save(booksDTO.toEntity());
            transaction.commit();
            return save;
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
        return 0;
    }

    @Override
    public boolean delete(int lblBookID) {
        session=SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            booksRepository.setSession(session);
            booksRepository.delete(lblBookID);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean update(BooksDto booksDTO) {
        session=SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            booksRepository.setSession(session);
            booksRepository.update(booksDTO.toEntity());
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            return false;
        }finally {
            session.close();
        }

    }

    @Override
    public ArrayList<BooksDto> getAvailableBooks() {
        session=SessionFactoryConfig.getInstance().getSession();
        try {
            booksRepository.setSession(session);
            ArrayList<Books> books=booksRepository.getAllAvailable();
            ArrayList<BooksDto>booksDtos=new ArrayList<>();

            for(Books books1:books){
                booksDtos.add(books1.toDto());
            }
            return booksDtos;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }
}
