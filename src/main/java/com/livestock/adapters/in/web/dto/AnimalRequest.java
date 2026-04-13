package com.livestock.adapters.in.web.dto;

import com.livestock.domain.enums.TipoGado;

import java.time.LocalDate;

public record AnimalRequest(
        String identificacao,
        TipoGado tipo,
        String raca,
        double peso,
        LocalDate dataNascimento
) {
}
