package controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.trabajo1.app.entidades.Jugador;

import service.IJugadorService;

@Controller
public class JugadoresController {
	@Autowired IJugadorService jugadorService;
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping(value = "/form")
	public String crear(Map<String, Object>model) {
		return "form";
	}
	
	@GetMapping(value = "/listar")
	public String listar(Model model) {
		model.addAttribute("jugadores", jugadorService.findAll());
		return "listar";
	}
	
	@GetMapping(value = "/form/{id}")
	public String editar(@PathVariable("id") Long id, Map<String, Object> model) {
		Jugador jugador = null;
		if(id > 0) {
			jugador = jugadorService.FindOne(id);
		}else {
			return "redirect:/listar";
		}
		model.put("jugador", jugador);
		return "form";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {
		if(id > 0) {
			jugadorService.delete(id);
		}
		return "redirect:/listar";
	}

}
