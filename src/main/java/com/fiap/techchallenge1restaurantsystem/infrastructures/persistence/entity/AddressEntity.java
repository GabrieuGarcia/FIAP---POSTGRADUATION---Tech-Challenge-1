package com.fiap.techchallenge1restaurantsystem.infrastructures.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "Address")
public class AddressEntity {

    private UUID id;
    private String street;
    private String number;
    private String city;
    private String postalCode;

}
