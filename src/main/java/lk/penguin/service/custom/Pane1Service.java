package lk.penguin.service.custom;

import lk.penguin.dto.BooksDto;
import lk.penguin.dto.TransactionDto;
import lk.penguin.dto.UserDto;
import lk.penguin.service.SuperService;

import java.util.ArrayList;

public interface Pane1Service extends SuperService {
    UserDto isExistsUser(String text, String text1);
    boolean updateBookStatus(ArrayList<BooksDto> addedCartBookDtos);

    void commitTransactions(TransactionDto transactionDto, ArrayList<BooksDto> addedCartBookDtos);
}
