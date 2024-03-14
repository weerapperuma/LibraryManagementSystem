package lk.penguin.repository.custom.impl;

import lk.penguin.dto.TransactionDto;
import lk.penguin.entity.Transaction;
import lk.penguin.repository.custom.TransactionRepository;
import org.hibernate.Session;

import java.util.ArrayList;

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
        return null;
    }

    @Override
    public int save(Transaction entity) {
        return (int) session.save(entity);
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(Transaction entity) {
        return false;
    }
}
