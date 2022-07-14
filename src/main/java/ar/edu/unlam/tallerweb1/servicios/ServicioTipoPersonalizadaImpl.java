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
	public TipoPersonalizado agregarProductoPersonalizado(List<Producto> listaProductos,int CantPersonalizadas, String nombre) {
		TipoPersonalizado productoPersonalizado = new TipoPersonalizado();
		int codigoProducto = this.generarId(listaProductos);
		Double precioTotalPorciones = this.sumarTotalDePorciones(listaProductos);
		
		productoPersonalizado.setProducto(listaProductos);
		productoPersonalizado.setCodigoPersonalizado(codigoProducto);
		productoPersonalizado.setPrecioTotal(precioTotalPorciones);
		productoPersonalizado.setCantPerzonalizada(CantPersonalizadas);
		productoPersonalizado.setNombre(nombre);
		repositorioPersonalizada.guardarListaProductosPersonalizado(productoPersonalizado);
		
		return productoPersonalizado;
	}

	@Override
	public int generarId(List<Producto> listaProductos) {
		int codigoProducto=0;
		//int numeroAleatorio = (int)(Math.random() * 3);
		
		for(int i=0;i<listaProductos.size();i++) {
			codigoProducto += listaProductos.get(i).getId();
		}
		//codigoProducto += (codigoProducto * numeroAleatorio);
		return codigoProducto;
	}

	@Override
	public TipoPersonalizado buscarProductoPersonalizadoPorCodigoGenerado(int id) {
		
		return repositorioPersonalizada.buscarProductoPersonalizadoPorCodigo(id);
	}

	@Override
	public Double sumarTotalDePorciones(List<Producto> listaProducto) {
		Double precioTotalPorciones=0.0;
		
		for(int i=0; i<listaProducto.size(); i++) {
			precioTotalPorciones+=listaProducto.get(i).getPrecioUnitario();
		}
		//productoPersonalizado.setPrecioTotal(precioTotalPorciones);
		return precioTotalPorciones;
	}

	

}
