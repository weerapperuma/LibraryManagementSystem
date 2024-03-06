package lk.penguin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminDTO {
    private int adminID;
    private int adminLoginID;
    private String adminName;
    private String address;
    private String email;
    private String password;
}
