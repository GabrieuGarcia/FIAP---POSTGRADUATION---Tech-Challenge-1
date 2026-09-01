package com.fiap.techChallenge1.application.port.in.usecases;

import com.fiap.techChallenge1.application.port.in.command.CreateUserCommand;
import com.fiap.techChallenge1.domain.user.User;

public interface CreateUserUseCase {

    User createUser(CreateUserCommand command);
}
