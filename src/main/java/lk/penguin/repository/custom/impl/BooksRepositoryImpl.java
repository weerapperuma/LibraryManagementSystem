package lk.penguin.repository.custom.impl;

import lk.penguin.entity.Books;
import lk.penguin.repository.custom.BooksRepository;
import lk.penguin.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class BooksRepositoryImpl implements BooksRepository {
    private Session session;


    public BooksRepositoryImpl(){
        session= SessionFactoryConfig.getInstance().getSession();
    }
    @Override
    public ArrayList<Books> getAll() {
        session.beginTransaction();
        try{
            Query<Books> query= session.createQuery("from books ", Books.class);
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
}
