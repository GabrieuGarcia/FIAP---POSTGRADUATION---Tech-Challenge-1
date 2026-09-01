package com.fiap.techchallenge1restaurantsystem.domain.user;

import com.fiap.techchallenge1restaurantsystem.domain.shared.DomainException;

import java.util.UUID;

public class UserNotFoundException extends DomainException {

    public UserNotFoundException(UUID id) {
        super("User not found: " + id);
    }
}
