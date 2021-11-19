package com.api.engsoftwaremodulo2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.api.engsoftwaremodulo2.model.Contrato;

public interface ContratoRepository extends MongoRepository<Contrato, String>{

}
