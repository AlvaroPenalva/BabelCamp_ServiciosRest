package service;

import java.util.List;

import model.Vuelo;

public interface VueloService {

	public List<Vuelo> findByPlazas(int plazas);
	public boolean updateVuelo(int idVuelo, int plazas);
	public Vuelo findById(int idVuelo);
}
