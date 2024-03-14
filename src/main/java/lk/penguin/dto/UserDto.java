package lk.penguin.dto;

import lk.penguin.entity.Admin;
import lk.penguin.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
    private int userId;
    private String name;
    private int userLoginId;
    private String contact;
    private String userEmail;
    private String userPassword;
    private Admin admin;

    public User toEntity() {
        return new User(
                this.userId,
                this.name,
                this.userLoginId,
                this.contact,
                this.userEmail,
                this.userPassword,
                this.admin
        );
    }
}
