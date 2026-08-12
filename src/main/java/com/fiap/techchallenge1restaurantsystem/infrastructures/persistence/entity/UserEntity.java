package com.fiap.techchallenge1restaurantsystem.infrastructures.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Users")
public class UserEntity {

    private String name;
    private String email;
    private String login;
    private String password;
    private Date lastUpdate;
    private AddressEntity address;

}
