package com.fiap.techchallenge1restaurantsystem.adapter.in.web.dto;

import com.fiap.techchallenge1restaurantsystem.application.port.in.CreateUserCommand;
import com.fiap.techchallenge1restaurantsystem.domain.user.Address;
import com.fiap.techchallenge1restaurantsystem.domain.user.Email;
import com.fiap.techchallenge1restaurantsystem.domain.user.Password;
import com.fiap.techchallenge1restaurantsystem.domain.user.UserType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateUserRequest(
        @NotBlank(message = "name is required") String name,
        @NotNull(message = "email is required") Email email,
        @NotBlank(message = "login is required") String login,
        @NotNull(message = "password is required") Password password,
        @NotNull(message = "address is required") Address address,
        @NotNull(message = "userType is required") UserType userType
) {

    public CreateUserCommand toCommand() {
        return new CreateUserCommand(name, email, login, password, address, userType);
    }
}
