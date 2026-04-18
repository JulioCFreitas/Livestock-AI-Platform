package com.livestock.adapters.out.readmodel;

import com.livestock.domain.enums.TipoGado;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document("animal_read_model")
public class AnimalReadModel {

    @Id
    private String id;

    private String identificacao;
    private TipoGado tipo;
    private Double peso;
    private LocalDate dataNascimento;

    public AnimalReadModel() {}

    public AnimalReadModel(String id, String identificacao,TipoGado tipo, Double peso, LocalDate dataNascimento) {
        this.id = id;
        this.identificacao = identificacao;
        this.tipo = tipo;
        this.peso = peso;
        this.dataNascimento = dataNascimento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
