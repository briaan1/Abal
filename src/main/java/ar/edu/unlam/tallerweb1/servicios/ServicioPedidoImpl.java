package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.modelo.DetalleDePedido;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.TipoPersonalizado;
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
	public void registrarPedido(Usuario usuario, List<Carrito> listaDeProductosDelCarrito,  Double total, String nombre, String apellido, String telefono, String email, String direccion, String localidad, String codigoPostal) {
    	Pedido pedido = new Pedido();
    	pedido.setUsuario(usuario);
    	LocalDateTime dateTime = LocalDateTime.now();
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    	pedido.setFecha(formatter.format(dateTime));
    	pedido.setTotal(total);
    	pedido.setNombre(nombre);
    	pedido.setApellido(apellido);
    	pedido.setTelefono(telefono);
    	pedido.setDireccion(direccion);
    	pedido.setLocalidad(localidad);
    	pedido.setEmail(email);
    	pedido.setCodigoPostal(codigoPostal);
		repositorioPedido.registrarPedido(pedido);
		
		for (int i = 0; i < listaDeProductosDelCarrito.size(); i++) {
			DetalleDePedido detalleDePedido=new DetalleDePedido();
			detalleDePedido.setPedido(pedido);
			if(listaDeProductosDelCarrito.get(i).getProducto()==null) {
				detalleDePedido.setIdProductoPersonalizado(listaDeProductosDelCarrito.get(i).getProductoPersonalizado().getId());
				detalleDePedido.setProductoDetalle(repositorioPedido.getProductoPersonalizado());
			}else {
				detalleDePedido.setProductoDetalle(listaDeProductosDelCarrito.get(i).getProducto());
			}
			
			
			detalleDePedido.setCantidad(listaDeProductosDelCarrito.get(i).getCantidad());
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

	@Override
	public List<DetalleDePedido> getListaDeProductos(int idPedido) {
		List<DetalleDePedido> listaDePedidos=repositorioPedido.getListaDeProductos(idPedido);
		if(listaDePedidos.size()!=0) {
			return listaDePedidos;
		}else {
			return new ArrayList<DetalleDePedido>();
		}
	}
	
	@Override
	public List<DetalleDePedido> getListaDeProductosPersonalizados(int idPedido) {
		List<DetalleDePedido> listaDePedidos=repositorioPedido.getListaDeProductosPersonalizados(idPedido);
		if(listaDePedidos.size()!=0) {
			return listaDePedidos;
		}else {
			return new ArrayList<DetalleDePedido>();
		}
	}
	
	@Override
	public List<TipoPersonalizado> getListaDeTipoPersonalizado(List<DetalleDePedido> listaDeProductoPersonalizado){
		List<TipoPersonalizado> listaDeTipoPersonalizado=new ArrayList<TipoPersonalizado>();
		
		for (int i = 0; i < listaDeProductoPersonalizado.size(); i++) {
			TipoPersonalizado tipoPersonalizado=repositorioPedido.getPersonalizado(listaDeProductoPersonalizado.get(i).getIdProductoPersonalizado());
			listaDeTipoPersonalizado.add(tipoPersonalizado);
		}
	
		if(listaDeTipoPersonalizado.size()!=0) {
			return listaDeTipoPersonalizado;
		}else {
			return new ArrayList<TipoPersonalizado>();
		}
	}

	@Override
	public Double sumarElTotalDeLosProductos(List<DetalleDePedido> listaDeProductosDelPedido) {
		Double sumaProductos=0.0;
	      for (int i=0;i<listaDeProductosDelPedido.size();i++){
	         sumaProductos += (listaDeProductosDelPedido.get(i).getProductoDetalle().getPrecio()*listaDeProductosDelPedido.get(i).getCantidad());
	      }
	        return sumaProductos;
	}
	
	@Override
	public Double sumarElTotalDeTipoPersonalizado(List<TipoPersonalizado> listaDeTipoPersonalizado) {
		Double sumaProductos=0.0;
	      for (int i=0;i<listaDeTipoPersonalizado.size();i++){
	         sumaProductos += (listaDeTipoPersonalizado.get(i).getPrecioTotal()*listaDeTipoPersonalizado.get(i).getCantPerzonalizada());
	      }
	        return sumaProductos;
	}

	@Override
	public Pedido getPedido(int idPedido) {
		return repositorioPedido.getPedido(idPedido);
	}
}
