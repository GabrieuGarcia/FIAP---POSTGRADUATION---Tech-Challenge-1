package com.fiap.techchallenge1restaurantsystem.application.port.in.usecases;

import com.fiap.techchallenge1restaurantsystem.application.port.in.command.ChangePasswordCommand;

public interface ChangePasswordUseCase {

    void changePassword(ChangePasswordCommand command);
}
