package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

public interface ServicioPedido {
	void registrarPedido(Usuario usuario, List<Carrito> listaDeProductosDelCarrito);

	List<Pedido> getListaDePedidos(Usuario usuario);
}
