package br.com.suleimanmoraes.demomvc.api.service;

import java.time.LocalDate;
import java.util.List;

import br.com.suleimanmoraes.demomvc.api.model.Funcionario;

public interface FuncionarioService {
	Funcionario save(Funcionario objeto);

	Funcionario update(Funcionario objeto);

	Funcionario findById(Long id);

	List<Funcionario> findAll();

	void delete(Long id);

	List<Funcionario> findByNomeIgnoreCaseContaining(String nome);

	List<Funcionario> findByCargoId(Long cargoId);

	List<Funcionario> findByDataEntradaOrDataSaida(LocalDate dataEntrada, LocalDate dataSaida);
}
