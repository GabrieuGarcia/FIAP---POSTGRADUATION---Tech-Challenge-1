package com.fiap.techchallenge1restaurantsystem.application.service;

import com.fiap.techchallenge1restaurantsystem.application.port.in.DeleteUserUseCase;
import com.fiap.techchallenge1restaurantsystem.application.port.out.UserRepositoryPort;
import com.fiap.techchallenge1restaurantsystem.domain.user.UserNotFoundException;
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
