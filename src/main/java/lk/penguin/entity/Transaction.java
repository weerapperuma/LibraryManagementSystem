package lk.penguin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
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
}
