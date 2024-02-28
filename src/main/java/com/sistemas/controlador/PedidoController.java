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
import org.springframework.web.bind.annotation.RequestParam;

import com.sistemas.entidad.Pedido;
import com.sistemas.entidad.PedidoDetalle;
import com.sistemas.entidad.ProductoElaborado;
import com.sistemas.servicio.ClienteServiceImpl;
import com.sistemas.servicio.PedidoDetalleServiceImpl;
import com.sistemas.servicio.PedidoServiceImpl;
import com.sistemas.servicio.ProductoElaboradoServiceImpl;

@Controller
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired private PedidoServiceImpl pedidoService;
	@Autowired private PedidoDetalleServiceImpl pedidoDetalleService;
	@Autowired private ProductoElaboradoServiceImpl productoElaboradoService;
	@Autowired private ClienteServiceImpl clienteService;
	private Pedido pedido;
	
	public PedidoController() {
		this.pedido = new Pedido();
	}
	
	@ModelAttribute("pedido")
	public Pedido getPedido() {
		return pedido;
	}
	
	@GetMapping({"/", ""})
	public String indice(Model model) {
		model.addAttribute("listaPedidos", pedidoDetalleService.listarTodos());
		return "cliente/pedido/pedido";
	}
	@GetMapping("/nuevo")
	public String pedidoNuevoForm(Model model) {
		pedido.setClientes(clienteService.buscar((long) 1));
		pedido.setPagado(false);
		//pedido = pedidoService.agregar(pedido);
		model.addAttribute("producto", new ProductoElaborado());
		model.addAttribute("listaProductos", productoElaboradoService.listarTodos());
		return "cliente/pedido/pedidoForm";
	}
	@PostMapping("/guardar")
	public String pedidoNuevo(@RequestParam("producto.id") Long id, 
			@RequestParam("cantidad") Integer cantidad,
			Model modelo) {
		
		PedidoDetalle pedidoDetalle = new PedidoDetalle();
		pedidoDetalle.setPedido(pedido);
		pedidoDetalle.setIdProductoElaborado(productoElaboradoService.buscar(id));
		pedidoDetalle.setCantidad(cantidad);
		
		//pedidoDetalleService.agregar(pedidoDetalle);
		modelo.addAttribute("listaPedidos", pedidoDetalleService.listarTodos());
		modelo.addAttribute("producto", pedidoDetalle.getIdProductoElaborado());
		modelo.addAttribute("cantidad", pedidoDetalle.getCantidad());
		
		
		return "cliente/pedido/pago";
	}
	
	
	@PostMapping("/verificar")
	public String procesarPago(Model model) {
		model.addAttribute("listaPedidos", pedidoDetalleService.listarTodos());
		return "cliente/pedido/pedido";
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
