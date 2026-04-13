package com.livestock.adapters.in.web.dto;

import java.time.LocalDate;

public record AnimalResponse(
        String id,
        String identificacao,
        String tipo,
        String raca,
        double peso,
        LocalDate dataNascimento
) {
}
