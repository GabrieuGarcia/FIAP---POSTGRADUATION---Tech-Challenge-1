package com.fiap.techChallenge1.domain.user;

public interface PasswordEncoderPort {

    Password encode(Password rawPassword);

    boolean matches(Password rawCandidate, Password encodedPassword);
}
