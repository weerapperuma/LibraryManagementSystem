package lk.penguin.entity;

import lk.penguin.dto.BranchDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "branch")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branch_id")
    private int branchId;

    @Column(name = "branch_name")
    private String branchName;

    @Column(name = "branch_district")
    private String branchDistrict;

    @Column(name = "branch_contcat")
    private String branchContactNb;

    @Column(name = "branch_availability")
    private String branchAvailability;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    public BranchDto toDto() {
        return new BranchDto(
                branchId,
                branchName,
                branchDistrict,
                branchContactNb,
                branchAvailability,
                admin
        );
    }
}
