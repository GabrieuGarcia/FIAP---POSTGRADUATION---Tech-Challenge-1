package com.fiap.techchallenge1restaurantsystem.web;

import com.fiap.techchallenge1restaurantsystem.application.UserUseCases;
import com.fiap.techchallenge1restaurantsystem.web.dto.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserUseCases userUseCases;

    @PostMapping
    public void create(@RequestBody CreateUserRequest request) {

    }

    @PostMapping
    public void login(@RequestBody LoginRequest request) {

    }
}
