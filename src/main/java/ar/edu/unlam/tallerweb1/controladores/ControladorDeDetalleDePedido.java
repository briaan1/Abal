package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller

public class ControladorDeDetalleDePedido {
    @RequestMapping(path = "/detalle-de-pedido")
    public ModelAndView irADetalleDePedido() {
        // TODO Auto-generated method stub
        return new ModelAndView("detalleDePedido");
    }


}
