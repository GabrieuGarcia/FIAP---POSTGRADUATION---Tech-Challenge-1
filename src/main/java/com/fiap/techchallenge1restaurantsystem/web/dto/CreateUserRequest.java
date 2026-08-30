package com.fiap.techchallenge1restaurantsystem.web.dto;

import com.fiap.techchallenge1restaurantsystem.domain.user.Address;
import com.fiap.techchallenge1restaurantsystem.domain.user.Email;
import com.fiap.techchallenge1restaurantsystem.domain.user.Password;
import com.fiap.techchallenge1restaurantsystem.domain.user.UserType;

public record CreateUserRequest(
        String name,
        Email email,
        Password password,
        Address address,
        UserType userType
) {
}
