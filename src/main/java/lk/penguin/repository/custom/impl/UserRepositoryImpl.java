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
        Integer id=Integer.valueOf(userId);
        User user= (User) session.createQuery("FROM User WHERE userLoginId = :userLoginID")
                .setParameter("userLoginID",id)
                .uniqueResult();
        return user;
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
