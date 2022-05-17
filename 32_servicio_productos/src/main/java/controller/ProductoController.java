package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import model.Producto;
import service.ProductoService;

@RestController
@CrossOrigin("*")
public class ProductoController {
	
	@Autowired
	ProductoService ps;
	
	@GetMapping(value="Productos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Producto> getProductos(){
		return ps.listarProductos();
	}
	
	@PutMapping(value="ProductoStock/{codigoProducto}/{stock}")
	public String actualizarProducto(@PathVariable int codigoProducto,@PathVariable("stock") int stock) {
		return String.valueOf(ps.actualizarStockProducto(codigoProducto, stock));
	}
	
	@GetMapping(value="ProductoId/{codigoProducto}")
	public double getPrecio(@PathVariable("codigoProducto") int codigoProducto) {
		return ps.getPrecio(codigoProducto);
	}

}
