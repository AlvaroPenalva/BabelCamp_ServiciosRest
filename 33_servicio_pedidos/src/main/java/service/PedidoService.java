package service;

import java.util.List;

import model.Pedido;

public interface PedidoService {

	List<Pedido> listarPedidos();
	Pedido insertarPedido(Pedido p);
}
