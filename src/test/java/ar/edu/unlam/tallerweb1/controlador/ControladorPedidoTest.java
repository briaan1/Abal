package ar.edu.unlam.tallerweb1.controlador;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.ControladorCategoria;
import ar.edu.unlam.tallerweb1.controladores.ControladorDeHistorialDePedidos;

public class ControladorPedidoTest {

	 private ControladorDeHistorialDePedidos controladorHistorialPedido;
	 
	    @Test
	    public void alPedirLaCategoriaMeMuestraLaCategoria(){
	        dadoQueExisteLaVistaHistorialDePedidos();
	        ModelAndView model=cuandoPidoLaCategoria();
	        entoncesMeLlevaALaVistaDeHistorialDePedidos("historialDePedidos",model);
	    }

	    private void entoncesMeLlevaALaVistaDeHistorialDePedidos(String vistaEsperada, ModelAndView model) {
	        assertThat(model.getViewName()).isEqualTo(vistaEsperada);
	    }

	    private ModelAndView cuandoPidoLaCategoria() {
	        return controladorHistorialPedido.irAHistorialDePedidos();
	    }

	    private void dadoQueExisteLaVistaHistorialDePedidos() {
	    	controladorHistorialPedido = new ControladorDeHistorialDePedidos();
	    }

}
