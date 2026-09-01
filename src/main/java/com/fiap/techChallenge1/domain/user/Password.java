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

    public boolean matches(Password rawCandidate, PasswordEncoderPort encoder) {
        return encoder.matches(rawCandidate, this);
    }

    public Password changeTo(Password currentRawPassword, Password newRawPassword, PasswordEncoderPort encoder) {
        if (!matches(currentRawPassword, encoder)) {
            throw new InvalidCredentialsException("Current password does not match");
        }
        Objects.requireNonNull(newRawPassword, "newPassword is required");
        return encoder.encode(newRawPassword);
    }

    public Password encode(PasswordEncoderPort encoder) {
        return encoder.encode(this);
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
