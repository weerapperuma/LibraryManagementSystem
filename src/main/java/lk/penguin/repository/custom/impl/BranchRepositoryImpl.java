package lk.penguin.repository.custom.impl;

import lk.penguin.dto.BranchDto;
import lk.penguin.entity.Branch;
import lk.penguin.repository.custom.BranchRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;

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
    public void delete(int id) {
        Branch branch=session.get(Branch.class,id);
        session.delete(branch);
    }


    @Override
    public void update(Branch entity) {
         session.update(entity);
    }

    @Override
    public Branch ifExists(String id) {
        return null;
    }

    @Override
    public ArrayList<Branch> getAll() {
        String hql="SELECT b FROM Branch b";
        Query<Branch> query = session.createQuery(hql, Branch.class);
        return (ArrayList<Branch>) query.list();
    }
}
