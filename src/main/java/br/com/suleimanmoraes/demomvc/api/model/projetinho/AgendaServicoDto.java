package br.com.suleimanmoraes.demomvc.api.model.projetinho;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgendaServicoDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotNull
	private UnidadeDto unidade;
	
	@NotNull
	private ServicoDto servico;
}
