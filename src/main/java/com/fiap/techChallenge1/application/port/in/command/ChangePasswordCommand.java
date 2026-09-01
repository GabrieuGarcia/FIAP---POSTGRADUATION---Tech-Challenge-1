package com.fiap.techChallenge1.application.port.in.command;

import com.fiap.techChallenge1.domain.user.Password;

import java.util.UUID;

public record ChangePasswordCommand(
        UUID userId,
        Password currentPassword,
        Password newPassword
) {
}
