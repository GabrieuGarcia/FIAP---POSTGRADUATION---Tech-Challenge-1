package com.fiap.techchallenge1restaurantsystem.application.port.in;

import java.util.UUID;

public interface DeleteUserUseCase {

    void deleteUser(UUID userId);
}
