package lk.penguin.service.custom;

import lk.penguin.dto.TransactionDto;
import lk.penguin.service.SuperService;

import java.util.ArrayList;

public interface TransactionTableService extends SuperService {
    ArrayList<TransactionDto> getAllTransactions();
}
