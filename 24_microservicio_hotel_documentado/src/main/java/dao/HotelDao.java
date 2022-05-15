package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Hotel;

public interface HotelDao extends JpaRepository<Hotel, Integer>{

	@Query("select h from Hotel h where nombre Like ?1")
	public Hotel findByNombre(String nombre);
}
