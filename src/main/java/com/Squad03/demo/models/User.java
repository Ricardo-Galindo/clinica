package com.Squad03.demo.models;

import jakarta.persistence.*;

import java.util.UUID;


@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserType userType;

    @Column(nullable = false,unique = true,length = 255)
    private String email;
    @Column(nullable = false,length = 30)
    private String password;

    @Column(nullable = false,length = 20)
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public enum UserType {
        PACIENTE,
        RESPONSAVEL,
        ALUNO,
        RECEPCIONISTA
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }


    public UUID getId() {
        return id;
    }


}
