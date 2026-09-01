package com.fiap.techChallenge1.domain.user;

import com.fiap.techChallenge1.domain.shared.ValueObject;

import java.util.Objects;

public class Password implements ValueObject {

    private final String password;

    public Password(String password) {
        this.password = password;
    }

    public String getValue() {
        return password;
    }

    public boolean matches(Password candidate) {
        return this.equals(candidate);
    }

    public Password changeTo(Password currentPassword, Password newPassword) {
        if (!matches(currentPassword)) {
            throw new InvalidCredentialsException("Current password does not match");
        }
        return Objects.requireNonNull(newPassword, "newPassword is required");
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
