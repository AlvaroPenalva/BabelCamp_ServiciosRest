package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.VueloDao;
import model.Vuelo;

@Service
public class VueloServiceImp implements VueloService {

	VueloDao vd;
	
	public VueloServiceImp(@Autowired VueloDao vd) {
		this.vd = vd;
	}
	
	@Override
	public List<Vuelo> findByPlazas(int plazas) {
		return vd.findByPlazas(plazas);
	}

	@Override
	public boolean restarPlazasVuelo(int idVuelo, int plazas) {
		Optional<Vuelo> vuelo = vd.findById(idVuelo);
		if(vuelo.isPresent()) {
			Vuelo v = vuelo.get();
			v.setPlazas(v.getPlazas() - plazas);
			vd.save(v);
			return true;
		}
		return false;
	}

	@Override
	public Vuelo findById(int idVuelo) {
		Optional<Vuelo> v = vd.findById(idVuelo);
		if(v.isPresent()) return v.get();
		return null;
	}



}
