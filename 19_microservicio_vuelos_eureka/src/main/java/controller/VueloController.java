package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import model.Vuelo;
import service.VueloService;

@RestController
@CrossOrigin("*")
public class VueloController {

	@Autowired
	VueloService hs;
	
	@GetMapping(value ="Vuelos/{plazas}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Vuelo> getVuelosPlazas(@PathVariable("plazas") int plazas){
		return hs.findByPlazas(plazas);
	}
	
	@PutMapping(value ="Vuelo",produces=MediaType.TEXT_PLAIN_VALUE)
	public String updateVuelo(@RequestParam("idVuelo") int idVuelo, @RequestParam("plazas") int plazas){
		return String.valueOf(hs.restarPlazasVuelo(idVuelo, plazas));
	}
	
	@GetMapping(value ="VueloId/{idVuelo}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Vuelo getVuelo(@PathVariable("idVuelo") int idVuelo){
		return hs.findById(idVuelo);
	}
}
