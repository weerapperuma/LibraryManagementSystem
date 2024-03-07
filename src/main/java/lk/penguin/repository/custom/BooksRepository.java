package lk.penguin.repository.custom;

import lk.penguin.entity.Books;
import lk.penguin.repository.SuperRepository;

import java.util.ArrayList;

public interface BooksRepository extends SuperRepository {
    ArrayList<Books> getAll();
}
