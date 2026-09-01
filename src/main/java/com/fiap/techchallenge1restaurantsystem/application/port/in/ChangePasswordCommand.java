package com.fiap.techchallenge1restaurantsystem.application.port.in;

import com.fiap.techchallenge1restaurantsystem.domain.user.Password;

import java.util.UUID;

public record ChangePasswordCommand(
        UUID userId,
        Password currentPassword,
        Password newPassword
) {
}
