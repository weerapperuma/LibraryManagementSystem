package lk.penguin.dto;

import lk.penguin.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionDto {
    private int transactionId;
    private Date orderTime;
    private Date dueDate;
    private String completenceStatus;
    private User user;
}
