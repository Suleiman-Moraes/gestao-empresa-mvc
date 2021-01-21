package br.com.suleimanmoraes.demomvc.api.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import br.com.suleimanmoraes.demomvc.api.model.projetinho.ServicoDto;

@Component
public class StringToServicoDtoConverter implements Converter<String, ServicoDto>{
	
	@Override
	public ServicoDto convert(String text) {
		if(StringUtils.hasLength(text)) {
			return new ServicoDto(Integer.valueOf(text));
		}
		return null;
	}
}
