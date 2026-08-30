package com.fiap.techchallenge1restaurantsystem.web.dto;

import com.fiap.techchallenge1restaurantsystem.domain.user.Address;

import java.util.Date;

public record CreateUserRequest(
        String name,
        String email,
        String login,
        String password,
        Date lastUpdate,
        Address address
) {
}
