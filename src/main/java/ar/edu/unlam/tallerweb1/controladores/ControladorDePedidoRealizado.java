package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorDePedidoRealizado {

    @RequestMapping(path = "/pedido-realizado")
    public ModelAndView irAPedidoRealizado() {
        // TODO Auto-generated method stub
        return new ModelAndView("pedidoRealizado");
    }




}
