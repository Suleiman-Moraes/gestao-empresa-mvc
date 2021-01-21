package br.com.suleimanmoraes.demomvc.api.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.suleimanmoraes.demomvc.api.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	List<Funcionario> findByNomeIgnoreCaseContaining(String nome);

	List<Funcionario> findByCargoId(Long cargoId);

	List<Funcionario> findByDataEntradaGreaterThanEqualAndDataSaidaLessThanEqual(LocalDate dataEntrada, LocalDate dataSaida);

	List<Funcionario> findByDataEntrada(LocalDate dataEntrada);

	List<Funcionario> findByDataSaida(LocalDate dataSaida);
}
