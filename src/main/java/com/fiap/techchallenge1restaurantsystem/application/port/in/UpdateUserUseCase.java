package com.fiap.techchallenge1restaurantsystem.application.port.in;

import com.fiap.techchallenge1restaurantsystem.domain.user.User;

public interface UpdateUserUseCase {

    User updateUser(UpdateUserCommand command);
}
