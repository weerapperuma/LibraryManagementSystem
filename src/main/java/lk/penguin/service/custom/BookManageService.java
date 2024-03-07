package lk.penguin.service.custom;

import lk.penguin.dto.BooksDTO;
import lk.penguin.repository.SuperRepository;
import lk.penguin.service.SuperService;

import java.util.ArrayList;

public interface BookManageService extends SuperService {
    ArrayList<BooksDTO> getAllBooks();
}
