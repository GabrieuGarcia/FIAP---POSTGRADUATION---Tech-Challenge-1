package com.fiap.techchallenge1restaurantsystem.web.dto;

import com.fiap.techchallenge1restaurantsystem.domain.user.Email;
import com.fiap.techchallenge1restaurantsystem.domain.user.Password;

public record LoginRequest(
        Email email,
        Password password
) {
}
