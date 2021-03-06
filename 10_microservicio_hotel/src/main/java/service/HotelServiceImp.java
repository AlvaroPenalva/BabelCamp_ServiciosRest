package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.HotelDao;
import model.Hotel;

@Service
public class HotelServiceImp implements HotelService {

	HotelDao hd;
	
	public HotelServiceImp(@Autowired HotelDao hd) {
		this.hd = hd;
	}
	
	@Override
	public List<Hotel> findAll() {
		return hd.findAll();
	}

	@Override
	public Hotel findByNombre(String nombre) {
		return hd.findByNombre(nombre);
	}

	@Override
	public Hotel findById(int idHotel) {
		Optional<Hotel> h = hd.findById(idHotel);
		if(h.isPresent()) return h.get();
		return	null;
	}

}
