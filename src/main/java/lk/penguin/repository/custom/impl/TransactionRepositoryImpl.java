package lk.penguin.repository.custom.impl;

import lk.penguin.dto.BranchDto;
import lk.penguin.entity.Transaction;
import lk.penguin.repository.custom.TransactionRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepositoryImpl implements TransactionRepository {
    private Session session;
    @Override
    public void setSession(Session session) {
        this.session=session;
    }

    @Override
    public Transaction ifExists(String id) {
        return null;
    }

    @Override
    public ArrayList<Transaction> getAll() {
        Query<Transaction> fromTransaction = session.createQuery("from Transaction ", Transaction.class);
        List<Transaction> list = fromTransaction.list();
        return (ArrayList<Transaction>) list;
    }

    @Override
    public int save(Transaction entity) {
        return (int) session.save(entity);
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public void update(Transaction entity) {
    }
}
