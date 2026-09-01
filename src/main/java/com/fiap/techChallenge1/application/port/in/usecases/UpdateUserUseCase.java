package com.fiap.techChallenge1.application.port.in.usecases;

import com.fiap.techChallenge1.application.port.in.command.UpdateUserCommand;
import com.fiap.techChallenge1.domain.user.User;

public interface UpdateUserUseCase {

    User updateUser(UpdateUserCommand command);
}
