package com.livestock.domain.event;

public class ClienteCadastradoEvent {

    private String clienteId;
    private String nome;

    public ClienteCadastradoEvent(String clienteId, String nome) {
        this.clienteId = clienteId;
        this.nome = nome;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

