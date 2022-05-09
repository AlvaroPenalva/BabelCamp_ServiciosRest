package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import dao.ProductoDao;
import model.Producto;
@Service
public class ProductServiceImp implements productService {
	
	@Autowired
	ProductoDao pd;

	@Override
	public void create(Producto p) {
		if(pd.findById(p.getId()) == null)
		pd.save(p);
	}

	@Override
	public void delete(int idProducto) {
		if(pd.findById(idProducto) != null)
		pd.deleteById(idProducto);
	}

	@Override
	public List<Producto> findAll() {
		return pd.findAll();
	}

	@Override
	public List<Producto> findBySeccion(String seccion) {
		return pd.findBySeccion(seccion);
	}

}
