package lk.penguin.repository.custom.impl;

import lk.penguin.entity.User;
import lk.penguin.repository.custom.UserRepository;
import lk.penguin.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.ArrayList;

public class UserRepositoryImpl implements UserRepository {
    private Session session;

    @Override
    public int save(User user) {
        int save = (int) session.save(user);
        System.out.println(save);
        return save;

    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(User entity) {
        return false;
    }

    @Override
    public User ifExists(String userId) {
        try{
            Integer intUserId=Integer.valueOf(userId);
            User user=session.get(User.class,intUserId);

            if(user==null){
                return null;
            }
            return user;
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ArrayList<User> getAll() {
        return null;
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }
}
