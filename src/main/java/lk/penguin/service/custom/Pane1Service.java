package lk.penguin.service.custom;

import lk.penguin.dto.TransactionDto;
import lk.penguin.dto.UserDto;
import lk.penguin.entity.User;
import lk.penguin.service.SuperService;

public interface Pane1Service extends SuperService {
    UserDto isExistsUser(String text, String text1);

    int save(TransactionDto transactionDto);
}
