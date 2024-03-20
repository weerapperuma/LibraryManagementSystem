package lk.penguin.entity;

import lk.penguin.dto.BooksDto;
import lk.penguin.dto.TransactionDetailDto;
import lk.penguin.dto.TransactionDto;
import lk.penguin.embeddable.TransactionDetailPk;
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
    @EmbeddedId
    private TransactionDetailPk transactionDetailId;

    @ManyToOne
    @JoinColumn(name = "transaction_Id",
            insertable = false,
            updatable = false
    )
    private Transaction transaction;

    @ManyToOne
    @JoinColumn(
            name = "book_Id",
            insertable = false,
            updatable = false
    )
    private Books books;


    @Column(name = "date")
    private LocalDateTime date;

    public TransactionDetailDto toDto(){
        BooksDto booksDto=books.toDto();
        TransactionDto transactionDto=transaction.toDto();
        return new TransactionDetailDto(
                transactionDetailId,
                transactionDto,
                booksDto

        );
    }

}
