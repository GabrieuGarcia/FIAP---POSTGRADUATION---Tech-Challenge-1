package com.fiap.techchallenge1restaurantsystem.domain;

public class Address {

    private final String street;
    private final String number;
    private final String city;
    private final String postalCode;

    public Address(String street,
                   String number,
                   String city,
                   String postalCode) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.postalCode = postalCode;
    }
}
