package br.com.suleimanmoraes.demomvc.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.suleimanmoraes.demomvc.api.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

}
