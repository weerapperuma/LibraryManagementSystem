package lk.penguin.dto;

import lk.penguin.entity.Admin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminDto {
    private int adminID;
    private int adminLoginID;
    private String adminName;
    private String address;
    private String email;
    private String password;

    public Admin toEntity(){
        return new Admin(
                adminID,
                adminLoginID,
                adminName,
                address,
                email,
                password
        );

    }
}
