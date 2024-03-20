package lk.penguin.entity;

import lk.penguin.dto.BooksDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "books")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_Id")
    private int bookId;

    @Column(name = "book_title")
    private String bookTitle;

    @Column(name = "genre")
    private String genre;

    @Column(name = "author")
    private String author;

    @Column(name = "availability")
    private String availability;


    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "books")
    private List<TransactionDetail> transactionDetails=new ArrayList<>();

    public BooksDto toDto() {
        return new BooksDto(
                bookId,
                bookTitle,
                genre,
                author,
                availability,
                admin
        );
    }
}
