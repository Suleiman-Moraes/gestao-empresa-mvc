package br.com.suleimanmoraes.demomvc.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.suleimanmoraes.demomvc.api.model.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long>{

}
