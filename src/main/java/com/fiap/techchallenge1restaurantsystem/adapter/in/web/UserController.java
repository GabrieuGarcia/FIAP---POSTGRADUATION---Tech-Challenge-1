package com.fiap.techchallenge1restaurantsystem.adapter.in.web;

import com.fiap.techchallenge1restaurantsystem.adapter.in.web.dto.CreateUserRequest;
import com.fiap.techchallenge1restaurantsystem.adapter.in.web.dto.LoginRequest;
import com.fiap.techchallenge1restaurantsystem.adapter.in.web.dto.UserResponse;
import com.fiap.techchallenge1restaurantsystem.application.port.in.CreateUserUseCase;
import com.fiap.techchallenge1restaurantsystem.application.port.in.LoginUserUseCase;
import com.fiap.techchallenge1restaurantsystem.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final LoginUserUseCase loginUserUseCase;

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody CreateUserRequest request) {
        User user = createUserUseCase.createUser(request.toCommand());
        return ResponseEntity.status(HttpStatus.CREATED).body(UserResponse.from(user));
    }

    @PostMapping("/login")
    public void login(@RequestBody LoginRequest request) {
        loginUserUseCase.login(request.toCommand());
    }
}
