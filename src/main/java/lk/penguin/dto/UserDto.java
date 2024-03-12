package lk.penguin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
    private int userId;
    private String name;
    private String userName;
    private String contact;
    private String userEmail;
    private String userPassword;
}
