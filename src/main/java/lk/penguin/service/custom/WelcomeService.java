package lk.penguin.service.custom;

import lk.penguin.dto.UserDTO;
import lk.penguin.service.SuperService;

public interface WelcomeService extends SuperService {

    boolean chekAdmin(String userId, String password);

    boolean chekMember(String userId, String password);

    boolean saveUser(UserDTO userDTO);
}
