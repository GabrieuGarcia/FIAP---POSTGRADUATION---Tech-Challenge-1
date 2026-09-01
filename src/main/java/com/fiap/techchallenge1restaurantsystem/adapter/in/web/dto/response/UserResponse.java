package com.fiap.techchallenge1restaurantsystem.adapter.in.web.dto.response;

import com.fiap.techchallenge1restaurantsystem.domain.user.User;

import java.util.Date;
import java.util.UUID;

public record UserResponse(
        UUID id,
        String name,
        String email,
        String login,
        AddressResponse address,
        String userType,
        Date lastModifiedDate
) {

    public static UserResponse from(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail().getValue(),
                user.getLogin(),
                AddressResponse.from(user.getAddress()),
                user.getUserType().name(),
                user.getLastModifiedDate()
        );
    }
}
