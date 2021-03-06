package service;

import java.util.List;

import model.Hotel;

public interface HotelService {

	public List<Hotel> findAll();
	public Hotel findByNombre(String nombre);
	public Hotel findById(int idHotel);
}
