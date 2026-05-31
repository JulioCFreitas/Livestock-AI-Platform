package com.livestock.adapters.in.web;

import com.livestock.adapters.in.web.dto.AuthResponse;
import com.livestock.adapters.in.web.dto.RegisterRequest;
import com.livestock.application.service.UsuarioService;
import com.livestock.application.usecase.UsuarioUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioUseCase useCase;

    public AuthController(UsuarioUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(useCase.cadastrar(request));
    }
}
