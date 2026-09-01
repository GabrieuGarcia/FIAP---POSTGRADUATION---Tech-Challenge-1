package com.fiap.techChallenge1.application.service;

import com.fiap.techChallenge1.application.port.in.usecases.SearchUsersByNameUseCase;
import com.fiap.techChallenge1.application.port.out.UserRepositoryPort;
import com.fiap.techChallenge1.domain.user.User;
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
