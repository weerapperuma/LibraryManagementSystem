package lk.penguin.dto;

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
}
