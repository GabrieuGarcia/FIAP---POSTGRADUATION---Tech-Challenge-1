package com.fiap.techChallenge1.adapter.in.web.dto.response;

public record LoginResponse(
        String token,
        String tokenType,
        UserResponse user
) {

    public static LoginResponse of(String token, UserResponse user) {
        return new LoginResponse(token, "Bearer", user);
    }
}
