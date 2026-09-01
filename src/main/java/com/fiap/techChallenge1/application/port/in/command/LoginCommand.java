package com.fiap.techChallenge1.application.port.in.command;

import com.fiap.techChallenge1.domain.user.Password;

public record LoginCommand(
        String login,
        Password password
) {
}
