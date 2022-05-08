package ar.edu.unlam.tallerweb1.controlador;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.ControladorHome;

import static org.assertj.core.api.Assertions.*;

public class ControladorHomeTest {
private ControladorHome controladorHome;
	
	@Test
	public void alPedirElHomeMeMuestraElHome() {		
		dadoQueExisteHome();
		ModelAndView model = cuandoPidoElHome();
		entoncesMeLlevaALaVistaHome("home",model);
	}

	private void entoncesMeLlevaALaVistaHome(String vistaEsperada, ModelAndView model) {
		assertThat(model.getViewName()).isEqualTo(vistaEsperada);	
	}

	private ModelAndView cuandoPidoElHome() {
		return controladorHome.irAlHome();
	}

	private void dadoQueExisteHome() {
		controladorHome= new ControladorHome();
		
	}
}
