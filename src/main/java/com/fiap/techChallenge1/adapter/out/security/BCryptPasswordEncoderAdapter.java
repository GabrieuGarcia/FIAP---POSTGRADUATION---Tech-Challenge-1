package com.fiap.techChallenge1.adapter.out.security;

import com.fiap.techChallenge1.domain.user.Password;
import com.fiap.techChallenge1.domain.user.PasswordEncoderPort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BCryptPasswordEncoderAdapter implements PasswordEncoderPort {

    private final PasswordEncoder passwordEncoder;

    public BCryptPasswordEncoderAdapter(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Password encode(Password rawPassword) {
        return new Password(passwordEncoder.encode(rawPassword.getValue()));
    }

    @Override
    public boolean matches(Password rawCandidate, Password encodedPassword) {
        return passwordEncoder.matches(rawCandidate.getValue(), encodedPassword.getValue());
    }
}
