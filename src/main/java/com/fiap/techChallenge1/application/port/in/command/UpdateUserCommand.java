package com.fiap.techChallenge1.application.port.in.command;

import com.fiap.techChallenge1.domain.user.Address;
import com.fiap.techChallenge1.domain.user.Email;

import java.util.UUID;

public record UpdateUserCommand(
        UUID userId,
        String name,
        Email email,
        String login,
        Address address
) {
}
