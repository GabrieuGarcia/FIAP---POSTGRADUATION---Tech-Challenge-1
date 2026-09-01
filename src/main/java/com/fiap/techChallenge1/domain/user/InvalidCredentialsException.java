package com.fiap.techChallenge1.domain.user;

import com.fiap.techChallenge1.domain.shared.DomainException;

public class InvalidCredentialsException extends DomainException {

    public InvalidCredentialsException(String message) {
        super(message);
    }
}
