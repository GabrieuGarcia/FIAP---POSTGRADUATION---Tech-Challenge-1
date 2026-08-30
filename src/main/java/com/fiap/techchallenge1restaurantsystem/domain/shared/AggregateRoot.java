package com.fiap.techchallenge1restaurantsystem.domain.shared;

public abstract class AggregateRoot<ID> extends IdentityObject<ID> {

    protected AggregateRoot(ID id) {
        super(id);
    }
}
