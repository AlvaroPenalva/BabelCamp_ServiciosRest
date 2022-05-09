package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Producto;

public interface ProductoDao extends JpaRepository<Producto, Integer>{
	@Query("select p from Product p where p.seccion=?1")
	List<Producto> findBySeccion(String seccion);
}
