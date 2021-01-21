package br.com.suleimanmoraes.demomvc.api.service;

import java.util.List;

import org.springframework.data.domain.Page;

import br.com.suleimanmoraes.demomvc.api.model.Cargo;

public interface CargoService {
	Cargo save(Cargo objeto);
	
	Cargo update(Cargo objeto);
	
	Cargo findById(Long id);
	
	List<Cargo> findAll();
	
	void delete(Long id);

	Boolean possuiFuncionario(Long id);

	Page<Cargo> findAll(Integer page, Integer size);
}
