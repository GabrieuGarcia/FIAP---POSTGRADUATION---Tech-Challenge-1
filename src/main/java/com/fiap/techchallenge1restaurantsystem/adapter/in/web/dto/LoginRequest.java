package com.fiap.techchallenge1restaurantsystem.adapter.in.web.dto;

import com.fiap.techchallenge1restaurantsystem.application.port.in.LoginCommand;
import com.fiap.techchallenge1restaurantsystem.domain.user.Email;
import com.fiap.techchallenge1restaurantsystem.domain.user.Password;

public record LoginRequest(
        Email email,
        Password password
) {

    public LoginCommand toCommand() {
        return new LoginCommand(email, password);
    }
}
