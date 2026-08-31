package com.fiap.techchallenge1restaurantsystem.application.service;

import com.fiap.techchallenge1restaurantsystem.application.port.in.LoginCommand;
import com.fiap.techchallenge1restaurantsystem.application.port.in.LoginUserUseCase;
import org.springframework.stereotype.Service;

@Service
public class LoginUserService implements LoginUserUseCase {

    @Override
    public void login(LoginCommand command) {

    }
}
