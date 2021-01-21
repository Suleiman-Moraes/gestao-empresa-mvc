package br.com.suleimanmoraes.demomvc.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.suleimanmoraes.demomvc.api.model.Endereco;
import br.com.suleimanmoraes.demomvc.api.repository.EnderecoRepository;
import br.com.suleimanmoraes.demomvc.api.service.EnderecoService;

@Service
public class EnderecoServiceImpl implements EnderecoService {

	// private static final Log logger = LogFactory.getLog(EnderecoService.class);

	@Autowired
	private EnderecoRepository repository;

	@Override
	public Endereco save(Endereco objeto) {
		return repository.save(objeto);
	}

	@Override
	public Endereco update(Endereco objeto) {
		return repository.save(objeto);
	}

	@Override
	public Endereco findById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public List<Endereco> findAll() {
		return repository.findAll();
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
