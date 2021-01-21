package br.com.suleimanmoraes.demomvc.api.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.suleimanmoraes.demomvc.api.model.Funcionario;
import br.com.suleimanmoraes.demomvc.api.repository.FuncionarioRepository;
import br.com.suleimanmoraes.demomvc.api.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	// private static final Log logger =
	// LogFactory.getLog(FuncionarioService.class);

	@Autowired
	private FuncionarioRepository repository;

	@Transactional(readOnly = false)
	@Override
	public Funcionario save(Funcionario objeto) {
		return repository.save(objeto);
	}

	@Transactional(readOnly = false)
	@Override
	public Funcionario update(Funcionario objeto) {
		return repository.save(objeto);
	}

	@Transactional(readOnly = true)
	@Override
	public Funcionario findById(Long id) {
		return repository.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Funcionario> findAll() {
		return repository.findAll();
	}

	@Transactional(readOnly = false)
	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<Funcionario> findByNomeIgnoreCaseContaining(String nome) {
		return repository.findByNomeIgnoreCaseContaining(nome);
	}

	@Override
	public List<Funcionario> findByCargoId(Long cargoId) {
		return repository.findByCargoId(cargoId);
	}

	@Override
	public List<Funcionario> findByDataEntradaOrDataSaida(LocalDate dataEntrada, LocalDate dataSaida) {
		if (dataEntrada != null && dataSaida != null) {
			return repository.findByDataEntradaGreaterThanEqualAndDataSaidaLessThanEqual(dataEntrada, dataSaida);
		} else if (dataEntrada != null) {
			return repository.findByDataEntrada(dataEntrada);
		} else if (dataSaida != null) {
			return repository.findByDataSaida(dataSaida);
		} else {
			return findAll();
		}
	}
}
