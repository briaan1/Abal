package ar.edu.unlam.tallerweb1.servicios;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;
import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCategoriaPizza;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioFavorito;

import static org.assertj.core.api.Assertions.*;

public class ServicioFavoritoTest {
	private RepositorioFavorito repositorioFavorito=mock(RepositorioFavorito.class);
	private ServicioFavoritos servicioFavoritos = new ServicioFavoritosImpl(repositorioFavorito);



	@Test
	public void alVerificarQueNoExisteUnFavoritoDeUnUsuarioLoAgrega() {
		dadoQueElProductoNoEstaAgregadoAFavorito(5);
		Boolean seAgrego= cuandoLoQuieroAgregar(5);
		entoncesLoAgregoAListaDeFavoritos(seAgrego);
	}

    private void entoncesLoAgregoAListaDeFavoritos( Boolean seAgrego) {
	  assertThat(seAgrego).isTrue() ;
	}

    private Boolean cuandoLoQuieroAgregar( int idProducto) {
	   return   servicioFavoritos.agregarAFavorito( idProducto);
    }

    private void dadoQueElProductoNoEstaAgregadoAFavorito( int idProducto) {
        when(repositorioFavorito.buscarFavorito(idProducto)).thenReturn(null);
    }



/*@Test
    public void queNosePuedaAgregarUnProductoExistenteAFavorito(){
    dadoUnFavoritoExistente(5);
    cuandoLoQuieroAgregar(5);
    EnTo
}*/
}
