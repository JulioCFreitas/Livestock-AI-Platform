package com.livestock.adapters.in.web;

import com.livestock.domain.enums.TipoGado;

import java.time.LocalDate;

public record CadastrarAnimalRequest(
        String identificacao,
        TipoGado tipo,
        String raca,
        double peso,
        LocalDate dataNascimento
) {
}
