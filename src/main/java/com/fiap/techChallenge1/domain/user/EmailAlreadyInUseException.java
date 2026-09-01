package com.fiap.techChallenge1.domain.user;

import com.fiap.techChallenge1.domain.shared.DomainException;

public class EmailAlreadyInUseException extends DomainException {

    public EmailAlreadyInUseException(String email) {
        super("Email already in use: " + email);
    }
}
