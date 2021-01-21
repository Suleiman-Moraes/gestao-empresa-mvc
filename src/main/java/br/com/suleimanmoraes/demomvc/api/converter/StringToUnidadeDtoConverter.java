package br.com.suleimanmoraes.demomvc.api.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import br.com.suleimanmoraes.demomvc.api.model.projetinho.UnidadeDto;

@Component
public class StringToUnidadeDtoConverter implements Converter<String, UnidadeDto>{
	
	@Override
	public UnidadeDto convert(String text) {
		if(StringUtils.hasLength(text)) {
			return new UnidadeDto(Integer.valueOf(text));
		}
		return null;
	}
}
