package com.fiap.techchallenge1restaurantsystem.application.port.in;

import com.fiap.techchallenge1restaurantsystem.domain.user.Address;
import com.fiap.techchallenge1restaurantsystem.domain.user.Email;

import java.util.UUID;

public record UpdateUserCommand(
        UUID userId,
        String name,
        Email email,
        String login,
        Address address
) {
}
