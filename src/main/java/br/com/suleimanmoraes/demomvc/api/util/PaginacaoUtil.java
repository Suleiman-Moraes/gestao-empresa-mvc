package br.com.suleimanmoraes.demomvc.api.util;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaginacaoUtil<T> {

	private int tamanho;
	private int pagina;
	private int totalDePaginas;
	private List<T> registros;
}
