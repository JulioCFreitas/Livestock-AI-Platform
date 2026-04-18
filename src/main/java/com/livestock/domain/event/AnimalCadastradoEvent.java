package com.livestock.domain.event;

public class AnimalCadastradoEvent {

    private String animalId;
    private String identificacao;

    public AnimalCadastradoEvent() {}

    public AnimalCadastradoEvent(String animalId, String identificacao) {
        this.animalId = animalId;
        this.identificacao = identificacao;
    }

    public String getAnimalId() {
        return animalId;
    }

    public String getIdentificacao() {
        return identificacao;
    }
}

