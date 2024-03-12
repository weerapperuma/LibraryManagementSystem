package lk.penguin.repository.custom.impl;

import lk.penguin.entity.Branch;
import lk.penguin.repository.custom.BranchRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class BranchRepositoryImpl implements BranchRepository {
    private Session session;
    @Override
    public void setSession(Session session) {
        this.session=session;
    }

    @Override
    public int save(Branch entity) {
        return (int) session.save(entity);
    }

    @Override
    public void update(Branch entity) {
         session.update(entity);
    }

    @Override
    public List<Branch> getAll() {
        String hql="SELECT b FROM Branch b";
        Query<Branch> query = session.createQuery(hql, Branch.class);
        return query.list();
    }

    @Override
    public Branch get(int id) {
        return session.get(Branch.class,id);
    }

    @Override
    public void delete(Branch entity) {
        session.delete(entity);
    }
}
