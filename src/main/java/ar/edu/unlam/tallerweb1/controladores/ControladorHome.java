package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class ControladorHome {

		@RequestMapping(path = "/home")
		public ModelAndView irAlHome() {
			// TODO Auto-generated method stub
			return new ModelAndView("home");
		}
	
	
}
