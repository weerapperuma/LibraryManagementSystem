package lk.penguin.util;

import lk.penguin.dto.TransactionDto;
import lk.penguin.repository.SuperRepository;

import java.util.ArrayList;

public interface CrudUtil<T> extends SuperRepository {
    T ifExists(String id);
    ArrayList<T> getAll();

    //boolean save(Books books);
    int save(T entity);

    boolean delete(int id);

    //boolean update(Books books);
    boolean update(T entity);

}
