package com.fiap.techChallenge1.domain.user;

import com.fiap.techChallenge1.domain.shared.DomainException;

public class LoginAlreadyInUseException extends DomainException {

    public LoginAlreadyInUseException(String login) {
        super("Login already in use: " + login);
    }
}
