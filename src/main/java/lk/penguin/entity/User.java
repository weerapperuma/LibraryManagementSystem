package lk.penguin.entity;

import lk.penguin.dto.AdminDto;
import lk.penguin.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name="login_id",unique = true)
    private int userLoginId;

    @Column(name = "contact")
    private String contact;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_password")
    private String userPassword;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "user")
    private List<Transaction> transactions=new ArrayList<>();

    public User(int userId, String name, int userLoginId, String contact, String userEmail, String userPassword, Admin admin) {
        this.userId=userId;
        this.userName=name;
        this.userLoginId=userLoginId;
        this.contact=contact;
        this.userEmail=userEmail;
        this.userPassword=userPassword;
        this.admin=admin;
    }


    public UserDto toDto() {
        AdminDto adminDto=admin.toEntity();
        return new UserDto(
                userId,
                userName,
                userLoginId,
                contact,
                userEmail,
                userPassword,
                adminDto
        );
    }
}
