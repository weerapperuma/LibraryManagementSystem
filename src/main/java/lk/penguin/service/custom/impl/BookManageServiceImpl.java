package lk.penguin.service.custom.impl;

import lk.penguin.dto.BooksDTO;
import lk.penguin.entity.Books;
import lk.penguin.repository.RepositoryFactory;
import lk.penguin.repository.custom.BooksRepository;
import lk.penguin.service.custom.BookManageService;

import java.util.ArrayList;

public class BookManageServiceImpl implements BookManageService {
    BooksRepository booksRepository= (BooksRepository) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryType.BOOKS);

    @Override
    public ArrayList<BooksDTO> getAllBooks() {
        ArrayList<Books>booksAll=booksRepository.getAll();
        System.out.println(booksAll.size());

        ArrayList<BooksDTO>booksDTOS = new ArrayList<>();
        for(Books books1:booksAll){
            BooksDTO booksDTO=new BooksDTO(
              books1.getBookId(),
              books1.getBookTitle(),
              books1.getGenre(),
              books1.getAuthor(),
              books1.getAvailability()
            );
            booksDTOS.add(booksDTO);
        }
        return booksDTOS;
    }

    @Override
    public boolean save(BooksDTO booksDTO) {
        Books books=new Books(booksDTO.getBookId(),booksDTO.getBookTitle(),booksDTO.getGenre(),booksDTO.getAuthor(),booksDTO.getAvailability());
        return booksRepository.save(books);
    }

    @Override
    public boolean delete(int lblBookID) {
        return booksRepository.delete(lblBookID);
    }

    @Override
    public boolean update(BooksDTO booksDTO) {
        Books books=new Books(booksDTO.getBookId(),booksDTO.getBookTitle(),booksDTO.getGenre(),booksDTO.getAuthor(),booksDTO.getAvailability());
        return booksRepository.update(books);
    }
}
