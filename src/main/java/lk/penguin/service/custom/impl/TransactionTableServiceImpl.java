package lk.penguin.service.custom.impl;

import lk.penguin.dto.TransactionDto;
import lk.penguin.entity.Transaction;
import lk.penguin.repository.RepositoryFactory;
import lk.penguin.repository.custom.TransactionDetailRepository;
import lk.penguin.repository.custom.TransactionRepository;
import lk.penguin.repository.custom.impl.TransactionRepositoryImpl;
import lk.penguin.service.custom.TransactionTableService;
import lk.penguin.util.SessionFactoryConfig;
import org.hibernate.Session;

import java.util.ArrayList;

public class TransactionTableServiceImpl implements TransactionTableService {
    private Session session;
    TransactionRepository transactionRepository= (TransactionRepositoryImpl) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryType.TRANSACTION);
    @Override
    public ArrayList<TransactionDto> getAllTransactions() {
        session= SessionFactoryConfig.getInstance().getSession();
        try{
            transactionRepository.setSession(session);
            ArrayList<Transaction> transactionArrayList = transactionRepository.getAll();
            ArrayList<TransactionDto> transactionDtos=new ArrayList<>();

            for(Transaction transaction:transactionArrayList){
                transactionDtos.add(transaction.toDto());
            }
            return transactionDtos;
        }catch (Exception e){
            e.printStackTrace();
            session.close();
            return null;
        }finally {
            session.close();
        }
    }
}
