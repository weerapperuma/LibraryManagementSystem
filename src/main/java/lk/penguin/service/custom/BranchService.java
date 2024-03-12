package lk.penguin.service.custom;

import lk.penguin.dto.BranchDto;
import lk.penguin.service.SuperService;

import java.util.List;

public interface BranchService extends SuperService {
    int save(BranchDto branchDto);

    boolean update(BranchDto branchDto);

    List<BranchDto> getAllBranches();

    boolean deleteBranch(int id);
}
