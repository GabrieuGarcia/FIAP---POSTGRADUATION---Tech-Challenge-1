package com.fiap.techchallenge1restaurantsystem.adapter.in.web.dto;

import com.fiap.techchallenge1restaurantsystem.application.port.in.ChangePasswordCommand;
import com.fiap.techchallenge1restaurantsystem.domain.user.Password;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ChangePasswordRequest(
        @NotNull(message = "currentPassword is required") Password currentPassword,
        @NotNull(message = "newPassword is required") Password newPassword
) {

    public ChangePasswordCommand toCommand(UUID userId) {
        return new ChangePasswordCommand(userId, currentPassword, newPassword);
    }
}
