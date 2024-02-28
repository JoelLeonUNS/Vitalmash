package com.sistemas.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/cliente")
    public String clienteIndex() {
        return "cliente/clienteIndex";
    }
	
	@GetMapping("/empleado")
    public String empleadoIndex() {
        return "empleado/empleadoIndex";
    }
}
