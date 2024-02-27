package com.sistemas.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sistemas.servicio.PaymentService;

@Controller
@RequestMapping("/stripe")
public class PaymentController {

	@Autowired
	PaymentService paymentService;
}
