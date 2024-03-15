package lk.penguin.dto;

import lk.penguin.entity.Books;
import lk.penguin.entity.Transaction;
import lk.penguin.entity.TransactionDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionDetailDto {
    private int transactionDetailId;
    private LocalDateTime date;
    private BooksDto booksDto;
    private TransactionDto transactionDto;


    public TransactionDetail toEntity(){
        Books books=booksDto.toEntity();
        Transaction transaction=transactionDto.toEntity();

        return new TransactionDetail(
                transactionDetailId,
                date,
                books,
                transaction
        );
    }
}
