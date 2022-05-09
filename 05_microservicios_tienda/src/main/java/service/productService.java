package service;

import java.util.List;

import model.Producto;

public interface productService {

	public void create(Producto producto);
	public void delete(int idProducto);
	public List<Producto> findAll();
	public List<Producto> findBySeccion(String seccion);
}
