package com.fiap.techChallenge1.domain.user;

import com.fiap.techChallenge1.domain.shared.DomainException;

import java.util.UUID;

public class UserNotFoundException extends DomainException {

    public UserNotFoundException(UUID id) {
        super("User not found: " + id);
    }
}
