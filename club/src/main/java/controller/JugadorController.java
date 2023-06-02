package controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import entity.Jugador;
import jakarta.validation.Valid;
import service.IJugadorService;

@Controller
@SessionAttributes("jugador")
public class JugadorController {

	@Autowired
	private IJugadorService jugadorService;

	@RequestMapping(value = "/jugadores", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de jugadores");
		model.addAttribute("jugadores", jugadorService.findAll());
		return "jugadores/listar";
	}

	@RequestMapping(value = "/jugadores/form")
	public String crear(Map<String, Object> model) {
		Jugador jugador = new Jugador();
		model.put("jugador", jugador);
		model.put("titulo", "Formulario de Jugador");
		return "jugadores/form";
	}

	@RequestMapping(value = "/jugadores/form/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model) {
		Jugador jugador = null;
		if (id > 0) {
			jugador = jugadorService.FindOne(id);
		} else {
			return "redirect:/jugadores";
		}
		model.put("jugador", jugador);
		model.put("titulo", "Editar Jugador");
		return "jugadores/form";
	}

	@RequestMapping(value = "/jugadores/form", method = RequestMethod.POST)
	public String guardar(@Valid Jugador jugador, BindingResult result, Model model, SessionStatus status) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Jugador");
			return "jugadores/form";
		}

		jugadorService.save(jugador);
		status.setComplete();
		return "redirect:/jugadores";
	}

	@RequestMapping(value = "/jugadores/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {
		if (id > 0) {
			jugadorService.delete(id);
		}
		return "redirect:/jugadores";
	}
}
