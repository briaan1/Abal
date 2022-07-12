package ar.edu.unlam.tallerweb1.controlador;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.ControladorDeHistorialDePedidos;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioPedido;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

public class ControladorPedidoTest {

	 private ControladorDeHistorialDePedidos controladorHistorialPedido;
	 private ServicioPedido servicioPedido = mock(ServicioPedido.class);
	 private ServicioUsuario servicioUsuario = mock(ServicioUsuario.class);
	 
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
	    	when(servicioUsuario.getUnicoUsuario()).thenReturn(new Usuario());
	    	when(servicioPedido.getListaDePedidos(new Usuario())).thenReturn(new ArrayList<Pedido>());
	    	controladorHistorialPedido = new ControladorDeHistorialDePedidos(servicioPedido, servicioUsuario);
	    }

}
