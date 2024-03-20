package lk.penguin.dto;

import lk.penguin.embeddable.TransactionDetailPk;
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
    private TransactionDetailPk transactionDetailPk;
    private TransactionDto transactionDto;
    private BooksDto booksDto;



    public TransactionDetail toEntity(){

        TransactionDetail transactionDetail = new TransactionDetail();
        transactionDetail.setTransactionDetailId(transactionDetailPk);
        transactionDetail.setBooks(booksDto.toEntity());
        transactionDetail.setTransaction(transactionDto.toEntity());

        return transactionDetail;
    }
}
