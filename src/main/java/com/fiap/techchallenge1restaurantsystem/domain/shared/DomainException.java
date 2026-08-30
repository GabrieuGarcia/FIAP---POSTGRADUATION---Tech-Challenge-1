package com.fiap.techchallenge1restaurantsystem.domain.shared;

public abstract class DomainException extends RuntimeException {

    protected DomainException(String message) {
        super(message);
    }
}
