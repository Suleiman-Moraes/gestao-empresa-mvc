package br.com.suleimanmoraes.demomvc.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.suleimanmoraes.demomvc.api.model.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long> {

}
