package com.livestock.adapters.out.persistence;

import com.livestock.adapters.out.mapper.UsuarioMapper;
import com.livestock.application.ports.UsuarioRepository;
import com.livestock.domain.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UsuarioMongoAdapter implements UsuarioRepository {

    private final SpringDataUsuarioRepository repository;
    private final UsuarioMapper mapper;

    public UsuarioMongoAdapter(SpringDataUsuarioRepository repository, UsuarioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Usuario save(Usuario usuario) {
        UsuarioDocument document = repository.save(
                mapper.toDocument(usuario)
        );

        return mapper.toDomain(document);
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {

        return repository.findByEmail(email)
                .map(mapper::toDomain);
    }

    @Override
    public boolean ExistsByEmail(String email) {
        return repository.findByEmail(email)
                .isPresent();
    }
}
