package com.fiap.techchallenge1restaurantsystem.application.port.in.usecases;

import com.fiap.techchallenge1restaurantsystem.application.port.in.command.CreateUserCommand;
import com.fiap.techchallenge1restaurantsystem.domain.user.User;

public interface CreateUserUseCase {

    User createUser(CreateUserCommand command);
}
