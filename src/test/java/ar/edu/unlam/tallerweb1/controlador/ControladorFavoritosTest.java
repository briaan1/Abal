package ar.edu.unlam.tallerweb1.controlador;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.ControladorFavoritos;
import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.servicios.ServicioFavoritos;

public class ControladorFavoritosTest {

	private ServicioFavoritos servicioDeFavoritos = mock(ServicioFavoritos.class);
	//private ControladorFavoritos controladorDeFavoritos = new ControladorFavoritos(servicioDeFavoritos);
	
	/*@Test
	public void alPedirLaVistaDeFavoritosMeDevuelvaLaVista() {
		ModelAndView model = cuandoPidoLaVistaDeFavoritos();
		entoncesMeLlevaALaVista("favorito", model);
	}
	
	@Test
	public void alPedirLosFavoritosMeDevuelveLaListaCompleta() {
		dadoQueExistenFavoritosDelUsuario(3, 1);
		ModelAndView model = cuandoPidoLaListaDeFavoritos(1);
		entoncesMeMuestraLaListaCompletaDeFavoritos(model, 3);
	}
	
	private void entoncesMeMuestraLaListaCompletaDeFavoritos(ModelAndView model, int cantidadFavoritos) {
		assertThat(model.getModel().get("listaDeFavoritos")).asList().hasSize(cantidadFavoritos);
		
	}

	private ModelAndView cuandoPidoLaListaDeFavoritos(int idUsuario) {
		return controladorDeFavoritos.irAFavorito();
	}

	private void dadoQueExistenFavoritosDelUsuario(int cantidadFavoritos, int idUsuario) {
		List<Favorito> listaDeFavoritos=new ArrayList<Favorito>();
		for(int i=0;i<cantidadFavoritos;i++) {
			listaDeFavoritos.add(new Favorito());
		}
		when(servicioDeFavoritos.getListaDeFavoritos(idUsuario)).thenReturn(listaDeFavoritos);
	}

	private ModelAndView cuandoPidoLaVistaDeFavoritos() {
		return controladorDeFavoritos.irAFavorito();
	}

	private void entoncesMeLlevaALaVista(String vistaEsperada, ModelAndView model) {
		assertThat(model.getViewName()).isEqualTo(vistaEsperada);
	}*/

}
