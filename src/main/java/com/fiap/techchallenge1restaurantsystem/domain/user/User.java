package com.fiap.techchallenge1restaurantsystem.domain.user;

import com.fiap.techchallenge1restaurantsystem.domain.shared.AggregateRoot;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class User extends AggregateRoot<UUID> {

    private String name;
    private String email;
    private final String login;
    private Password password;
    private Date lastUpdate;
    private Address address;

    public User(UUID id,
                String name,
                String email,
                String login,
                Password password,
                Date lastUpdate,
                Address address) {
        super(id);
        this.name = name;
        this.email = email;
        this.login = login;
        this.password = Objects.requireNonNull(password, "password is required");
        this.lastUpdate = lastUpdate;
        this.address = Objects.requireNonNull(address, "address is required");
    }

    public void changeAddress(Address newAddress) {
        this.address = Objects.requireNonNull(newAddress, "address is required");
        this.lastUpdate = new Date();
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getLogin() { return login; }
    public Password getPassword() { return password; }
    public Date getLastUpdate() { return lastUpdate; }
    public Address getAddress() { return address; }
}
