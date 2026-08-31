package com.fiap.techchallenge1restaurantsystem.application.port.in;

import com.fiap.techchallenge1restaurantsystem.domain.user.Email;
import com.fiap.techchallenge1restaurantsystem.domain.user.Password;

public record LoginCommand(
        Email email,
        Password password
) {
}
