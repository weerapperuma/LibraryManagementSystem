package lk.penguin.dto;

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

    public User toEntity() {
        return new User(
                userId,
                name,
                userLoginId,
                contact,
                userEmail,
                userPassword
        );
    }
}
