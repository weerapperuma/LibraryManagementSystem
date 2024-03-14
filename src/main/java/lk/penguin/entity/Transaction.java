package lk.penguin.entity;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private int transactionId;
    @Column(name = "order_time")
    private Date orderTime;
    @Column(name = "due_date")
    private Date dueDate;
    @Column(name = "completence_status")
    private String completenceStatus;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
