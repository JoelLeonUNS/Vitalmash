package com.sistemas.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/index")
	public String index() {
		return "index";
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
