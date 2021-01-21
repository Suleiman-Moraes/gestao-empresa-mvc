package br.com.suleimanmoraes.demomvc.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.suleimanmoraes.demomvc.api.model.Cargo;
import br.com.suleimanmoraes.demomvc.api.model.Departamento;
import br.com.suleimanmoraes.demomvc.api.service.CargoService;
import br.com.suleimanmoraes.demomvc.api.service.DepartamentoService;

@Controller
@RequestMapping("/cargos")
public class CargoController {

	private static final String CARGO = "cargo";
	private static final String CARGO_CADASTRO = "cargo/cadastro";

	@Autowired
	private CargoService service;

	@Autowired
	private DepartamentoService departamentoService;

	@GetMapping("/cadastrar")
	public String cadastrar(Cargo cargo) {
		return CARGO_CADASTRO;
	}

	@GetMapping("/listar")
	public String listar(ModelMap model, @RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {
		final Page<Cargo> pagina = service.findAll(page.orElse(0), size.orElse(5));
		model.addAttribute("pagina", pagina);
		return CARGO + "/lista";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid Cargo cargo, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return CARGO_CADASTRO;
		}

		service.save(cargo);
		attr.addFlashAttribute("success", "Cargo criado com sucesso.");
		return "redirect:/cargos/listar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") long id, ModelMap model) {
		Cargo cargo = service.findById(id);
		model.addAttribute("cargo", cargo);
		return cadastrar(cargo);
	}

	@PostMapping("/editar")
	public String editar(@Valid Cargo cargo, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return CARGO_CADASTRO;
		}
		service.update(cargo);
		attr.addFlashAttribute("success", "Cargo editado com sucesso.");
		return "redirect:/cargos/listar";
	}

	@ModelAttribute("departamentos")
	public List<Departamento> listarDepartamentos(ModelMap model) {
		return departamentoService.findAll();
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") long id, ModelMap model) {
		if (service.possuiFuncionario(id)) {
			model.addAttribute("fail", "Cargo não removido. Possui funcionário(s) vinculado(s).");
		} else {
			service.delete(id);
			model.addAttribute("success", "Cargo removido com sucesso.");
		}
		return "redirect:/cargos/listar";
	}
}
