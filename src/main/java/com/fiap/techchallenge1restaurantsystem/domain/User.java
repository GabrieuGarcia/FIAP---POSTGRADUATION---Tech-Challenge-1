package com.fiap.techchallenge1restaurantsystem.domain;

import java.util.Date;

public class User {

    private final String name;
    private final String email;
    private final String login;
    private final String password;
    private final Date lastUpdate;
    private final Address address;

    public User(String name,
                String email,
                String login,
                String password,
                Date lastUpdate,
                Address address) {
        this.name = name;
        this.email = email;
        this.login = login;
        this.password = password;
        this.lastUpdate = lastUpdate;
        this.address = address;
    }
}
