package net.itinajero.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import net.itinajero.app.service.INoticiasService;
import net.itinajero.app.model.Noticia;

@Controller
@RequestMapping("/noticias")
public class NoticiasController {

		@Autowired
		private INoticiasService noticiaService;
		
		@GetMapping(value="/create")
		public String crear() {
			return "noticias/formNoticia";
		}
		
		
		@PostMapping(value="/save")
		public String guardar(Noticia noticia) {
			
		
			noticiaService.guardar(noticia);
		
			
			return "noticias/formNoticia";
			
		}
			
		
	
}
