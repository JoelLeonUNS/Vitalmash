package com.sistemas.entidad;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "medidas")
@Data
public class Medida {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(length = 20, nullable = false)
	@NotBlank(message = "El nombre de la medida no puede estar en blanco")
	@Size(min = 2, max = 20, message = "El nombre de la medida debe tener entre 2 y 20 caracteres")
	private String nombre;
	
	@Column(length = 3, nullable = false)
	@NotBlank(message = "La sigla de la medida no puede estar en blanco")
	@Size(min = 1, max = 3, message = "La sigla de la medida debe tener entre 1 y 3 caracteres")
	private String sigla;	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "medida", cascade = CascadeType.ALL)
	private List<Presentacion> presentacion;
}
