package lk.penguin.projection;

import lk.penguin.entity.Admin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserProjection {
    private int userId;
    private String userName;
    private String userEmail;
    private String contact;
    private int admin;
}
