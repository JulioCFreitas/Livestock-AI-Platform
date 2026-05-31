package com.livestock.adapters.out.mapper;

import com.livestock.adapters.in.web.dto.RegisterRequest;
import com.livestock.adapters.out.persistence.UsuarioDocument;
import com.livestock.domain.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    // DTO → Domain
    Usuario toDomain(RegisterRequest request);

    // Domain → Document
    UsuarioDocument toDocument(Usuario usuario);

    // Document → Domain
    Usuario toDomain(UsuarioDocument usuarioDocument);

}
