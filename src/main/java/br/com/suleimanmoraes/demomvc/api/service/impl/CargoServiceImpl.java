package br.com.suleimanmoraes.demomvc.api.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.suleimanmoraes.demomvc.api.model.Cargo;
import br.com.suleimanmoraes.demomvc.api.repository.CargoRepository;
import br.com.suleimanmoraes.demomvc.api.service.CargoService;

@Transactional(readOnly = false)
@Service
public class CargoServiceImpl implements CargoService {

	// private static final Log logger = LogFactory.getLog(CargoService.class);

	@Autowired
	private CargoRepository repository;

	@Override
	public Cargo save(Cargo objeto) {
		return repository.save(objeto);
	}

	@Override
	public Cargo update(Cargo objeto) {
		return repository.save(objeto);
	}

	@Transactional(readOnly = true)
	@Override
	public Cargo findById(Long id) {
		return repository.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Cargo> findAll() {
		return repository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Page<Cargo> findAll(Integer page, Integer size) {
		page = page == null || page < 0 ? 0 : page;
		size = size == null || size <= 0 ? 10 : size;
		final Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"));
		try {
			final Page<Cargo> pagina = repository.findAll(pageable);
			return pagina;
		} catch (Exception e) {
			return new PageImpl<>(new LinkedList<>(), pageable, 0);
		}
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Boolean possuiFuncionario(Long id) {
		return !findById(id).getFuncionarios().isEmpty();
	}
}
