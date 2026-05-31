package com.livestock.application.usecase;

import com.livestock.adapters.in.web.dto.AuthResponse;
import com.livestock.adapters.in.web.dto.RegisterRequest;

public interface UsuarioUseCase {

    AuthResponse cadastrar(RegisterRequest request);
}
