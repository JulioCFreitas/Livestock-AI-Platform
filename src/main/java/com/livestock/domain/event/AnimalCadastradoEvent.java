package com.livestock.domain.event;

import com.livestock.domain.enums.TipoGado;

import java.time.LocalDate;

public class AnimalCadastradoEvent {

    private String animalId;
    private String identificacao;
    private TipoGado tipo;
    private Double peso;
    private LocalDate dataNascimento;

    public AnimalCadastradoEvent() {}

    public AnimalCadastradoEvent(String animalId, String identificacao, TipoGado tipo, Double peso, LocalDate dataNascimento) {
        this.animalId = animalId;
        this.identificacao = identificacao;
        this.tipo = tipo;
        this.peso = peso;
        this.dataNascimento = dataNascimento;
    }

    public String getAnimalId() {
        return animalId;
    }

    public void setAnimalId(String animalId) {
        this.animalId = animalId;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public TipoGado getTipo() {
        return tipo;
    }

    public void setTipo(TipoGado tipo) {
        this.tipo = tipo;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}

