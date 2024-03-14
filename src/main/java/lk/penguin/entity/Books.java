package lk.penguin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
}
