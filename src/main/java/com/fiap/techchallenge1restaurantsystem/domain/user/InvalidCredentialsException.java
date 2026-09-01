package com.fiap.techchallenge1restaurantsystem.domain.user;

import com.fiap.techchallenge1restaurantsystem.domain.shared.DomainException;

public class InvalidCredentialsException extends DomainException {

    public InvalidCredentialsException(String message) {
        super(message);
    }
}
