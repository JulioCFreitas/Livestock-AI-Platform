package com.livestock.application.service;

import com.livestock.adapters.in.web.dto.AuthResponse;
import com.livestock.adapters.in.web.dto.RegisterRequest;
import com.livestock.adapters.out.mapper.UsuarioMapper;
import com.livestock.application.ports.UsuarioRepository;
import com.livestock.domain.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;

    public UsuarioService( UsuarioRepository repository, UsuarioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public AuthResponse cadastrar(RegisterRequest request) {
        if (repository.ExistsByEmail(request.email()))
            throw new RuntimeException("Usuário já cadastrado.");

        Usuario usuario = mapper.toDomain(request);
        usuario.ativar();
        repository.save(usuario);

        return new AuthResponse("Usuário cadastrado com sucesso.");
    }
}
