package com.sistemas.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

	@GetMapping("/login")
	public String login() {
		return "publico/login";
	}

}
