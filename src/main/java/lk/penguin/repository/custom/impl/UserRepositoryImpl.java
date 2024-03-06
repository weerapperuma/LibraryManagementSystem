package lk.penguin.repository.custom.impl;

import lk.penguin.entity.User;
import lk.penguin.repository.custom.UserRepository;
import lk.penguin.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserRepositoryImpl implements UserRepository {
    private final Session session;

    public UserRepositoryImpl(){
        session= SessionFactoryConfig.getInstance().getSession();
    }
    @Override
    public boolean save(User user) {
        Transaction transaction=null;
        try{
            transaction= session.beginTransaction();
            session.save(user);
            transaction.commit();
            System.out.println("Coommited");
            return true;
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }

    }
}
