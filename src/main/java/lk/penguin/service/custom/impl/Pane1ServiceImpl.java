package lk.penguin.service.custom.impl;

import lk.penguin.dto.TransactionDto;
import lk.penguin.dto.UserDto;
import lk.penguin.entity.User;
import lk.penguin.repository.RepositoryFactory;
import lk.penguin.repository.custom.TransactionRepository;
import lk.penguin.repository.custom.UserRepository;
import lk.penguin.repository.custom.impl.TransactionRepositoryImpl;
import lk.penguin.repository.custom.impl.UserRepositoryImpl;
import lk.penguin.service.custom.Pane1Service;
import lk.penguin.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Pane1ServiceImpl implements Pane1Service {
    public static Session session;
    UserRepository userRepository= (UserRepositoryImpl) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryType.USER);
    TransactionRepository transactionRepository= (TransactionRepositoryImpl) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryType.TRANSACTION);
    @Override
    public UserDto isExistsUser(String text, String text1) {
        session= SessionFactoryConfig.getInstance().getSession();
        try{
            userRepository.setSession(session);
            User user=userRepository.ifExists(text);

            if(user.getUserPassword().equals(text1)){
                return user.toDto();
            }
            else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        finally {
            session.close();
        }
    }

    @Override
    public int save(TransactionDto transactionDto) {
        session=SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            transactionRepository.setSession(session);
            int save = transactionRepository.save(transactionDto.toEntity());
            return save;

        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            return 0;
        }
    }
}
