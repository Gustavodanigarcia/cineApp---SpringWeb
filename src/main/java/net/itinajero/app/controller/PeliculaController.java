package net.itinajero.app.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.itinajero.app.model.Pelicula;
import net.itinajero.app.service.IPeliculasService;
import net.itinajero.app.util.Utileria;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {
	
	@Autowired
	private IPeliculasService peliculaService;
	

	
	
	
	
	
	@GetMapping(value="/index")
	public String mostrarIndex(Model model) {
		
		List<Pelicula> lista = peliculaService.BuscarTodas();
		model.addAttribute("peliculas", lista);
		
		return "peliculas/listPeliculas";

		
	}
	
	
	
	
	
	
	@GetMapping(value="/create")
	public String crear(@ModelAttribute Pelicula pelicula, Model model) {
		model.addAttribute("generos", peliculaService.buscarGeneros());
		return "peliculas/formPelicula";
		
	}
	
	
	@PostMapping(value="/save")
	public String guardar(@ModelAttribute Pelicula pelicula , BindingResult result, Model model, RedirectAttributes attributes, @RequestParam("archivoImagen") MultipartFile multiPart, HttpServletRequest request) {
		
		if(result.hasErrors()) {

			return "peliculas/formPelicula";
		}

		
		if (!multiPart.isEmpty()) {
			String nombreImagen = Utileria.guardarImagen(multiPart,request);
			pelicula.setImagen(nombreImagen);
			}
		
		
		Utileria.formatoYoutube(pelicula);
		
		peliculaService.insertar(pelicula);	

		attributes.addFlashAttribute("mensaje" ,"La Pelicula se agrego exitosamente");
		
		return "redirect:/peliculas/index";
		
		
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
}
