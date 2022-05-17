package service;

import java.util.List;

import model.Producto;

public interface ProductoService {

	List<Producto> listarProductos();
	boolean actualizarStockProducto(int codigoProducto, int unidades);
	double getPrecio(int codigoProducto);
}
