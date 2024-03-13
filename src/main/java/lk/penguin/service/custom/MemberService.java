package lk.penguin.service.custom;

import lk.penguin.dto.UserDto;
import lk.penguin.service.SuperService;

import java.util.List;

public interface MemberService extends SuperService {
    List<UserDto> getAllMembers();
}
