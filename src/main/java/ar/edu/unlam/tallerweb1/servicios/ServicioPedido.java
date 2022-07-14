package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.modelo.DetalleDePedido;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.TipoPersonalizado;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

public interface ServicioPedido {
	void registrarPedido(Usuario usuario, List<Carrito> listaDeProductosDelCarrito, Double total, String nombre, String apellido, String telefono, String direccion, String localidad, String localidad2, String codigoPostal);

	List<Pedido> getListaDePedidos(Usuario usuario);

	List<DetalleDePedido> getListaDeProductos(int idPedido);

	Double sumarElTotalDeLosProductos(List<DetalleDePedido> listaDeProductosDelPedido);

	Pedido getPedido(int idPedido);

	List<DetalleDePedido> getListaDeProductosPersonalizados(int idPedido);

	List<TipoPersonalizado> getListaDeTipoPersonalizado(List<DetalleDePedido> listaDeProductoPersonalizado);

	Double sumarElTotalDeTipoPersonalizado(List<TipoPersonalizado> listaDeTipoPersonalizado);
}
