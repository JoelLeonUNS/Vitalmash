package com.sistemas.controlador;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sistemas.entidad.Elaboracion;
import com.sistemas.entidad.ElaboracionDetalle;
import com.sistemas.entidad.ElaboracionDetalleID;
import com.sistemas.servicio.ElaboracionDetalleServiceImpl;
import com.sistemas.servicio.ElaboracionServiceImpl;
import com.sistemas.servicio.ProductoElaboradoServiceImpl;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/elaboracion")
public class ElaboracionController {
	
	@Autowired
	private ProductoElaboradoServiceImpl productoElaboradoService;
	@Autowired
	private ElaboracionServiceImpl elaboracionService;
	@Autowired
	private ElaboracionDetalleServiceImpl elaboracionDetalleService;
	
	@ModelAttribute("elaboracionGeneral")
    public Elaboracion crearElaboracion() {
		Elaboracion elaboracion = new Elaboracion();
		elaboracionService.agregar(elaboracion);
        return elaboracion;
    }

	@GetMapping("/index") //Dirige a la tabla
	public String verIndex(Model modelo) {
		modelo.addAttribute("listaelaboraciones", elaboracionDetalleService.listarTodos());
		return "Empleado/elaboracion/elaboracionIndex";
	}
	
	
	@GetMapping("/nuevo") //Dirige al formulario vacio
	public String agregarElaboracion(Model modelo) {
		modelo.addAttribute("elaboracion", new ElaboracionDetalle());
		modelo.addAttribute("listaProductos", productoElaboradoService.listarTodos());
		return "Empleado/elaboracion/elaboracionForm";
	}
	
	@PostMapping("/guardar")
	public String guardarElaboracion(@RequestParam Long id, @RequestParam int cantidad,
			@Valid ElaboracionDetalle elaboracionDetalle, BindingResult result, Model modelo) {
		
		ElaboracionDetalleID elaDetalleID = new ElaboracionDetalleID();
		ElaboracionDetalle elabDetalle = new ElaboracionDetalle();
		
		
		
		
		if(result.hasErrors()) {
			return "Empleado/elaboracion/elaboracionForm";
		}
		
		return "Empleado/elaboracion/elaboracionIndex";
	}
	
}
