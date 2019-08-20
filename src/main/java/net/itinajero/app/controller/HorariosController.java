package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import net.itinajero.app.model.Horario;
import net.itinajero.app.model.Pelicula;
import net.itinajero.app.service.IPeliculasService;

@Controller
@RequestMapping(value="/horarios")
public class HorariosController {
	
	@Autowired
	private IPeliculasService servicePeliculas;


	@GetMapping(value = "/create")
	public String crear(@ModelAttribute Horario horario, Model model ) {
		List<Pelicula> listaPeliculas = servicePeliculas.BuscarTodas();
		model.addAttribute("peliculas", listaPeliculas);
		return "horarios/formHorario";
	}

	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute Horario horario, BindingResult result, Model model) {				
		
		if (result.hasErrors()){
			List<Pelicula> listaPeliculas = servicePeliculas.BuscarTodas();
			model.addAttribute("peliculas", listaPeliculas);
			return "horarios/formHorario";
		}
		
		System.out.println("Guardando el objeto Horario: " + horario);
		return "redirect:/horarios/create";
	}
	

	@InitBinder("horario")
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));		
	}
	
}
