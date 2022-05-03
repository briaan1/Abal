package ar.edu.unlam.tallerweb1.controlador;

import ar.edu.unlam.tallerweb1.controladores.ControladorCarrito;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import static org.assertj.core.api.Assertions.*;

public class ControladorCarritoTest {
    private ControladorCarrito controladorCarrito;
    @Test
    public void alPedirElCarritoMeMuestraElCarrito(){
        dadoQueExisteElCarrito();
        ModelAndView model=cuandoPidoElCarrito();
        entoncesMeLlevaALaVistaDelCarrito("carrito",model);
    }

    private void entoncesMeLlevaALaVistaDelCarrito(String vistaEsperada, ModelAndView model) {
        assertThat(model.getViewName()).isEqualTo(vistaEsperada);
    }

    private ModelAndView cuandoPidoElCarrito() {
        return controladorCarrito.irAlCarrito();
    }

    private void dadoQueExisteElCarrito() {
        controladorCarrito=new ControladorCarrito();
    }
}
