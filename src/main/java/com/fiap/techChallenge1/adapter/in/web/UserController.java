package com.fiap.techChallenge1.adapter.in.web;

import com.fiap.techChallenge1.adapter.in.web.dto.request.ChangePasswordRequest;
import com.fiap.techChallenge1.adapter.in.web.dto.request.CreateUserRequest;
import com.fiap.techChallenge1.adapter.in.web.dto.request.LoginRequest;
import com.fiap.techChallenge1.adapter.in.web.dto.request.UpdateUserRequest;
import com.fiap.techChallenge1.adapter.in.web.dto.response.UserResponse;
import com.fiap.techChallenge1.application.port.in.usecases.ChangePasswordUseCase;
import com.fiap.techChallenge1.application.port.in.usecases.CreateUserUseCase;
import com.fiap.techChallenge1.application.port.in.usecases.DeleteUserUseCase;
import com.fiap.techChallenge1.application.port.in.usecases.LoginUserUseCase;
import com.fiap.techChallenge1.application.port.in.usecases.SearchUsersByNameUseCase;
import com.fiap.techChallenge1.application.port.in.usecases.UpdateUserUseCase;
import com.fiap.techChallenge1.domain.user.User;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final ChangePasswordUseCase changePasswordUseCase;
    private final DeleteUserUseCase deleteUserUseCase;
    private final SearchUsersByNameUseCase searchUsersByNameUseCase;
    private final LoginUserUseCase loginUserUseCase;

    @Operation(summary = "Register a new user (customer or restaurant owner)")
    @ApiResponses({

            @ApiResponse(responseCode = "201", description = "User created", content = @Content(
                    schema = @Schema(implementation = UserResponse.class),
                    examples = @ExampleObject(name = "success", value = """
                            {
                              "id": "a64c6ce0-b0c8-4bed-92d6-c0d602688bb3",
                              "name": "Gabriel Garcia",
                              "email": "gabriel@example.com",
                              "login": "gabriel.garcia",
                              "address": { "street": "Rua A", "number": "100", "city": "Sao Paulo", "postalCode": "01000-000" },
                              "userType": "CUSTOMER",
                              "lastModifiedDate": "2026-09-01T20:09:00.000+00:00"
                            }"""))),

            @ApiResponse(responseCode = "409", description = "Email or login already in use", content = @Content(
                    mediaType = "application/problem+json",
                    examples = @ExampleObject(name = "conflict", value = """
                            {
                              "type": "about:blank",
                              "title": "Conflict",
                              "status": 409,
                              "detail": "Email already in use: gabriel@example.com",
                              "instance": "/api/v1/users"
                            }""")))
    })
    @PostMapping
    public ResponseEntity<UserResponse> create(@Valid @RequestBody CreateUserRequest request) {
        User user = createUserUseCase.createUser(request.toCommand());
        return ResponseEntity.status(HttpStatus.CREATED).body(UserResponse.from(user));
    }

    @Operation(summary = "Update a user's profile information (name, email, login, address) - excludes password")
    @ApiResponses({

            @ApiResponse(responseCode = "200", description = "User updated", content = @Content(
                    schema = @Schema(implementation = UserResponse.class))),

            @ApiResponse(responseCode = "404", description = "User not found", content = @Content(
                    mediaType = "application/problem+json",
                    examples = @ExampleObject(name = "notFound", value = """
                            {
                              "type": "about:blank",
                              "title": "User Not Found",
                              "status": 404,
                              "detail": "User not found: a64c6ce0-b0c8-4bed-92d6-c0d602688bb3",
                              "instance": "/api/v1/users/a64c6ce0-b0c8-4bed-92d6-c0d602688bb3"
                            }""")))
    })
    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable UUID id, @Valid @RequestBody UpdateUserRequest request) {
        User user = updateUserUseCase.updateUser(request.toCommand(id));
        return ResponseEntity.ok(UserResponse.from(user));
    }

    @Operation(summary = "Change a user's password (requires the current password)")
    @ApiResponses({

            @ApiResponse(responseCode = "204", description = "Password changed"),

            @ApiResponse(responseCode = "401", description = "Current password does not match", content = @Content(
                    mediaType = "application/problem+json",
                    examples = @ExampleObject(name = "invalidCredentials", value = """
                            {
                              "type": "about:blank",
                              "title": "Invalid Credentials",
                              "status": 401,
                              "detail": "Current password does not match",
                              "instance": "/api/v1/users/a64c6ce0-b0c8-4bed-92d6-c0d602688bb3/password"
                            }""")))
    })
    @PatchMapping("/{id}/password")
    public ResponseEntity<Void> changePassword(@PathVariable UUID id, @Valid @RequestBody ChangePasswordRequest request) {
        changePasswordUseCase.changePassword(request.toCommand(id));
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Delete a user")
    @ApiResponses({

            @ApiResponse(responseCode = "204", description = "User deleted"),

            @ApiResponse(responseCode = "404", description = "User not found", content = @Content(
                    mediaType = "application/problem+json"))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUserUseCase.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Search users by name (partial, case-insensitive match)")
    @ApiResponses({

            @ApiResponse(responseCode = "200", description = "Matching users", content = @Content(
                    examples = @ExampleObject(name = "success", value = """
                            [
                              {
                                "id": "a64c6ce0-b0c8-4bed-92d6-c0d602688bb3",
                                "name": "Gabriel Garcia",
                                "email": "gabriel@example.com",
                                "login": "gabriel.garcia",
                                "address": { "street": "Rua A", "number": "100", "city": "Sao Paulo", "postalCode": "01000-000" },
                                "userType": "CUSTOMER",
                                "lastModifiedDate": "2026-09-01T20:09:00.000+00:00"
                              }
                            ]""")))
    })
    @GetMapping
    public ResponseEntity<List<UserResponse>> searchByName(@RequestParam String name) {
        List<UserResponse> users = searchUsersByNameUseCase.searchByName(name).stream()
                .map(UserResponse::from)
                .toList();
        return ResponseEntity.ok(users);
    }

    @Operation(summary = "Validate login credentials (mandatory login validation service)")
    @ApiResponses({

            @ApiResponse(responseCode = "200", description = "Valid credentials", content = @Content(
                    schema = @Schema(implementation = UserResponse.class))),

            @ApiResponse(responseCode = "401", description = "Invalid login or password", content = @Content(
                    mediaType = "application/problem+json",
                    examples = @ExampleObject(name = "invalidCredentials", value = """
                            {
                              "type": "about:blank",
                              "title": "Invalid Credentials",
                              "status": 401,
                              "detail": "Invalid login or password",
                              "instance": "/api/v1/users/login"
                            }""")))
    })
    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@Valid @RequestBody LoginRequest request) {
        User user = loginUserUseCase.login(request.toCommand());
        return ResponseEntity.ok(UserResponse.from(user));
    }
}
