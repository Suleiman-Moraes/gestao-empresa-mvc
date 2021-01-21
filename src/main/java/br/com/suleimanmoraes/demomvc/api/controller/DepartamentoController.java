package br.com.suleimanmoraes.demomvc.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.suleimanmoraes.demomvc.api.model.Departamento;
import br.com.suleimanmoraes.demomvc.api.service.DepartamentoService;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {

	private static final String DEPARTAMENTO = "departamento";
	private static final String DEPARTAMENTO_CADASTRO = DEPARTAMENTO + "/cadastro";

	@Autowired
	private DepartamentoService service;

	@GetMapping("/cadastrar")
	public String cadastrar(Departamento departamento) {
		return DEPARTAMENTO_CADASTRO;
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("departamentos", service.findAll());
		return DEPARTAMENTO + "/lista";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid Departamento departamento, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return DEPARTAMENTO_CADASTRO;
		}
		
		service.save(departamento);
		attr.addFlashAttribute("success", "Departamento criado com sucesso.");
		return "redirect:/departamentos/listar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") long id, ModelMap model) {
		model.addAttribute("departamento", service.findById(id));
		return DEPARTAMENTO_CADASTRO;
	}

	@PostMapping("/editar")
	public String editar(@Valid Departamento departamento, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return DEPARTAMENTO_CADASTRO;
		}
		
		service.update(departamento);
		attr.addFlashAttribute("success", "Departamento editado com sucesso.");
		return "redirect:/departamentos/listar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") long id, ModelMap model) {
		if (service.possuiCargo(id)) {
			model.addAttribute("fail", "Departamento não removido. Possui cargo(s) vinculado(s).");
		}
		else {
			service.delete(id);
			model.addAttribute("success", "Departamento removido com sucesso.");
		}
		return listar(model);
	}
}
