package lk.penguin.entity;

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




}








/*
CREATE TABLE admin(
        admin_id int primary key not null,
        admin_name varchar(20),
        address varchar(100),
        email varchar(50),
        password varchar(30));

INSERT INTO admin VALUES (1,'sahan janapriya','galle','sahanjanapriya@galle.com','123w');*/
