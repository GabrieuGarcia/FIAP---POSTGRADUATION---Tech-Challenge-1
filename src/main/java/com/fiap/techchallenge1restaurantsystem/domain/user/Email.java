package com.fiap.techchallenge1restaurantsystem.domain.user;

import com.fiap.techchallenge1restaurantsystem.domain.shared.ValueObject;

import java.util.Objects;

public class Email implements ValueObject {

    private final String email;

    public Email(String email) {
        this.email = email;
    }

    public String getValue() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email other = (Email) o;
        return Objects.equals(email, other.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

}
