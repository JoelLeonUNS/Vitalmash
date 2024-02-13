package com.sistemas.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "clientes")
@Data

public class Cliente {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 35, nullable = false)
	@NotBlank(message = "Ell nombre no puede estar en blanco")
	@Size(min = 2, max = 35, message = "El nombre debe tener entre 2 y 35 caracteres")
	 private String nombre;
	
	@Column(length = 35, nullable = false)
	@NotBlank(message = "El apellido no puede estar en blanco")
	@Size(min = 2, max = 35, message = "El apellido debe tener entre 2 y 35 caracteres")
	private String apellido;
	
	@Column (length = 80)	
	private String direccion;
	
	@Column(length = 9, nullable = true, unique = true) 
	@NotBlank(message = "El telefono no puede estar en blanco") @Size(min = 9, max = 9, message = "El telefono debe tener 9 caracteres") 
	private String telefono;
	
    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", nullable = false)
    private Usuario usuario;	
}
