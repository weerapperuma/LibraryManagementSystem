package lk.penguin.util;

import lk.penguin.repository.SuperRepository;

import java.util.ArrayList;

public interface CrudUtil<T> extends SuperRepository {
    T ifExists(String id);
    ArrayList<T> getAll();
    int save(T entity);

    boolean delete(int id);

    //boolean update(Books books);
    void update(T entity);

}
