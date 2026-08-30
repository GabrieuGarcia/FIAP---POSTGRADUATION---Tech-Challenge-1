package com.fiap.techchallenge1restaurantsystem.domain.user;

import com.fiap.techchallenge1restaurantsystem.domain.shared.ValueObject;

import java.util.Objects;

public class Password implements ValueObject {

    private final String password;

    public Password(String password) {
        this.password = password;
    }

    public String getValue() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Password other = (Password) o;
        return Objects.equals(password, other.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password);
    }
}
