package br.com.suleimanmoraes.demomvc.api.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import br.com.suleimanmoraes.demomvc.api.model.Cargo;
import br.com.suleimanmoraes.demomvc.api.service.CargoService;

@Component
public class StringToCargoConverter implements Converter<String, Cargo>{

	@Autowired
	private CargoService service;
	
	@Override
	public Cargo convert(String text) {
		if(StringUtils.hasLength(text)) {
			final Long id = Long.valueOf(text);
			return service.findById(id);
		}
		return null;
	}
}
