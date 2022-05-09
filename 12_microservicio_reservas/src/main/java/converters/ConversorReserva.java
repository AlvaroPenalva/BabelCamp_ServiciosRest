package converters;

import dto.ReservaDto;
import model.Reserva;

public class ConversorReserva {

	public Reserva dtoToReserva(ReservaDto rd) {
		return new Reserva(0, rd.getNombre(), rd.getDni(), rd.getHotel(),
				rd.getVuelo());
	}
	
}
