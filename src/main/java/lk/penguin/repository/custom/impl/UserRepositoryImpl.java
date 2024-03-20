package lk.penguin.repository.custom.impl;

import lk.penguin.entity.User;
import lk.penguin.projection.UserProjection;
import lk.penguin.repository.custom.UserRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private Session session;
    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public int save(User user) {
        int save = (int) session.save(user);
        return save;

    }

    @Override
    public void delete(int id) {
        User user=session.get(User.class,id);
        session.delete(user);
    }

    @Override
    public void update(User entity) {
        session.update(entity);
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
        Query<User> fromUser = session.createQuery("from User ", User.class);
        List<User> list = fromUser.list();
        return (ArrayList<User>) list;
    }

    @Override
    public ArrayList<UserProjection> getAllUserProjection(){
        String hql = "SELECT " +
                "new lk.penguin.projection.UserProjection(u.userId,u.userName,u.userEmail,u.contact,u.admin.adminID)" +
                "FROM User AS u";

        Query query = session.createQuery(hql);
        List list = query.list();
        return (ArrayList<UserProjection>) list;
    }
}
