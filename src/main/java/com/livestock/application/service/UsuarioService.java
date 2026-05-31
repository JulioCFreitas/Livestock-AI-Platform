package com.livestock.application.service;

import com.livestock.adapters.in.web.dto.AuthResponse;
import com.livestock.adapters.in.web.dto.RegisterRequest;
import com.livestock.application.ports.UsuarioRepository;
import com.livestock.domain.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService( UsuarioRepository repository) {
        this.repository = repository;
    }

    public AuthResponse cadastrar(RegisterRequest request) {
        if (repository.ExistsByEmail(request.email()))
            throw new RuntimeException("Usuário já cadastrado.");

        Usuario usuario = new Usuario();
        usuario.setNome(request.nome());
        usuario.setEmail(request.email());
        usuario.setSenha(request.senha());
        usuario.setRole(request.role());
        usuario.setAtivo(true);

        repository.save(usuario);

        return new AuthResponse("Usuário cadastrado com sucesso.");
    }
}
