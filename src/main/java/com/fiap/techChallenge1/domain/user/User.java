package com.fiap.techChallenge1.domain.user;

import com.fiap.techChallenge1.domain.shared.AggregateRoot;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class User extends AggregateRoot<UUID> {

    private String name;
    private Email email;
    private String login;
    private Password password;
    private Address address;
    private final UserType userType;
    private Date lastModifiedDate;

    public User(UUID id,
                String name,
                Email email,
                String login,
                Password password,
                Address address,
                UserType userType,
                Date lastModifiedDate) {
        super(id);
        this.name = Objects.requireNonNull(name, "name is required");
        this.email = Objects.requireNonNull(email, "email is required");
        this.login = Objects.requireNonNull(login, "login is required");
        this.password = Objects.requireNonNull(password, "password is required");
        this.address = Objects.requireNonNull(address, "address is required");
        this.userType = Objects.requireNonNull(userType, "userType is required");
        this.lastModifiedDate = lastModifiedDate;
    }

    public void updateInfo(String name, Email email, String login, Address address) {
        this.name = Objects.requireNonNull(name, "name is required");
        this.email = Objects.requireNonNull(email, "email is required");
        this.login = Objects.requireNonNull(login, "login is required");
        this.address = Objects.requireNonNull(address, "address is required");
        this.lastModifiedDate = new Date();
    }

    public void changePassword(Password currentPassword, Password newPassword, PasswordEncoderPort encoder) {
        this.password = this.password.changeTo(currentPassword, newPassword, encoder);
        this.lastModifiedDate = new Date();
    }

    public boolean authenticate(Password candidate, PasswordEncoderPort encoder) {
        return this.password.matches(candidate, encoder);
    }

    public String getName() { return name; }
    public Email getEmail() { return email; }
    public String getLogin() { return login; }
    public Password getPassword() { return password; }
    public Address getAddress() { return address; }
    public UserType getUserType() { return userType; }
    public Date getLastModifiedDate() { return lastModifiedDate; }
}
