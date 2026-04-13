package com.livestock.domain.model;

import com.livestock.domain.enums.TipoGado;

import java.time.LocalDate;
import java.util.UUID;

public class Animal {

    private UUID id;
    private String identificacao;
    private TipoGado tipo;
    private String raca;
    private double peso;
    private LocalDate dataNascimento;

    public Animal(UUID id, String identificacao, TipoGado tipo, String raca, double peso, LocalDate dataNascimento) {
        this.id = id;
        this.identificacao = identificacao;
        this.tipo = tipo;
        this.raca = raca;
        this.peso = peso;
        this.dataNascimento = dataNascimento;
    }

    public boolean prontoParaAbate() {
        return tipo == TipoGado.CORTE && peso >= 450;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
