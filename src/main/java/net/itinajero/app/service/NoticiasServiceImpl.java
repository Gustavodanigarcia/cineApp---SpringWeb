package net.itinajero.app.service;

import org.springframework.stereotype.Service;

import net.itinajero.app.model.Noticia;

@Service
public class NoticiasServiceImpl implements INoticiasService{

	
	Noticia noticia = null;
	
	public NoticiasServiceImpl() {
		
		
		
		
	}
	
	
	
	
	
	@Override
	public void guardar(Noticia Noticia) {
	
		System.out.println("Guadando el objeto " + Noticia + " en la base de datos.");
	}

}
