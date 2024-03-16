package lk.penguin.entity;

import lk.penguin.dto.AdminDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private int adminID;

    @Column(name = "admin_loginId",nullable = false)
    private int adminLoginID;
    @Column(name = "admin_name")
    private String adminName;
    @Column(name = "address")
    private String address;
    @Column(name = "email",nullable = false,unique = true)
    private String email;
    @Column(name = "password",nullable = false)
    private String password;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "admin")
    private List<Branch>branches=new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,
    fetch = FetchType.LAZY,
    mappedBy = "admin")
    private List<Books>books=new ArrayList<>();


    public Admin(int adminID, int adminLoginID, String adminName, String address, String email, String password) {
        this.adminID=adminID;
        this.adminLoginID=adminLoginID;
        this.adminName=adminName;
        this.address=address;
        this.email=email;
        this.password=password;
    }

    public AdminDto toEntity() {
        return new AdminDto(
                adminID,
                adminLoginID,
                adminName,
                address,
                email,
                password
        );
    }
}

