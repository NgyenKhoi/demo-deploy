package com.example.HSF302_DE190699.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sony_accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accountid", nullable = false)
    private Integer id;

    @Column(name = "full_name", nullable = false)
    private String fullName;


    @Column(name = "password", nullable = false)
    private String password;



    @Column(name = "phone", nullable = false)
    private String phone;


    @Column(name = "role_id", nullable = false)
    private Integer roleID;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "email", nullable = false)
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}