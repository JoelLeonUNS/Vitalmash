package com.sistemas.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sistemas.http.PaymentIntentDto;
import com.sistemas.http.PaymentIntentDto.Moneda;
import com.sistemas.servicio.PaymentService;
import com.sistemas.servicio.PedidoDetalleServiceImpl;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

@Controller
@RequestMapping("/stripe")
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	@Autowired private PedidoDetalleServiceImpl pedidoDetalleService;
	@Autowired private PedidoController pedidoController;
	
	@PostMapping("/paymentintent")
	private String payment(Model modelo, @RequestParam String precioTotalInput, @RequestParam String nombre, @RequestParam String tarjeta,
			@RequestParam String cvc, @RequestParam String cp,
			@RequestParam String vencimiento) throws StripeException {
		
		modelo.addAttribute("listaPedidos", pedidoDetalleService.listarTodos());
		
				
		PaymentIntentDto paymentIntentDto = new PaymentIntentDto();
		paymentIntentDto.setDescripcion("Producto");
		paymentIntentDto.setPrecio(Integer.parseInt(precioTotalInput.replaceAll("\\..*$", "")));
		paymentIntentDto.setMoneda(Moneda.PEN);
		paymentIntentDto.setTitularTarjeta(nombre);
		paymentIntentDto.setNumeroTarjeta(tarjeta);
		paymentIntentDto.setCodigoCVV(cvc);
		paymentIntentDto.setCodigoPostal(cp);
		paymentIntentDto.setFechaVencimiento(vencimiento);
				
		PaymentIntent paymentIntent = paymentService.paymentIntent(paymentIntentDto);
		paymentIntent = paymentService.confirmar(paymentIntent.getId());
		
		pedidoController.almacenarPedido();

		return "cliente/pedido/pedido";
	}
	
	@PostMapping("/cancelar")
	public String cancel(Model modelo) {
		modelo.addAttribute("listaPedidos", pedidoDetalleService.listarTodos());
		return "cliente/pedido/pedido";
	}
}
