package lk.penguin.repository.custom.impl;

import lk.penguin.entity.User;
import lk.penguin.repository.custom.MemberRepository;
import org.hibernate.Session;

import java.util.ArrayList;

public class MemberRepositoryImpl implements MemberRepository {
    private Session session;
    @Override
    public void setSession(Session session) {
        this.session=session;
    }

    @Override
    public User ifExists(String id) {
        return null;
    }

    @Override
    public ArrayList<User> getAll() {
        return null;
    }

    @Override
    public Long save(User entity) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(User entity) {
        return false;
    }
}
