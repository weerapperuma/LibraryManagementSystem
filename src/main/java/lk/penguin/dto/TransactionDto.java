package lk.penguin.dto;

import lk.penguin.entity.Transaction;
import lk.penguin.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionDto {
    private int transactionId;
    private LocalDateTime orderTime;
    private LocalDateTime dueDate;
    private String completenceStatus;
    private UserDto userDto;

    public Transaction toEntity() {

        Transaction transaction = new Transaction();
        transaction.setTransactionId(transactionId);
        transaction.setOrderTime(orderTime);
        transaction.setDueDate(dueDate);
        transaction.setCompletenceStatus(completenceStatus);
        transaction.setUser(userDto.toEntity());

        return transaction;
    }

}
