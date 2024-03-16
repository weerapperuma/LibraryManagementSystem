package lk.penguin.repository.custom.impl;

import lk.penguin.dto.BranchDto;
import lk.penguin.entity.Books;
import lk.penguin.repository.custom.BooksRepository;
import lk.penguin.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class BooksRepositoryImpl implements BooksRepository {
    private Session session;
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
        Query<Books> query= session.createQuery("from Books ", Books.class);
        List<Books> booksList=query.list();
        return (ArrayList<Books>) booksList;
    }



    @Override
    public void delete(int id ){
        Books books=session.get(Books.class,id);
        session.delete(books);
    }

    @Override
    public void update(Books books) {
        session.update(books);
    }


    @Override
    public ArrayList<Books> getAllAvailable() {
        String query = "SELECT b FROM Books b WHERE b.availability = 'available'";
        Query<Books> query1 = session.createQuery(query, Books.class);
        return (ArrayList<Books>) query1.list();
    }
}
