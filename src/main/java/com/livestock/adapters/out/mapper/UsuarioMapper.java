package com.livestock.adapters.out.mapper;

import com.livestock.adapters.out.persistence.UsuarioDocument;
import com.livestock.domain.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioDocument toDocument(Usuario usuario);
    Usuario toDomain(UsuarioDocument usuarioDocument);
}
