package com.sistemas.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ElaboracionController {

	@GetMapping("/elaboracion/index")
	public String verIndex() {
		return "Empleado/elaboracion/elaboracionIndex";
	}
	
	@GetMapping("/elaboracion/form")
	public String verForm() {
		return "Empleado/elaboracion/elaboracionForm";
	}
	
	@GetMapping("/elaboracion/nuevo")
	public String agregarElaboracion() {
		return "Empleado/elaboracion/elaboracionForm";
	}
}
