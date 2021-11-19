package com.api.engsoftwaremodulo2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.api.engsoftwaremodulo2.model.Inquilino;

public interface InquilinoRepository extends MongoRepository<Inquilino, String> {

}
