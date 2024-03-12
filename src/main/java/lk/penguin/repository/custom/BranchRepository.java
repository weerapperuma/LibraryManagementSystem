package lk.penguin.repository.custom;

import lk.penguin.entity.Branch;
import lk.penguin.repository.SuperRepository;

import java.util.List;

public interface BranchRepository extends SuperRepository {
    int save(Branch entity);

    void update(Branch entity);

    List<Branch> getAll();

    Branch get(int id);

    void delete(Branch entity);
}
