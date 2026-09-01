package com.fiap.techchallenge1restaurantsystem.application.port.in.command;

import com.fiap.techchallenge1restaurantsystem.domain.user.Password;

public record LoginCommand(
        String login,
        Password password
) {
}
