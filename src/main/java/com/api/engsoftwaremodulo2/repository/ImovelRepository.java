package com.api.engsoftwaremodulo2.repository;

import com.api.engsoftwaremodulo2.model.Imovel;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ImovelRepository extends MongoRepository<Imovel, String> {

}
