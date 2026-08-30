package com.fiap.techchallenge1restaurantsystem.domain.user;

import com.fiap.techchallenge1restaurantsystem.domain.shared.AggregateRoot;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class User extends AggregateRoot<UUID> {

    private final String name;
    private final Email email;
    private final Password password;
    private final Address address;
    private final UserType userType;

    public User(UUID id,
                String name,
                Email email,
                Password password,
                Address address,
                UserType userType) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = Objects.requireNonNull(password, "password is required");
        this.address = Objects.requireNonNull(address, "address is required");
        this.userType = Objects.requireNonNull(userType, "userType is required");
    }
}
