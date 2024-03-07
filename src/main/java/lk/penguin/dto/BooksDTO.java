package lk.penguin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BooksDTO {
    private int bookId;
    private String bookTitle;
    private String genre;
    private String author;
    private String availability;
}
