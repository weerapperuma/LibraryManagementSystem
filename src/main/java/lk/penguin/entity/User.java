package lk.penguin.entity;

import lk.penguin.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    @Column(name="login_id")
    private int userLoginId;

    @Column(name = "contact")
    private String contact;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_password")
    private String userPassword;

    public UserDto toDto() {
        return new UserDto(
                userId,
                userName,
                userLoginId,
                contact,
                userEmail,
                userPassword
        );
    }
}
