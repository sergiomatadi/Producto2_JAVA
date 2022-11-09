package com.CodersTeam.ParaCasa.repository;

import org.springframework.data.repository.CrudRepository;

import com.CodersTeam.ParaCasa.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	
	Usuario findById(long id);
	
	Iterable<Usuario> findAll();

}
