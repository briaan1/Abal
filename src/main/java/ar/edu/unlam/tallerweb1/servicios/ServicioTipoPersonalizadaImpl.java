package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.TipoPersonalizado;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioTipoPersonalizada;

@Service @Transactional
public class ServicioTipoPersonalizadaImpl implements ServicioTipoPersonalizada{
	
	private RepositorioTipoPersonalizada repositorioPersonalizada;
	
	@Autowired
	public ServicioTipoPersonalizadaImpl(RepositorioTipoPersonalizada repositorioPersonalizada) {
		this.repositorioPersonalizada = repositorioPersonalizada;
	}

	@Override
	public void setProductoPersonalizado(Producto producto) {
		repositorioPersonalizada.guardarProductoPersonalizado(producto);
	}

	@Override
	public boolean agregarProductoPersonalizado(List<Producto> listaProductos) {
		TipoPersonalizado productoPersonalizado = new TipoPersonalizado();
		productoPersonalizado.setProducto(listaProductos);
		repositorioPersonalizada.guardarListaProductosPersonalizado(productoPersonalizado);
		return false;
	}

	

}
