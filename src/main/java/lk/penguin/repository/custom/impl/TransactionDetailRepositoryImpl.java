package lk.penguin.repository.custom.impl;

import lk.penguin.dto.BranchDto;
import lk.penguin.entity.TransactionDetail;
import lk.penguin.repository.custom.TransactionDetailRepository;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.ArrayList;

public class TransactionDetailRepositoryImpl implements TransactionDetailRepository {
    private Session session;
    @Override
    public void setSession(Session session) {
        this.session=session;
    }


    @Override
    public TransactionDetail ifExists(String id) {
        return null;
    }

    @Override
    public ArrayList<TransactionDetail> getAll() {
        return null;
    }

    @Override
    public int save(TransactionDetail entity) {
        session.save(entity);
        return 0;
    }
    @Override
    public void delete(int id){}

    @Override
    public void update(TransactionDetail entity) {
    }
}
