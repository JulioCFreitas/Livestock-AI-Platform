package com.livestock.application.ports;

public interface PasswordEncoderPort {

    String encode(String senha);

    boolean matches(
            String senhaDigitada,
            String senhaCriptografada
    );
}
