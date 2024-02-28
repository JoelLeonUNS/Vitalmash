package com.sistemas.servicio;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sistemas.http.PaymentIntentDto;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;


@Service
public class PaymentService {

	@Value("${stripe.key.secret}")
	String secretKey;
		
	public PaymentIntent paymentIntent(PaymentIntentDto paymentIntentDto) throws StripeException {
		Stripe.apiKey = secretKey;
		Map<String, Object> params = new HashMap<>();
		params.put("amount", paymentIntentDto.getPrecio()*100);
		params.put("currency", paymentIntentDto.getMoneda().name());
		params.put("description", paymentIntentDto.getDescripcion());
		//params.put("confirmation_method", "automatic");
		params.put("automatic_payment_methods", new HashMap<String, Object>() {{
		    put("enabled", true);
		    put("allow_redirects", "never");
		}});
		params.put("payment_method", "pm_card_visa");
		
		return PaymentIntent.create(params); 
	}
	
	public PaymentIntent confirmar(String id) throws StripeException {
		Stripe.apiKey = secretKey;
		PaymentIntent paymentIntent = PaymentIntent.retrieve(id);
		Map<String, Object> params = new HashMap<>();
		params.put("payment_method", "pm_card_visa");
		paymentIntent.confirm(params);
		return paymentIntent;
	}
	
	public PaymentIntent cancelar(String id) throws StripeException {
		Stripe.apiKey = secretKey;
		PaymentIntent paymentIntent = PaymentIntent.retrieve(id);
		paymentIntent.cancel();
		return paymentIntent;
	}
	
}
