package com.sistemas.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/pedido")
	public String pedido() {
		return "cliente/pedido/pedido";
	}
	
	@GetMapping("/producto")
	public String producto() {
		return "Empleado/producto/productoIndex";
	}
}
