package br.com.suleimanmoraes.demomvc.api.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.suleimanmoraes.demomvc.api.model.projetinho.AgendaServicoDto;
import br.com.suleimanmoraes.demomvc.api.model.projetinho.PeriodoAgendaDto;
import br.com.suleimanmoraes.demomvc.api.model.projetinho.ServicoDto;
import br.com.suleimanmoraes.demomvc.api.model.projetinho.UnidadeDto;

@Controller
@RequestMapping("/projetinhos")
public class CadastroAgendaController {

	private static final String PROJETINHO = "projetinho";
	private static final String REDIRECT_PROJETINHOS_CADASTRO_AGENDA = "redirect:/projetinhos/cadastro-agenda";
	private static final String PROJETINHO_CADASTRO_AGENDA = PROJETINHO + "/cadastro-agenda";

	@GetMapping("/cadastro-agenda")
	public String cadastrar(PeriodoAgendaDto periodoAgendaDto, AgendaServicoDto agendaServicoDto) {
		return PROJETINHO_CADASTRO_AGENDA;
	}

	@PostMapping(value = "/salvar", params = "action=agendaServicoDto")
	public String salvarAgendaServicoDto(PeriodoAgendaDto periodoAgendaDto, @Valid AgendaServicoDto agendaServicoDto,
			BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return PROJETINHO_CADASTRO_AGENDA;
		}
		attr.addFlashAttribute("success", "Serviço adicionado com sucesso.");
		return REDIRECT_PROJETINHOS_CADASTRO_AGENDA;
	}

	@PostMapping(value = "/salvar", params = "action=periodoAgendaDto")
	public String salvarPeriodoAgendaDto(AgendaServicoDto agendaServicoDto, @Valid PeriodoAgendaDto periodoAgendaDto,
			BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return PROJETINHO_CADASTRO_AGENDA;
		}
		attr.addFlashAttribute("success", "Agenda adicionado com sucesso.");
		return REDIRECT_PROJETINHOS_CADASTRO_AGENDA;
	}

	@ModelAttribute("unidades")
	public UnidadeDto[] listarUnidades() {
		final UnidadeDto[] unidades = { new UnidadeDto(1, "Unidade 1"), new UnidadeDto(2, "Unidade 2") };
		return unidades;
	}

	@ModelAttribute("servicos")
	public ServicoDto[] listarServicos() {
		final ServicoDto[] servicos = { new ServicoDto(1, "Serviço 1"), new ServicoDto(2, "Serviço 2") };
		return servicos;
	}
}
