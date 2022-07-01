package ar.edu.unlam.tallerweb1.repositorios;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.Producto;

public class RepositorioCategoriaBebidaTest extends SpringTest{

	@Autowired
	RepositorioProducto repositorioProducto;
	
	@Test @Transactional @Rollback
	public void listarLosProductosDeLaCategoriaBebida() {
		dadoQueExistenProductosDeCategoriaBebida("bebida",10);
		List<Producto> listaDeProductos=cuandoListoLosProductosDeCategoriaBebida("bebida");
		entoncesMeDevuelveLaListaCompleta(listaDeProductos, 10);
	}

	@Test @Transactional @Rollback
	public void queMeDevuelvaUnaListaVaciaSiNoHayBebidasEnEsaCategoria() {
		dadoQueNoExistenBebidas("bebida",0);
		List<Producto> listaDeProductos=cuandoListoLosProductosDeCategoriaBebida("bebida");
		entoncesMeDevuelveLaLista(listaDeProductos,0 );
	}

	private void entoncesMeDevuelveLaLista(List<Producto> listaDeProductos, int cantidadEsperada) {
	  assertThat(listaDeProductos).hasSize(cantidadEsperada);
	}

	private void dadoQueNoExistenBebidas(String nombre, int cantidadDeProductos) {
		Categoria categoria=new Categoria();
		categoria.setNombre(nombre);

		for(int i=0;i<cantidadDeProductos;i++) {
			Producto producto=new Producto();
			producto.setCategoria(categoria);
			session().save(producto);
		}
	}

	private void entoncesMeDevuelveLaListaCompleta(List<Producto> lista, int cantidadEsperada) {
		assertThat(lista).hasSize(cantidadEsperada);
	}

	private List<Producto> cuandoListoLosProductosDeCategoriaBebida(String categoria) {
		return repositorioProducto.listar(categoria);
	}

	private void dadoQueExistenProductosDeCategoriaBebida(String nombre, int cantidadDeProductos) {
		Categoria categoria=new Categoria();
		categoria.setNombre(nombre);
		
		for(int i=0;i<cantidadDeProductos;i++) {
			Producto producto=new Producto();
			producto.setCategoria(categoria);
			session().save(producto);
		}
	}

}
