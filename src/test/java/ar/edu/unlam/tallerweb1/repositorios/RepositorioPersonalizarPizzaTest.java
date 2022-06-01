package ar.edu.unlam.tallerweb1.repositorios;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.Producto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import javax.transaction.Transactional;

public class RepositorioPersonalizarPizzaTest extends SpringTest{
	@Autowired
	private RepositorioPersonalizarPizza repositorioPersonalizarPizza;
	
	@Test @Transactional @Rollback
	public void listarLasPizzas() {
		dadoQueExisteLaListaDePizzas("pizza", 4);
		List<Producto> listaDeProductos=cuandoListoLasPizzas("pizza");
		entoncesMeDevuelveLaListaCompleta(listaDeProductos, 4);
	}

	private void entoncesMeDevuelveLaListaCompleta(List<Producto> listaDeProductos, int cantidadEsperada) {
		assertThat(listaDeProductos).hasSize(cantidadEsperada);
	}

	private List<Producto> cuandoListoLasPizzas(String nombreCategoria) {
		return repositorioPersonalizarPizza.listar(nombreCategoria);
	}

	private void dadoQueExisteLaListaDePizzas(String nombreCategoria, int cantidadEsperada) {
		Categoria categoria=new Categoria();
		categoria.setNombre(nombreCategoria);
		
		for(int i=0;i<cantidadEsperada;i++) {
			Producto producto=new Producto();
			producto.setCategoria(categoria);
			session().save(producto);
		}
	}
	
	
}
