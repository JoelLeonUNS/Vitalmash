package com.sistemas.http;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentIntentDto {

	public enum Moneda {
		PEN, USD
	}
	
	private String descripcion;
	private int precio;
	private Moneda moneda;
	private String numeroTarjeta;
    private String fechaVencimiento;
    private String codigoCVV;
    private String titularTarjeta;
    private String codigoPostal;

}
