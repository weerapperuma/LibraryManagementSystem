package lk.penguin.service.custom;

import lk.penguin.dto.UserDto;
import lk.penguin.service.SuperService;

public interface CreateSignUpService extends SuperService {
    int saveNewUser(UserDto userDto);
}
