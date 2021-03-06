package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dto.ReservaDto;
import model.Reserva;
import service.ReservaService;

@RestController
@CrossOrigin("*")
public class ReservaController {

	@Autowired
	ReservaService rs;
	
	@GetMapping(value = "Reservas")
	public List<Reserva> getReservas(){
		return rs.findAll();
	}
	
	@PostMapping(value = "Reserva", consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Reserva reservar(@RequestBody ReservaDto reserva) {
		return rs.reservar(reserva); 
	}
	
}
