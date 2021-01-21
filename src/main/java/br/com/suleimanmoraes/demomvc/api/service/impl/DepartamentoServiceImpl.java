package br.com.suleimanmoraes.demomvc.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.suleimanmoraes.demomvc.api.model.Departamento;
import br.com.suleimanmoraes.demomvc.api.repository.DepartamentoRepository;
import br.com.suleimanmoraes.demomvc.api.service.DepartamentoService;

@Service
public class DepartamentoServiceImpl implements DepartamentoService{

//	private static final Log logger = LogFactory.getLog(DepartamentoService.class);
	
	@Autowired
	private DepartamentoRepository repository;

	@Transactional(readOnly = false)
	@Override
	public Departamento save(Departamento objeto) {
		return repository.save(objeto);
	}

	@Transactional(readOnly = false)
	@Override
	public Departamento update(Departamento objeto) {
		return repository.save(objeto);
	}

	@Transactional(readOnly = true)
	@Override
	public Departamento findById(Long id) {
		return repository.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Departamento> findAll() {
		return repository.findAll();
	}

	@Transactional(readOnly = false)
	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Boolean possuiCargo(Long id) {
		return !findById(id).getCargos().isEmpty();
	}
}
