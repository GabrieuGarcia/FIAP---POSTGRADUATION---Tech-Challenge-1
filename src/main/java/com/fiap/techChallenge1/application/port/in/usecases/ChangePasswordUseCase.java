package com.fiap.techChallenge1.application.port.in.usecases;

import com.fiap.techChallenge1.application.port.in.command.ChangePasswordCommand;

public interface ChangePasswordUseCase {

    void changePassword(ChangePasswordCommand command);
}
