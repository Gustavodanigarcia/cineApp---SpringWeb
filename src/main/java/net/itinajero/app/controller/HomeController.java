package net.itinajero.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.itinajero.app.model.Pelicula;
import net.itinajero.app.util.Utileria;

@Controller
public class HomeController {

	
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String goHome(){
		return "home";
	}
	

	
	@RequestMapping(value="search", method=RequestMethod.POST)
	public String buscar(@RequestParam("fecha") String fecha){
		System.out.print(fecha);
		return "home";
	}
	

	
	
	
	
	
	//
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String mostrarPrincipal(Model model){

		List<String> listaFechas = Utileria.getNextDays(4);

		List<Pelicula> peliculas = getLista();

		model.addAttribute("fechas", listaFechas);
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		model.addAttribute("peliculas", peliculas);

		return "home";
	}	
	
	
	
	
	
	//@RequestMapping(value="/detail/{id}/{fecha}", method=RequestMethod.GET)
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String mostrarDetalle(Model model, @RequestParam("idMovie") int idPelicula,  @RequestParam("fecha") String fecha){
		
		System.out.println(idPelicula + " = id pelicula");
		System.out.println(fecha + " = Fecha");
		

		String tituloPelicula = "Rapido y jugoso";
		int duracion = 133;
		double precioEntrada = 50;
		
		model.addAttribute("titulo", tituloPelicula);
		model.addAttribute("duracion", duracion);
		model.addAttribute("precio", precioEntrada);
		return "detalle";
	}
	
	
	
	
	
	private List<Pelicula> getLista(){
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		List<Pelicula> lista = null;
		try {
			lista = new LinkedList<>();
			
			Pelicula pelicula1 = new Pelicula();
			pelicula1.setId(1);
			pelicula1.setTitulo("Power rangers");
			pelicula1.setDuracion(120);
			pelicula1.setClasificacion("B");
			pelicula1.setGenero("Aventura");
			pelicula1.setFechaEstreno(formatter.parse("06-09-2019"));
			pelicula1.setImagen("power_rangers.jpg");
			pelicula1.setEstatus("Activa");
			
			Pelicula pelicula2 = new Pelicula();
			pelicula2.setId(2);
			pelicula2.setTitulo("Titanic");
			pelicula2.setDuracion(220);
			pelicula2.setClasificacion("A");
			pelicula2.setGenero("Historia");
			pelicula2.setFechaEstreno(formatter.parse("07-09-2019"));
			pelicula2.setImagen("titanic.jpg");
			pelicula2.setEstatus("Activa");
			
			
			Pelicula pelicula3 = new Pelicula();
			pelicula3.setId(3);
			pelicula3.setTitulo("El Ojo alcon");
			pelicula3.setDuracion(220);
			pelicula3.setClasificacion("C");
			pelicula3.setGenero("Comedia");
			pelicula3.setFechaEstreno(formatter.parse("09-09-2019"));
			pelicula3.setImagen("halcon.jpg");
			pelicula3.setEstatus("Activa");
			
			
			Pelicula pelicula4 = new Pelicula();
			pelicula4.setId(4);
			pelicula4.setTitulo("Patoruzzito");
			pelicula4.setDuracion(220);
			pelicula4.setClasificacion("B");
			pelicula4.setGenero("Dibujo");
			pelicula4.setFechaEstreno(formatter.parse("12-09-2019"));
			pelicula4.setImagen("patoruzito.jpg");
			pelicula4.setEstatus("Inactiva");
			
			Pelicula pelicula5 = new Pelicula();
			pelicula5.setId(5);
			pelicula5.setTitulo("Life: Vida Inteligente");
			pelicula5.setDuracion(220);
			pelicula5.setClasificacion("B");
			pelicula5.setGenero("Drama");
			pelicula5.setFechaEstreno(formatter.parse("15-09-2019"));
			pelicula5.setImagen("estreno5.png");
			pelicula5.setEstatus("Inactiva");
			
			
			lista.add(pelicula1);
			lista.add(pelicula2);
			lista.add(pelicula3);
			lista.add(pelicula4);
			lista.add(pelicula5);
			
			return lista;
		}catch(ParseException e) {
			System.out.println("Error: " + e.getMessage());
			return null;
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
