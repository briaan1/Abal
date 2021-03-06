package ar.edu.unlam.tallerweb1.controlador;

import ar.edu.unlam.tallerweb1.controladores.ControladorCategoriaPizza;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCarrito;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.ControladorHome;
import ar.edu.unlam.tallerweb1.modelo.Comentario;
import ar.edu.unlam.tallerweb1.servicios.ServicioHome;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class ControladorHomeTest {
	private ServicioHome servicioHome = mock(ServicioHome.class);
	private ServicioCarrito servicioCarrito=mock(ServicioCarrito.class);
	private ServicioUsuario servicioUsuario=mock(ServicioUsuario.class);
	private ControladorHome controladorHome=new ControladorHome(servicioHome,servicioUsuario,servicioCarrito);


	@Test
	public void alPedirElHomeMeMuestraElHome() {
		ModelAndView model = cuandoPidoElHome();
		entoncesMeLlevaALaVistaHome("home",model);
	}



	//COMENTARIOS
	@Test
	public void alAbrirHomeQueMeMuestreLaListaDeComentariosCompleta() {
		dadoQueExistenComentarios(3);
		ModelAndView model = cuandoPidoLaListaDeComentarios();
		entoncesMeMuestraLaListaCompleta(model, 3);

	}
	

	private void entoncesMeMuestraLaListaCompleta(ModelAndView model, int cantidadEsperada) {
		assertThat(model.getModel().get("listaDeComentarios")).asList().hasSize(cantidadEsperada);

	}

	private ModelAndView  cuandoPidoLaListaDeComentarios() {
		when(servicioUsuario.getUnicoUsuario()).thenReturn(new Usuario());

		return controladorHome.irAlHome();
	}



	private void dadoQueExistenComentarios(int cantidadDeComentarios) {

		List<Comentario> listaDeComentario = new ArrayList<Comentario>();
		for(int i=0;i<cantidadDeComentarios;i++) {
			listaDeComentario.add(new Comentario());
		}

		when(servicioHome.getListaDeComentarios()).thenReturn(listaDeComentario);

	}

	private void entoncesMeLlevaALaVistaHome(String vistaEsperada, ModelAndView model) {
		assertThat(model.getViewName()).isEqualTo(vistaEsperada);
	}

	private ModelAndView cuandoPidoElHome() {
		when(servicioUsuario.getUnicoUsuario()).thenReturn(new Usuario());
		return controladorHome.irAlHome();
	}


}