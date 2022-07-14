package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.modelo.DetalleDePedido;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.TipoPersonalizado;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

public  interface RepositorioPedido {
    
	void registrarPedido(Pedido pedido);
	
	void registrarDetalleDePedido(DetalleDePedido detalleDePedido);

	List<Pedido> getListaDePedidos(Usuario usuario);

	List<DetalleDePedido> getListaDeProductos(int idPedido);

	Pedido getPedido(int idPedido);

	Producto getProductoPersonalizado();

	List<DetalleDePedido> getListaDeProductosPersonalizados(int idPedido);

	TipoPersonalizado getPersonalizado(int idProductoPersonalizado);
}
