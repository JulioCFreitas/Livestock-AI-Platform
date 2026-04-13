package com.livestock.adapters.out.mapper;

import com.livestock.adapters.in.web.dto.AnimalRequest;
import com.livestock.adapters.in.web.dto.AnimalResponse;
import com.livestock.adapters.out.persistence.AnimalDocument;
import com.livestock.domain.model.Animal;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface AnimalMapper {

    // Request → Domain
    Animal toDomainFromRequest(AnimalRequest request);

    // Domain → Response
    AnimalResponse toResponse(Animal animal);

    // Document → Domain
    Animal toDomainFromDocument(AnimalDocument document);

    // Domain → Document
    AnimalDocument toDocument(Animal animal);

    // Update parcial
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAnimalFromRequest(AnimalRequest request, @MappingTarget Animal animal);
}