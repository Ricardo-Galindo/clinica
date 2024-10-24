package com.Squad03.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.UUID;


@Entity
@Table(name = "Users")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    @NotBlank()
    private String name;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(nullable = false)
    private UserType userType;

    @Column(nullable = false,unique = true,length = 255)
    @Email()
    @NotBlank()
    private String email;
    @Column(nullable = false,length = 30)
    @NotBlank()
    private String password;
    @NotBlank
    @Pattern(regexp = "^\\([1-9]{2}\\) 9[1-9][0-9]{3}-[0-9]{4}$", message = "Número de celular inválido")
    @Column(nullable = false,length = 20)
    private String phone;

    @Column(nullable = true)
    private String created_by;

    public String getCreatedBy() {
        return created_by;
    }

    public void setCreatedBy(String created_by) {
        this.created_by = created_by;
    }

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
