package com.livestock.adapters.out.security;

import com.livestock.application.ports.PasswordEncoderPort;

public class BCryptPasswordEncoderAdapter implements PasswordEncoderPort {

    private final BCryptPasswordEncoderAdapter encoder = new BCryptPasswordEncoderAdapter();

    @Override
    public String encode(String senha) {
        return encoder.encode(senha);
    }

    @Override
    public boolean matches(String senhaDigitada, String senhaCriptografada) {
        return encoder.matches(
                senhaDigitada,
                senhaCriptografada
        );
    }
}
