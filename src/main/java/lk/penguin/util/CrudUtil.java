package lk.penguin.util;

import lk.penguin.entity.Books;
import lk.penguin.entity.User;
import lk.penguin.repository.SuperRepository;

import java.util.ArrayList;

public interface CrudUtil<T> extends SuperRepository {
    T ifExists(String id);
    ArrayList<T> getAll();

    //boolean save(Books books);
    Long save(T entity);

    boolean delete(int id);

    //boolean update(Books books);
    boolean update(T entity);

}
