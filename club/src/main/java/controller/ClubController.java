package controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import entity.Club;
import jakarta.validation.Valid;
import service.IClubService;

@Controller
//@SessionAttributes("club")
public class ClubController {

	@Autowired
	private IClubService clubService;

	@RequestMapping(value = "/clubes", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de clubes");
		model.addAttribute("clubes", clubService.findAll());
		return "clubes/listar";
	}
	
	@RequestMapping(value = "/clubes/form")
	public String crear(Map<String, Object> model) {
		Club club = new Club();
		model.put("club", club);
		model.put("titulo", "Formulario de Club");
		return "form_club";
	}
	
	@RequestMapping(value="/clubes/form/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model) {
		Club club = null;
		if(id > 0) {
			club = clubService.FindOne(id);
		} else {
			return "redirect:/clubes";
		}
		model.put("club", club);
		model.put("titulo", "Editar Club");
		return "form_club";
	}
	
	@RequestMapping(value = "/clubes/form", method = RequestMethod.POST)
	public String guardar(@Valid Club club, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Club");
			return "form_club";
		}
		
		clubService.save(club);
		status.setComplete();
		return "redirect:/clubes";
	}
	
	@RequestMapping(value="/clubes/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id) {
		if(id > 0) {
			clubService.delete(id);
		}
		return "redirect:/clubes";
	}
}
