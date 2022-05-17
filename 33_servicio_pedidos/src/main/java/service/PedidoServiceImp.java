package service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dao.PedidosDao;
import model.Pedido;

@Service
public class PedidoServiceImp implements PedidoService {

	PedidosDao pd;
	RestTemplate template;
	String urlProducto = "http://servicio-productos/";
	
	public PedidoServiceImp(@Autowired PedidosDao pd, @Autowired RestTemplate rt) {
		this.pd = pd;
		this.template=rt;
	}
	
	@Override
	public List<Pedido> listarPedidos() {
		return pd.findAll();
	}

	@Override
	public Pedido insertarPedido(Pedido p) {
		int codigoProducto = p.getCodigoProducto();
		int stock = p.getUnidades();
		
		ResponseEntity<String> response=template.exchange(urlProducto+"ProductoStock/{codigoProducto}/{stock}", 
				HttpMethod.PUT,
				null, //new HttpEntity(dato_cuerpo)
				String.class,
				codigoProducto,
				stock);
		
		if(response.getBody().equals("true")) {
			p.setFechaPedido(new Date());
			double precio = template.getForObject(urlProducto+ "ProductoId/{codigoProducto}", Double.class, codigoProducto);
			precio *= stock;
			p.setTotal(precio);
			pd.save(p);
			return p;
		}
		
		return null;
		
	}

}
