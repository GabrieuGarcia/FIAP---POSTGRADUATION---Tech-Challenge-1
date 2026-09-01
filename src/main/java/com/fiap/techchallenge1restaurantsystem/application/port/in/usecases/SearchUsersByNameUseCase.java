package com.fiap.techchallenge1restaurantsystem.application.port.in.usecases;

import com.fiap.techchallenge1restaurantsystem.domain.user.User;

import java.util.List;

public interface SearchUsersByNameUseCase {

    List<User> searchByName(String name);
}
