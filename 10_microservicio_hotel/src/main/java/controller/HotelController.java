package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import model.Hotel;
import service.HotelService;

@RestController
@CrossOrigin("*")
public class HotelController {

	@Autowired
	HotelService hs;
	
	@GetMapping(value ="Hoteles",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Hotel> getHoteles(){
		return hs.findAll();
	}
	
	@GetMapping(value ="Hotel/{nombre}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Hotel getHotelNombre(@PathVariable("nombre") String nombre){
		return hs.findByNombre(nombre);
	}
	
	@GetMapping(value ="HotelId/{idHotel}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Hotel getHotelId(@PathVariable("idHotel") int idHotel){
		return hs.findById(idHotel);
	}
}
