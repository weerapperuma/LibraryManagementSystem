package lk.penguin.service.custom;

import lk.penguin.dto.BooksDto;
import lk.penguin.service.SuperService;

import java.util.ArrayList;

public interface BookManageService extends SuperService {
    ArrayList<BooksDto> getAllBooks();

    Long save(BooksDto booksDTO);

    boolean delete(int lblBookID);

    boolean update(BooksDto booksDTO);
}
