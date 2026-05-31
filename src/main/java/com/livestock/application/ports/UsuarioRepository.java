package com.livestock.application.ports;

import com.livestock.domain.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository {

    Usuario save(Usuario usuario);
    Optional<Usuario> findByEmail(String email);
    boolean ExistsByEmail(String email);
}
