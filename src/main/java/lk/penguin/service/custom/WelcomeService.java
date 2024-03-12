package lk.penguin.service.custom;

import lk.penguin.dto.UserDto;
import lk.penguin.entity.Admin;
import lk.penguin.service.SuperService;

public interface WelcomeService extends SuperService {

    boolean chekAdmin(String userId, String password);

    boolean chekMember(String userId, String password);

    boolean saveUser(UserDto userDTO);

    Admin getAdmin(String userId);
}
