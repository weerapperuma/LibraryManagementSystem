package lk.penguin.repository.custom.impl;

import lk.penguin.dto.TransactionDto;
import lk.penguin.entity.Books;
import lk.penguin.repository.custom.BooksRepository;
import lk.penguin.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class BooksRepositoryImpl implements BooksRepository {
    private Session session;

    private static BooksRepositoryImpl booksRepositoryImpl;

    public BooksRepositoryImpl(){
        session= SessionFactoryConfig.getInstance().getSession();
    }

    @Override
    public void setSession(Session session) {
        this.session=session;
    }

    @Override
    public int save(Books books) {
        return (int) session.save(books);
    }
    @Override
    public Books ifExists(String id) {
        return null;
    }

    @Override
    public ArrayList<Books> getAll() {
        session.beginTransaction();
        try{
            Query<Books> query= session.createQuery("from Books ", Books.class);
            List<Books> booksList=query.list();

            session.getTransaction().commit();

            return new ArrayList<>(booksList);

        }catch (Exception e){
            if(session.getTransaction().isActive()){
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            return new ArrayList<>();
        }

    }



    @Override
    public boolean delete(int lblBookID) {
        Transaction transaction=session.beginTransaction();
        try {
            Books books=session.get(Books.class,lblBookID);
            session.delete(books);
            transaction.commit();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean update(Books books) {
        Transaction transaction=session.beginTransaction();
        try{
            session.update(books);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
        finally {
            session.close();
        }
    }


    @Override
    public ArrayList<Books> getAllAvailable() {
        String query = "SELECT b FROM Books b WHERE b.availability = 'available'";
        Query<Books> query1 = session.createQuery(query, Books.class);
        return (ArrayList<Books>) query1.list();
    }
}
