package com.fiap.techchallenge1restaurantsystem.application.port.out;

import com.fiap.techchallenge1restaurantsystem.domain.user.User;

public interface UserRepositoryPort {

    User save(User user);
}
