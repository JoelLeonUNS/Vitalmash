package com.sistemas.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sistemas.entidad.Pedido;
import com.sistemas.servicio.PedidoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired private PedidoService pedidoService;
	
	@GetMapping({"/", ""})
	public String indice(Model model) {
		model.addAttribute("listaPedido", pedidoService.listarTodos());
		return "cliente/pedido/pedido";
	}
	@GetMapping("/nuevo")
	public String pedidoNuevoForm(Model model) {
		model.addAttribute("pedido", new Pedido());
		return "cliente/pedido/pedidoForm";
	}
	@PostMapping("/guardar")
	public String pedidoNuevo(@Valid @ModelAttribute("pedido") Pedido pedido, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "cliente/pedido/pedidoForm";
		}
		
		if(pedido.getId()==null) {
			pedidoService.agregar(pedido);
		}else {
			pedidoService.actualizar(pedido);
		}
		return "redirect:/cliente/pedido/pedido";
	}
	@GetMapping("/editar/{id}")
	public String pedidoEditarForm(Model model, @PathVariable("id") Long id) {
		Pedido buscado = pedidoService.buscar(id);
		model.addAttribute("pedido", buscado!=null ? buscado : new Pedido());
		return "cliente/pedido/pedidoForm";
	}
	@GetMapping("/eliminar/{id}")
	public String pedidoEliminar(Model model, @PathVariable("id") Long id) {
		pedidoService.eliminar(id);
		return "redirect:/cliente/pedido/pedido";
	}
}
