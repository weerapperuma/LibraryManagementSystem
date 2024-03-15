package lk.penguin.entity;

import lk.penguin.dto.BooksDto;
import lk.penguin.dto.TransactionDetailDto;
import lk.penguin.dto.TransactionDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "transaction_detail")
public class TransactionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_detail_id")
    private int transactionDetailId;

    @Column(name = "date")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "book_Id")
    private Books books;

    @ManyToOne
    @JoinColumn(name = "transaction_Id")
    private Transaction transaction;

    public TransactionDetailDto toDto(){
        BooksDto booksDto=books.toDto();
        TransactionDto transactionDto=transaction.toDto();
        return new TransactionDetailDto(
                transactionDetailId,
                date,
                booksDto,
                transactionDto
        );
    }

}
