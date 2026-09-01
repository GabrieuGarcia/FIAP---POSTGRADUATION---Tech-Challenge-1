package com.fiap.techChallenge1.application.port.in.usecases;

import com.fiap.techChallenge1.application.port.in.command.LoginCommand;
import com.fiap.techChallenge1.domain.user.User;

public interface LoginUserUseCase {

    User login(LoginCommand command);
}
