package com.sistemas.entidad;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table (name = "usuarios")
@Data
public class Usuario {
	@Id @GeneratedValue (strategy = GenerationType. IDENTITY) 
	private Long id;
	
	@Column(nullable = false)
	@NotBlank(message = "El nombre debe tener al menos una letra") 
	private String nombreUsuario;
	
	@Column(nullable = false)
	@NotBlank(message = "El password no debe estar en blanco") 
	private String clave;	
	
	@Column(nullable = false)
	@NotBlank(message = "El rol no debe estar en blanco") 
	private String rol;	
	
	
}
