package com.fiap.techchallenge1restaurantsystem.domain.user;

import com.fiap.techchallenge1restaurantsystem.domain.shared.DomainException;

public class EmailAlreadyInUseException extends DomainException {

    public EmailAlreadyInUseException(String email) {
        super("Email already in use: " + email);
    }
}
