package lk.penguin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "branch")
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
}
