package com.fiap.techchallenge1restaurantsystem.adapter.in.web.dto;

import com.fiap.techchallenge1restaurantsystem.domain.user.User;

import java.util.UUID;

public record UserResponse(
        UUID id,
        String name,
        String email,
        String userType
) {

    public static UserResponse from(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail().getValue(),
                user.getUserType().name()
        );
    }
}
