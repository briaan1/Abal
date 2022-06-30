package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioProducto;

@Service @Transactional
public class ServicioProductoImpl implements ServicioProducto {
	private RepositorioProducto repositorioProducto;
	
	@Autowired
	public ServicioProductoImpl(RepositorioProducto repositorioProducto) {
		this.repositorioProducto=repositorioProducto;
	}

	@Override
	public List<Producto> getListaDeProductos(String categoria) {
		List<Producto> listaDeProductos=repositorioProducto.listar(categoria);
		if(listaDeProductos.size()==0) {
			return new ArrayList<Producto>(); 
		}else {
			return listaDeProductos;
		}
	}

	@Override
	public Producto validarExistenciaProductoPor(int idProducto) {
		return repositorioProducto.validarExistenciaProductoPor(idProducto);
	}
	
}