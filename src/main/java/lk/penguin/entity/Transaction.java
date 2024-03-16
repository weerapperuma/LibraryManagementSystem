package lk.penguin.entity;

import lk.penguin.dto.TransactionDto;
import lk.penguin.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_Id")
    private int transactionId;

    @Column(name = "order_time")
    private LocalDateTime orderTime;

    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @Column(name = "completence_status")
    private String completenceStatus;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL,
    fetch = FetchType.LAZY,
    mappedBy = "transaction")
    private List<TransactionDetail>transactionDetails=new ArrayList<>();

    public Transaction(int transactionId, LocalDateTime orderTime, LocalDateTime dueDate, String completenceStatus, User user) {
        this.transactionId=transactionId;
        this.orderTime=orderTime;
        this.dueDate=dueDate;
        this.completenceStatus=completenceStatus;
        this.user=user;
    }

    public TransactionDto toDto() {
        UserDto userDto=user.toDto();
        return new TransactionDto(
                transactionId,
                orderTime,
                dueDate,
                completenceStatus,
                userDto
        );
    }
}
