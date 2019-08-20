package net.itinajero.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.itinajero.app.model.Pelicula;

@Service
public class PeliculasServiceImpl implements IPeliculasService {

	private List<Pelicula> lista = null;
	
	
	
	public PeliculasServiceImpl() {
		
	

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	
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
			
			
		}catch(ParseException e) {
			System.out.println("Error: " + e.getMessage());
			
		}
	}
	

	
	
	@Override
	public List<Pelicula> BuscarTodas() {
		// TODO Auto-generated method stub
		return lista;
	}



	@Override
	public Pelicula buscarPorId(int idPelicula) {
		for (Pelicula p: lista) {
		if(p.getId() == idPelicula)
			return p;
		}
		return null;
	}




	@Override
	public void insertar(Pelicula pelicula) {
		lista.add(pelicula);
		System.out.print(pelicula);
	}




	@Override
	public List<String> buscarGeneros() {
		
		List<String> generos = new LinkedList<>();
		generos.add("Accion");
		generos.add("Aventura");
		generos.add("Clasicas");
		
		generos.add("Comedia Romantica");
		generos.add("Drama");
		generos.add("Terror");
		generos.add("Infantil");
		generos.add("Accion y Aventura");
		generos.add("Romantica");
		
		return generos;
	}

}
