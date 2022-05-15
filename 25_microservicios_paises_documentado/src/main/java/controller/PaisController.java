package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import model.Pais;
import service.PaisService;

@CrossOrigin("*")
@RestController
public class PaisController {

	@Autowired
	PaisService ps;
	
	@ApiOperation(value = "Devuelve una lista de continentes")
	@GetMapping(value="continentes", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> continentes() {
		return ps.continentes();
	}
	
	@ApiOperation(value = "Devuelve una lista de paises en el continente mandado por variable")
	@GetMapping(value="paises/{continente}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pais> paisesPorContinente(@ApiParam(value="Nombre del continente para buscar sus paises.")
											@PathVariable String continente) {
		return ps.paisPorContinente(continente);
	}
	
	@ApiOperation(value = "Devuelve la poblacion total de un continente pasado por variable")
	@GetMapping(value="poblacion/{continente}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String poblacionContinente(@ApiParam(value="Nombre del continente para calcular su poblacion")
										@PathVariable String continente) {
		return String.valueOf(ps.habitantesContinente(continente));
	}
	
	
}
