package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Pagina;
import service.BuscadorService;

@RestController
public class BuscadorController {
	
	@Autowired
	BuscadorService bs;
	
	@GetMapping(value="Paginas", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Pagina> listAll(){
		return bs.paginas();
	}
	@GetMapping(value="Paginas/{tematica}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Pagina> buscar(@PathVariable("tematica") String tematica){
		return bs.buscar(tematica);
	}
	@PostMapping(value="Pagina", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void alta(@RequestBody Pagina pagina) {
		bs.alta(pagina);
	}
}
