package com.fiap.techChallenge1.adapter.in.web.dto.request;

import com.fiap.techChallenge1.application.port.in.command.ChangePasswordCommand;
import com.fiap.techChallenge1.domain.user.Password;
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
