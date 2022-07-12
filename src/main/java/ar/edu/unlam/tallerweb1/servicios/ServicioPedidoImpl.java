package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.modelo.DetalleDePedido;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCarrito;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ServicioPedidoImpl implements ServicioPedido {
    private RepositorioPedido repositorioPedido;

    @Autowired
    public ServicioPedidoImpl(RepositorioPedido repositorioPedido) {
        this.repositorioPedido = repositorioPedido;
    }
    
    @Override
	public void registrarPedido(Usuario usuario, List<Carrito> listaDeProductosDelCarrito) {
    	Pedido pedido = new Pedido();
    	pedido.setUsuario(usuario);
    	LocalDateTime dateTime = LocalDateTime.now();
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    	pedido.setFecha(formatter.format(dateTime));
		repositorioPedido.registrarPedido(pedido);
		
		for (int i = 0; i < listaDeProductosDelCarrito.size(); i++) {
			DetalleDePedido detalleDePedido=new DetalleDePedido();
			detalleDePedido.setPedido(pedido);
			detalleDePedido.setProductoDetalle(listaDeProductosDelCarrito.get(i).getProducto());
			repositorioPedido.registrarDetalleDePedido(detalleDePedido);
		}
		
	}

	@Override
	public List<Pedido> getListaDePedidos(Usuario usuario) {
		List<Pedido> listaDePedidos=repositorioPedido.getListaDePedidos(usuario);
		if(listaDePedidos.size()!=0) {
			return listaDePedidos;
		}else {
			return new ArrayList<Pedido>();
		}
	}
}
