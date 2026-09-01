package com.fiap.techchallenge1restaurantsystem.domain.user;

import com.fiap.techchallenge1restaurantsystem.domain.shared.DomainException;

public class LoginAlreadyInUseException extends DomainException {

    public LoginAlreadyInUseException(String login) {
        super("Login already in use: " + login);
    }
}
