package br.com.suleimanmoraes.demomvc.api.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.suleimanmoraes.demomvc.api.controller.validator.FuncionarioValidator;
import br.com.suleimanmoraes.demomvc.api.enums.UfEnum;
import br.com.suleimanmoraes.demomvc.api.model.Cargo;
import br.com.suleimanmoraes.demomvc.api.model.Funcionario;
import br.com.suleimanmoraes.demomvc.api.service.CargoService;
import br.com.suleimanmoraes.demomvc.api.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

	private static final String FUNCIONARIO = "funcionario";
	private static final String FUNCIONARIO_CADASTRO = FUNCIONARIO + "/cadastro";

	@Autowired
	private FuncionarioService service;

	@Autowired
	private CargoService cargoService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new FuncionarioValidator());
	}

	@GetMapping("/cadastrar")
	public String cadastrar(Funcionario funcionario) {
		return FUNCIONARIO_CADASTRO;
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("funcionarios", service.findAll());
		return FUNCIONARIO + "/lista";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return FUNCIONARIO_CADASTRO;
		}
		
		service.save(funcionario);
		attr.addFlashAttribute("success", "Funcionário criado com sucesso.");
		return "redirect:/funcionarios/listar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") long id, ModelMap model) {
		Funcionario funcionario = service.findById(id);
		model.addAttribute("funcionario", funcionario);
		return cadastrar(funcionario);
	}

	@PostMapping("/editar")
	public String editar(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return FUNCIONARIO_CADASTRO;
		}
		
		service.update(funcionario);
		attr.addFlashAttribute("success", "Funcionário editado com sucesso.");
		return "redirect:/funcionarios/listar";
	}

	@ModelAttribute("cargos")
	public List<Cargo> listarDepartamentos() {
		return cargoService.findAll();
	}

	@ModelAttribute("ufs")
	public UfEnum[] getUfs() {
		return UfEnum.values();
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") long id, ModelMap model) {
		service.delete(id);
		model.addAttribute("success", "Funcionário removido com sucesso.");
		return listar(model);
	}

	@GetMapping("/buscar/nome")
	public String findByNomeIgnoreCaseContaining(@RequestParam("nome") String nome, ModelMap model) {
		model.addAttribute("funcionarios", service.findByNomeIgnoreCaseContaining(nome));
		return FUNCIONARIO + "/lista";
	}

	@GetMapping("/buscar/cargo/id")
	public String findByCargoId(@RequestParam("id") long cargoId, ModelMap model) {
		if (cargoId > 0) {
			model.addAttribute("funcionarios", service.findByCargoId(cargoId));
			return FUNCIONARIO + "/lista";
		} else {
			return listar(model);
		}
	}

	@GetMapping("/buscar/data")
	public String findByDataEntradaOrDataSaida(
			@RequestParam(value = "entrada", required = false) @DateTimeFormat(iso = ISO.DATE) LocalDate dataEntrada,
			@RequestParam(value = "saida", required = false) @DateTimeFormat(iso = ISO.DATE) LocalDate dataSaida,
			ModelMap model) {
		model.addAttribute("funcionarios", service.findByDataEntradaOrDataSaida(dataEntrada, dataSaida));
		return FUNCIONARIO + "/lista";
	}
}
