package com.livestock.adapters.out.security;

import com.livestock.application.ports.PasswordEncoderPort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BCryptPasswordEncoderAdapter
        implements PasswordEncoderPort {

    private final BCryptPasswordEncoder encoder;

    public BCryptPasswordEncoderAdapter( BCryptPasswordEncoder encoder) {
        this.encoder = encoder;
    }

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
