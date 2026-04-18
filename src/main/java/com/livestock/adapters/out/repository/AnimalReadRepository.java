package com.livestock.adapters.out.repository;

import com.livestock.adapters.out.readmodel.AnimalReadModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AnimalReadRepository extends MongoRepository<AnimalReadModel, String> {
    List<AnimalReadModel> id(String id);
}
