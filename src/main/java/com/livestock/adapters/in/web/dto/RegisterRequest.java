package com.livestock.adapters.in.web.dto;

import com.livestock.domain.enums.Role;

public record RegisterRequest(
        String nome,
        String email,
        String senha,
        Role role
) {
}
