package lk.penguin.dto;

import lk.penguin.entity.Admin;
import lk.penguin.entity.Branch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BranchDto {
    private int branchId;
    private String branchName;
    private String branchDistrict;
    private String branchContactNb;
    private String branchAvailability;
    private Admin admin;

    public Branch toEntity() {
        return new Branch(
                branchId,
                branchName,
                branchDistrict,
                branchContactNb,
                branchAvailability,
                admin
        );
    }
}
