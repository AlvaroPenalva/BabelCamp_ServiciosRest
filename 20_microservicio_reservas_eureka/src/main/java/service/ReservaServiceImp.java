package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import converters.ConversorReserva;
import dao.ReservaDao;
import dto.ReservaDto;
import model.Hotel;
import model.Reserva;
import model.Vuelo;

@Service
public class ReservaServiceImp implements ReservaService {

	ReservaDao rd;

	RestTemplate template;
	String urlHotel = "http://servicio-hoteles/hoteles_rest";
	String urlVuelo = "http://servicio-vuelos/vuelos_rest";

	public ReservaServiceImp(@Autowired ReservaDao rd, @Autowired RestTemplate template) {
		this.rd = rd;
		this.template = template;
	}

	@Override
	public Reserva reservar(ReservaDto reserva) {

		int plazas = reserva.getPlazas();

		Hotel h = template.getForObject(urlHotel + "/HotelId/" + reserva.getHotel(), Hotel.class);
		Vuelo v = template.getForObject(urlVuelo + "/VueloId/" + reserva.getVuelo(), Vuelo.class);

		if (h != null & v != null) {
			if (plazas <= v.getPlazas()) {
				ConversorReserva cr = new ConversorReserva();
				Reserva r = cr.dtoToReserva(reserva);
				//con esto podemos comprobar que nos devuelve put
				ResponseEntity<String> response = template
						.exchange(urlVuelo + "/Vuelo?idVuelo=" + v.getIdVuelo() + "&plazas=" + plazas, HttpMethod.PUT, null, String.class);
				//guardamos el body, en nuestro caso un string que es true o false
				String cuerpo = response.getBody();
				if(cuerpo.equals("true"))
				rd.save(r);
				return r;
			}
		}
		return null;
	}

	@Override
	public List<Reserva> findAll() {
		return rd.findAll();
	}

}
