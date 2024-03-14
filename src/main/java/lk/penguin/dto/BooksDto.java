package lk.penguin.dto;

import lk.penguin.entity.Admin;
import lk.penguin.entity.Books;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.print.Book;

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
        return new Books(
            this.bookId,
                this.bookTitle,
                this.genre,
                this.author,
                this.availability,
                this.admin
        );
    }
}
