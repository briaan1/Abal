package ar.edu.unlam.tallerweb1.repositorios;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import static org.assertj.core.api.Assertions.*;

public class RepositorioCategoriaPizzaTest extends SpringTest{
	@Autowired
	RepositorioProducto repositorioProducto;
	
	@Test @Transactional @Rollback
	public void listarLosProductosDeLaCategoriaPizza() {
		dadoQueExistenProductosDeCategoriaPizza("pizza",10);
		List<Producto> listaDeProductos=cuandoListoLosProductosDeCategoriaPizza("pizza");
		entoncesMeDevuelveLaListaCompleta(listaDeProductos, 10);
	}

	
	@Test @Transactional @Rollback
	public void queMeDeBuelvaCeroSiNOhAYpIZZA() {
		dadoQueNoExistenPizas("pizza",0);
		List<Producto> listaDeProductos=cuandoListoLosProductosDeCategoriaPizza("pizza");
		entoncesMeDevuelveLaLista(listaDeProductos,0 );
	}
	

	private void entoncesMeDevuelveLaLista(List<Producto> listaDeProductos, int i) {
	  assertThat(listaDeProductos).hasSize(i);
	}


	private void dadoQueNoExistenPizas(String string, int i) {
		Categoria categoria=new Categoria();
		categoria.setNombre(string);
		
		
	}


	private void entoncesMeDevuelveLaListaCompleta(List<Producto> lista, int cantidadEsperada) {
		assertThat(lista).hasSize(cantidadEsperada);
	}

	private List<Producto> cuandoListoLosProductosDeCategoriaPizza(String categoria) {
		return repositorioProducto.listar(categoria);
	}

	private void dadoQueExistenProductosDeCategoriaPizza(String nombre, int cantidadDeProductos) {
		Categoria categoria=new Categoria();
		categoria.setNombre(nombre);
		
		for(int i=0;i<cantidadDeProductos;i++) {
			Producto producto=new Producto();
			producto.setCategoria(categoria);
			session().save(producto);
		}
	}
	
	
}
