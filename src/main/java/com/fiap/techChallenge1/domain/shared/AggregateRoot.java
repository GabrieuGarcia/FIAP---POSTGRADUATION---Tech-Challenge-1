package com.fiap.techChallenge1.domain.shared;

public abstract class AggregateRoot<ID> extends IdentityObject<ID> {

    protected AggregateRoot(ID id) {
        super(id);
    }
}
