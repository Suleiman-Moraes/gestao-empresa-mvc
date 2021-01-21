package br.com.suleimanmoraes.demomvc.api.model.projetinho;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicoDto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String nome;
	
	public ServicoDto(Integer id) {
		this.id = id;
	}
}
