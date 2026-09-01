package com.fiap.techchallenge1restaurantsystem.application.port.in.usecases;

import com.fiap.techchallenge1restaurantsystem.application.port.in.command.LoginCommand;
import com.fiap.techchallenge1restaurantsystem.domain.user.User;

public interface LoginUserUseCase {

    User login(LoginCommand command);
}
