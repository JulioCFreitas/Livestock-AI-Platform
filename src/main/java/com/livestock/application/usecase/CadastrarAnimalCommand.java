package com.livestock.application.usecase;

import com.livestock.domain.enums.TipoGado;

import java.time.LocalDate;

public record CadastrarAnimalCommand(
        String identificacao,
        TipoGado tipo,
        String raca,
        double peso,
        LocalDate dataNascimento
) {
}
