package lk.penguin.dto;

import lk.penguin.entity.Admin;
import lk.penguin.entity.Books;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.print.Book;
import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BooksDto {
    private int bookId;
    private String bookTitle;
    private String genre;
    private String author;
    private String availability;
    private Admin admin;

    public Books toEntity(){
        Books books = new Books();
        books.setBookId(bookId);
        books.setBookTitle(bookTitle);
        books.setGenre(genre);
        books.setAuthor(author);
        books.setAvailability(availability);
        books.setAdmin(admin);

        return books;
    }
}
