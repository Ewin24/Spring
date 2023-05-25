package com.crud.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.crud.app.entity.Cliente;
import com.crud.app.service.IClienteService;

@Controller
public class ClienteController {

	@Autowired
	private IClienteService clienteservice;

	@GetMapping("/index")
	public String index() {
		return "index";
	}

	@GetMapping(value = "/form")
	public String crear(Map<String, Object> model) {

		return "form";
	}

	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("clientes", clienteservice.findAll());
		return "listar";
	}

	@PostMapping("/form")
	public String guardar(@ModelAttribute("cliente") Cliente cliente) {
		clienteservice.save(cliente);
		return "redirect:listar";

	}

	@GetMapping("/form/{id}")
	public String editar(@PathVariable("id") Long id, Map<String, Object> model) {

		Cliente cliente = null;

		if (id > 0) {
			cliente = clienteservice.FindOne(id);
		} else {
			return "redirect:/listar";
		}
		model.put("cliente", cliente);
		return "form";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {
		if (id > 0) {

			clienteservice.delete(id);
		}

		return "redirect:/listar";
	}

}
