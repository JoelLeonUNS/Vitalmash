package com.sistemas.controlador;

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
import com.sistemas.entidad.ProductoElaborado;
import com.sistemas.servicio.ElaboracionDetalleServiceImpl;
import com.sistemas.servicio.ElaboracionServiceImpl;
import com.sistemas.servicio.ProductoElaboradoServiceImpl;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/producto")
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
	
	
	@GetMapping("/actualizar-stock") //Dirige al formulario vacio
	public String actualizarStock(Model modelo) {
		modelo.addAttribute("productoElaborado", new ProductoElaborado());
		modelo.addAttribute("listaProductos", productoElaboradoService.listarTodos());
		return "Empleado/elaboracion/actualizar-stock";
	}
	
	@PostMapping("/guardar")
	public String guardar(@RequestParam Long id, 
			@RequestParam int cantidad,
			@RequestParam ProductoElaborado producto,
			Model modelo) {
		
		//productoElaboradoService.buscar(producto.getId());
		
		return "Empleado/elaboracion/elaboracionIndex";
	}
	
}
