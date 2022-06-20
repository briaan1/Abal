package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCategoriaPizza;

@Service @Transactional
public class ServicioCategoriaPizzaImpl implements ServicioCategoriaPizza {
	private RepositorioCategoriaPizza repositorioCategoriaPizza;
	
	@Autowired
	public ServicioCategoriaPizzaImpl(RepositorioCategoriaPizza repositorioCategoriaPizza) {
		this.repositorioCategoriaPizza=repositorioCategoriaPizza;
	}

	@Override
	public List<Producto> getListaDeProductos(String categoria) {
		List<Producto> listaDeProductos=repositorioCategoriaPizza.listar(categoria);
		if(listaDeProductos.size()==0) {
			return new ArrayList<Producto>(); 
		}else {
			return listaDeProductos;
		}
	}

	@Override
	public Producto validarExistenciaProductoPor(int idProducto) {
		return repositorioCategoriaPizza.validarExistenciaProductoPor(idProducto);
	}
	
}
