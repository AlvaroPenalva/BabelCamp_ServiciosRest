package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ProductosDao;
import model.Producto;

@Service
public class ProductoServiceImp implements ProductoService {

	ProductosDao pd;
	
	public ProductoServiceImp(@Autowired ProductosDao pd) {
		this.pd = pd;
	}
	
	@Override
	public List<Producto> listarProductos() {
		return pd.findAll();
	}

	@Override
	public boolean actualizarStockProducto(int codigoProducto, int unidades) {
		Optional<Producto> prod = pd.findById(codigoProducto);
		if(prod.isPresent()) {
			
			Producto aux = prod.get();
			
			if(aux.getStock() >= unidades) {
				aux.setStock(aux.getStock() - unidades);
				pd.save(aux);
				return true;
			}
		}
		return false;
	}

	@Override
	public double getPrecio(int codigoProducto) {
		Optional<Producto> prod = pd.findById(codigoProducto);
		if(prod.isPresent()) {
			return prod.get().getPrecioUnitario();
		}
		return -1;
	}

}
