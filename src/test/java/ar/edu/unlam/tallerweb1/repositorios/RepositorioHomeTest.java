package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.*;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Comentario;


public class RepositorioHomeTest extends SpringTest {

	@Autowired
	RepositorioHome repositorioHome;
	
	@Test @Transactional @Rollback
	public void listarLosComentarios() {
		dadoQueExistenComentarios(3);
		List<Comentario> listaDeComentario = cuandoListoLosComentarios();
		entoncesMeDevuelveLaListaCompleta(listaDeComentario,3);
	}

	private void entoncesMeDevuelveLaListaCompleta(List<Comentario> listaDeComentario, int cantidadDeComentarios) {
		assertThat(listaDeComentario).hasSize(cantidadDeComentarios);
		
	}

	private List<Comentario> cuandoListoLosComentarios() {
	
		return repositorioHome.listar();
	}

	private void dadoQueExistenComentarios(int cantidadDeComentarios) {
		
		for(int i=0;i<cantidadDeComentarios;i++) {
			Comentario comentario = new Comentario();
			session().save(comentario);
		}
		
	}
}
