package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Pedido;
import service.PedidoService;

@CrossOrigin("*")
@RestController
public class PedidoController {

	@Autowired
	PedidoService ps;
	
	@GetMapping(value = "Pedidos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pedido> getPedidos(){
		return ps.listarPedidos();
	}
	
	@PostMapping(value="newPedido", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Pedido insertarPedido(@RequestBody Pedido p) {
		return ps.insertarPedido(p);
	}
	
}
