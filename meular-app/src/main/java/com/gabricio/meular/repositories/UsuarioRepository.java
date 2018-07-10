package com.gabricio.meular.repositories;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.gabricio.meular.entities.UsuarioEntity;

public interface UsuarioRepository extends MongoRepository<UsuarioEntity, ObjectId> {
	
	public boolean existsByEmail(String email);
	
	public boolean existsById(ObjectId id);
	
	public Optional<UsuarioEntity> findByEmail(String email);
	
	public Optional<UsuarioEntity> findById(ObjectId id);
	
}