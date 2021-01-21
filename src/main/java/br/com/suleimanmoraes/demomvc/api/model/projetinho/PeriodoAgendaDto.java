package br.com.suleimanmoraes.demomvc.api.model.projetinho;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeriodoAgendaDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;

	@NotNull
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataInicio;

	@NotNull
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataFim;

	@NotBlank
	private String horaInicial;

	@NotBlank
	private String horaFinal;

	@NotNull
	private Integer diaSemana = 0;

	@NotNull
	private Integer quantidadeServidores;
	
	@NotBlank
	private String tempoAtendimento;
}
