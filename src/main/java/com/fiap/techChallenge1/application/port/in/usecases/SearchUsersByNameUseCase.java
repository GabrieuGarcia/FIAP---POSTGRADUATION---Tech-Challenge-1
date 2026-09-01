package com.fiap.techChallenge1.application.port.in.usecases;

import com.fiap.techChallenge1.domain.user.User;

import java.util.List;

public interface SearchUsersByNameUseCase {

    List<User> searchByName(String name);
}
