package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import model.Pais;
import service.PaisService;

@CrossOrigin("*")
@RestController
public class PaisController {

	@Autowired
	PaisService ps;
	
	@GetMapping(value="continentes", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> continentes() {
		return ps.continentes();
	}
	
	@GetMapping(value="paises/{continente}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pais> paisesPorContinente(@PathVariable String continente) {
		return ps.paisPorContinente(continente);
	}
	
	@GetMapping(value="poblacion/{continente}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String poblacionContinente(@PathVariable String continente) {
		return String.valueOf(ps.habitantesContinente(continente));
	}
	
	
}
