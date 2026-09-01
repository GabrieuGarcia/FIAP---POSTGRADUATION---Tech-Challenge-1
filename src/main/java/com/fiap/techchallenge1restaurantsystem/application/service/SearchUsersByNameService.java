package com.fiap.techchallenge1restaurantsystem.application.service;

import com.fiap.techchallenge1restaurantsystem.application.port.in.SearchUsersByNameUseCase;
import com.fiap.techchallenge1restaurantsystem.application.port.out.UserRepositoryPort;
import com.fiap.techchallenge1restaurantsystem.domain.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchUsersByNameService implements SearchUsersByNameUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public SearchUsersByNameService(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public List<User> searchByName(String name) {
        return userRepositoryPort.findByNameContainingIgnoreCase(name);
    }
}
