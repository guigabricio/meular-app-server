package com.gabricio.meular.repositories;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.gabricio.meular.entities.ServicoEntity;

public interface ServicoRepository extends MongoRepository<ServicoEntity, ObjectId> {
	
	public boolean existsByDescricao(String descricao);
	
	public boolean existsById(ObjectId id);
	
	public Optional<ServicoEntity> findByDescricao(String descricao);
	
	public Optional<ServicoEntity> findById(ObjectId id);
	
}