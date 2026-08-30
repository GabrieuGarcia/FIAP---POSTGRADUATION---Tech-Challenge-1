package com.fiap.techchallenge1restaurantsystem.domain.shared;

import java.util.Objects;

public abstract class IdentityObject<ID> {

    private final ID id;

    protected IdentityObject(ID id) {
        this.id = Objects.requireNonNull(id, "id must not be null");
    }

    public ID getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdentityObject<?> other = (IdentityObject<?>) o;
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass(), id);
    }
}
