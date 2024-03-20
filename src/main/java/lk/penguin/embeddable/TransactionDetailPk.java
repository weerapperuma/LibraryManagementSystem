package lk.penguin.embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Embeddable
public class TransactionDetailPk implements Serializable {
    @Column(name = "transaction_Id")
    private int transactionId;

    @Column(name = "book_Id")
    private int bookId;


}
