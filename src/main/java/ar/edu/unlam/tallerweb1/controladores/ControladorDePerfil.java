package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorDePerfil {
    @RequestMapping(path = "/perfil")
    public ModelAndView irAPerfil() {
        // TODO Auto-generated method stub
        return new ModelAndView("perfil");
    }

}