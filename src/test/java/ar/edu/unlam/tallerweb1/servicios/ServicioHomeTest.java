package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioLogin;
import org.junit.Test;
import ar.edu.unlam.tallerweb1.modelo.Comentario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioHome;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.*;

public class ServicioHomeTest {
private RepositorioHome repositorioHome=mock(RepositorioHome.class);
private RepositorioLogin repositorioLogin=mock(RepositorioLogin.class);
	private ServicioHome servicioHome = new ServicioHomeImpl(repositorioHome);

	@Test
	public void devolverUnaListaVaciaSiNoHayComentarios() {
		dadoQueNoHayComentarios();
		List<Comentario> listaDeComentarios= cuandoPidoLaListaDeComentarios();
		entoncesLaListaEstaVacia(listaDeComentarios,0);
	}

	private void entoncesLaListaEstaVacia(List<Comentario> listaDeComentarios, int cantidadEsperada) {
		assertThat(listaDeComentarios).hasSize(cantidadEsperada);
		
	}

	private List<Comentario> cuandoPidoLaListaDeComentarios() {
		
		return servicioHome.getListaDeComentarios();
	}

	private void dadoQueNoHayComentarios() {
		when(repositorioHome.listar()).thenReturn(new ArrayList<Comentario>());
		
	}
}
