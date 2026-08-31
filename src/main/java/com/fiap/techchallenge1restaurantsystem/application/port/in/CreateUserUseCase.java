package com.fiap.techchallenge1restaurantsystem.application.port.in;

import com.fiap.techchallenge1restaurantsystem.domain.user.User;

public interface CreateUserUseCase {

    User createUser(CreateUserCommand command);
}
