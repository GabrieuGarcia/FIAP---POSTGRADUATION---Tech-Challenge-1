package com.fiap.techChallenge1.domain.user;

import com.fiap.techChallenge1.domain.shared.ValueObject;

import java.util.Objects;

public class Address implements ValueObject {

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

    public String getStreet() { return street; }
    public String getNumber() { return number; }
    public String getCity() { return city; }
    public String getPostalCode() { return postalCode; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address other = (Address) o;
        return Objects.equals(street, other.street)
                && Objects.equals(number, other.number)
                && Objects.equals(city, other.city)
                && Objects.equals(postalCode, other.postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, number, city, postalCode);
    }
}
