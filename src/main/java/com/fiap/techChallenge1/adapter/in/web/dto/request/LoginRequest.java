package com.fiap.techChallenge1.adapter.in.web.dto.request;

import com.fiap.techChallenge1.application.port.in.command.LoginCommand;
import com.fiap.techChallenge1.domain.user.Password;
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
