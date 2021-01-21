package br.com.suleimanmoraes.demomvc.api.service;

import java.util.List;

import br.com.suleimanmoraes.demomvc.api.model.Departamento;

public interface DepartamentoService {
	Departamento save(Departamento objeto);

	Departamento update(Departamento objeto);

	Departamento findById(Long id);

	List<Departamento> findAll();

	void delete(Long id);

	Boolean possuiCargo(Long id);
}
