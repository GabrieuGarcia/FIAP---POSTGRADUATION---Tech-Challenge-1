package com.fiap.techChallenge1.application.port.in.command;

import com.fiap.techChallenge1.domain.user.Address;
import com.fiap.techChallenge1.domain.user.Email;
import com.fiap.techChallenge1.domain.user.Password;
import com.fiap.techChallenge1.domain.user.UserType;

public record CreateUserCommand(
        String name,
        Email email,
        String login,
        Password password,
        Address address,
        UserType userType
) {
}
