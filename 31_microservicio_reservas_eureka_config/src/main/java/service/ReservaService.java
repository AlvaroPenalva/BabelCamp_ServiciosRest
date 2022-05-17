package service;

import java.util.List;

import dto.ReservaDto;
import model.Reserva;

public interface ReservaService {
	
	Reserva reservar(ReservaDto reserva);
	
	List<Reserva> findAll();

}
