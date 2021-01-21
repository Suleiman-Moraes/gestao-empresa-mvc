package br.com.suleimanmoraes.demomvc.api.service;

import java.util.List;

import br.com.suleimanmoraes.demomvc.api.model.Endereco;

public interface EnderecoService {
	Endereco save(Endereco objeto);
	
	Endereco update(Endereco objeto);
	
	Endereco findById(Long id);
	
	List<Endereco> findAll();
	
	void delete(Long id);
}
