package com.fiap.techchallenge1restaurantsystem.application.port.in.usecases;

import com.fiap.techchallenge1restaurantsystem.application.port.in.command.UpdateUserCommand;
import com.fiap.techchallenge1restaurantsystem.domain.user.User;

public interface UpdateUserUseCase {

    User updateUser(UpdateUserCommand command);
}
