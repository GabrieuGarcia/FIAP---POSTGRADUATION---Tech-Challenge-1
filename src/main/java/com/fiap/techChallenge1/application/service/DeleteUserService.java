package com.fiap.techChallenge1.application.service;

import com.fiap.techChallenge1.application.port.in.usecases.DeleteUserUseCase;
import com.fiap.techChallenge1.application.port.out.UserRepositoryPort;
import com.fiap.techChallenge1.domain.user.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteUserService implements DeleteUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public DeleteUserService(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public void deleteUser(UUID userId) {
        userRepositoryPort.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        userRepositoryPort.deleteById(userId);
    }
}
