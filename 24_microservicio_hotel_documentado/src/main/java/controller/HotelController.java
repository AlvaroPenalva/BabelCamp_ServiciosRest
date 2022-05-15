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
import model.Hotel;
import service.HotelService;

@RestController
@CrossOrigin("*")
public class HotelController {

	@Autowired
	HotelService hs;
	
	@ApiOperation(value = "Devuelve los datos de los hoteles")
	@GetMapping(value ="Hoteles",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Hotel> getHoteles(){
		return hs.findAll();
	}
	
	@ApiOperation(value = "Devuelve los datos de un hotel cuyo nombre recibe por variable")
	@GetMapping(value ="Hotel/{nombre}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Hotel getHotelNombre(@ApiParam(value = "Nombre del hotel a buscar")
								@PathVariable("nombre") String nombre){
		return hs.findByNombre(nombre);
	}
	
	@ApiOperation(value = "Devuelve los datos de un hotel cuyo id recibe por variable")
	@GetMapping(value ="HotelId/{idHotel}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Hotel getHotelId(@ApiParam(value = "Id del hotel a buscar")
							@PathVariable("idHotel") int idHotel){
		return hs.findById(idHotel);
	}
}
