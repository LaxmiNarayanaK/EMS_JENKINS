package com.acme.ems.models;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "login")
@Data
public class Login {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empid")
    private int empid;

    @Column(name = "loginid")
    private String loginID;

    @Column(name = "username")
    String loginUsername;

    @Column(name = "password")
    String loginPassword;

    @Column(name = "loginstatus")
    String loginStatus;

    @OneToOne()
    @PrimaryKeyJoinColumn
    private Employee employee;


}
