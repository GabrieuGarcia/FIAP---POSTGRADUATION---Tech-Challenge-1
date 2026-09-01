package com.fiap.techchallenge1restaurantsystem.adapter.in.web.dto.request;

import com.fiap.techchallenge1restaurantsystem.application.port.in.command.UpdateUserCommand;
import com.fiap.techchallenge1restaurantsystem.domain.user.Address;
import com.fiap.techchallenge1restaurantsystem.domain.user.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record UpdateUserRequest(
        @NotBlank(message = "name is required") String name,
        @NotNull(message = "email is required") Email email,
        @NotBlank(message = "login is required") String login,
        @NotNull(message = "address is required") Address address
) {

    public UpdateUserCommand toCommand(UUID userId) {
        return new UpdateUserCommand(userId, name, email, login, address);
    }
}
