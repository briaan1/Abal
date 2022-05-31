package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPersonalizarPizza;

@Service @Transactional
public class ServicioPersonalizarPizzaImpl implements ServicioPersonalizarPizza{
	
	private RepositorioPersonalizarPizza repositorioPersonalizarPizza;
	@Autowired
	public ServicioPersonalizarPizzaImpl(RepositorioPersonalizarPizza repositorioPersonalizarPizza) {
		this.repositorioPersonalizarPizza = repositorioPersonalizarPizza;
	}

	@Override
	public List<Producto> getListaDeProductos(String categoria) {
		List<Producto> listaDeProductos=repositorioPersonalizarPizza.listar(categoria);
		if(listaDeProductos!=null) {
			return listaDeProductos; 
		}else {
			return new ArrayList<Producto>();
		}
	}
	
}
