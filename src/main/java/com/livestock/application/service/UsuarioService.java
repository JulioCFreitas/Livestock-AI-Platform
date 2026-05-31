package com.livestock.application.service;

import com.livestock.adapters.in.web.dto.AuthResponse;
import com.livestock.adapters.in.web.dto.RegisterRequest;
import com.livestock.adapters.out.mapper.UsuarioMapper;
import com.livestock.application.ports.PasswordEncoderPort;
import com.livestock.application.ports.UsuarioRepository;
import com.livestock.application.usecase.UsuarioUseCase;
import com.livestock.domain.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UsuarioUseCase {

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;
    private final PasswordEncoderPort passwordEncoderPort;

    public UsuarioService( UsuarioRepository repository, UsuarioMapper mapper
    ,PasswordEncoderPort passwordEncoderPort) {
        this.repository = repository;
        this.mapper = mapper;
        this.passwordEncoderPort = passwordEncoderPort;
    }

    @Override
    public AuthResponse cadastrar(RegisterRequest request) {

        if (repository.ExistsByEmail(request.email()))
            throw new RuntimeException("Usuário já cadastrado.");

        Usuario usuario = mapper.toDomain(request);

        usuario.setSenha(
                passwordEncoderPort.encode(
                        usuario.getSenha()
                )
        );

        usuario.ativar();
        repository.save(usuario);

        return new AuthResponse("Usuário cadastrado com sucesso.");
    }


}
