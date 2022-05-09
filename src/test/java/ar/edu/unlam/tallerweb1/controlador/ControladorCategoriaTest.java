package ar.edu.unlam.tallerweb1.controlador;

import ar.edu.unlam.tallerweb1.controladores.ControladorCarrito;
import ar.edu.unlam.tallerweb1.controladores.ControladorCategoria;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import static org.assertj.core.api.Assertions.*;

public class ControladorCategoriaTest {
    private ControladorCategoria controladorCategoria;
    @Test
    public void alPedirLaCategoriaMeMuestraLaCategoria(){
        dadoQueExisteLaCategoria();
        ModelAndView model=cuandoPidoLaCategoria();
        entoncesMeLlevaALaVistaCategoria("categoria",model);
    }

    private void entoncesMeLlevaALaVistaCategoria(String vistaEsperada, ModelAndView model) {
        assertThat(model.getViewName()).isEqualTo(vistaEsperada);
    }

    private ModelAndView cuandoPidoLaCategoria() {
        return controladorCategoria.irACategoria();
    }

    private void dadoQueExisteLaCategoria() {
        controladorCategoria=new ControladorCategoria();
    }
}
