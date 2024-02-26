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
	@PostMapping("/cliente")
	public String clienteIndex() {
		return "cliente/clienteIndex";
	}
	
	@GetMapping("/login")
	public String login() {
		return "publico/login";
	}
	
	@GetMapping("/pedido")
	public String pedido() {
		return "cliente/pedido/pedido";
	}
	
	@GetMapping("/producto")
	public String producto() {
		return "empleado/producto/productoIndex";
	}
}
