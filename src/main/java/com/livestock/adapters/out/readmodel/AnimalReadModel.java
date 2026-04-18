package com.livestock.adapters.out.readmodel;

import com.livestock.domain.enums.TipoGado;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("animal_read_model")
public class AnimalReadModel {

    @Id
    private String id;

    private String identificacao;
    private TipoGado tipo;
    private Double peso;

    public AnimalReadModel() {}

    public AnimalReadModel(String id, String identificacao,TipoGado tipo, Double peso) {
        this.id = id;
        this.identificacao = identificacao;
        this.tipo = tipo;
        this.peso = peso;
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
}
