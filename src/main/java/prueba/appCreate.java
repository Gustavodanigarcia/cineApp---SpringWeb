package prueba;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class appCreate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		
		
		List<Noticia> listaActivas = repo.findByIdLessThan(7);
		
		for (Noticia n: listaActivas) {
			
			System.out.println("Noticias activas: " + n.getId());
			
		}
		
		
		
		
		
		
		
//		
//		Page<Noticia> page = repo.findAll(PageRequest.of(1,5, Sort.by("id")));
//		
//		for(Noticia n: page) {
//			
//			System.out.println(n.getId() + " titulo: "+ n.getTitulo());
//			
//		}
		
		
//		List<Noticia> noticia = repo.findAll(Sort.by("titulo").ascending().and(Sort.by("fecha").ascending()));
//		
//		for (Noticia n: noticia) {
//			
//			System.out.println("PELICULA NUMERO: " + n.getId() + " ESTATUS: " + n.getFecha());
//		}
		
//		List<Integer> ids = new LinkedList<>();
//		
//		ids.add(1);
//		ids.add(2);
//		ids.add(6);
//		ids.add(53);
//		
//		
//		Iterable<Noticia> it = repo.findAllById(ids);
//		
//		
//		for(Noticia n : it) {
//			
//			
//			System.out.println(n.getDetalle());
//		}
//		
		
		context.close();
	}

}
