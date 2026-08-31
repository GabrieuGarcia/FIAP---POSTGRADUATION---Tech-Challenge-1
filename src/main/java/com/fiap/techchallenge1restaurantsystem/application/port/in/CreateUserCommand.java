package com.fiap.techchallenge1restaurantsystem.application.port.in;

import com.fiap.techchallenge1restaurantsystem.domain.user.Address;
import com.fiap.techchallenge1restaurantsystem.domain.user.Email;
import com.fiap.techchallenge1restaurantsystem.domain.user.Password;
import com.fiap.techchallenge1restaurantsystem.domain.user.UserType;

public record CreateUserCommand(
        String name,
        Email email,
        Password password,
        Address address,
        UserType userType
) {
}
