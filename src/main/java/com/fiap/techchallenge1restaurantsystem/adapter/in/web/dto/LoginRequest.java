package com.fiap.techchallenge1restaurantsystem.adapter.in.web.dto;

import com.fiap.techchallenge1restaurantsystem.application.port.in.LoginCommand;
import com.fiap.techchallenge1restaurantsystem.domain.user.Password;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LoginRequest(
        @NotBlank(message = "login is required") String login,
        @NotNull(message = "password is required") Password password
) {

    public LoginCommand toCommand() {
        return new LoginCommand(login, password);
    }
}
