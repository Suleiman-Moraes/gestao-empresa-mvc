package br.com.suleimanmoraes.demomvc.api.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import br.com.suleimanmoraes.demomvc.api.model.Departamento;
import br.com.suleimanmoraes.demomvc.api.service.DepartamentoService;

@Component
public class StringToDepartamentoConverter implements Converter<String, Departamento>{

	@Autowired
	private DepartamentoService service;
	
	@Override
	public Departamento convert(String text) {
		if(StringUtils.hasLength(text)) {
			final Long id = Long.valueOf(text);
			return service.findById(id);
		}
		return null;
	}
}
