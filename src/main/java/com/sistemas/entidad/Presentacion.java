package com.sistemas.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "presentaciones")
@Data
public class Presentacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
		
	@Column(length = 20, nullable = false)
	@NotBlank(message = "El nombre de la presentación no puede estar en blanco")
	@Size(min = 2, max = 20, message = "El nombre de la presentación debe tener entre 2 y 20 caracteres")
	private String nombre;
	
	@DecimalMin(value = "0.0", message = "El peso no puede ser menor que 0")
	@DecimalMax(value = "1000.0", message = "El peso no puede ser mayor que 1000")
	@NotNull(message = "El peso no puede estar en nulo")
	private Double peso;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="idMedida", referencedColumnName = "Id", nullable = false, foreignKey = @ForeignKey(name = "fk_medida_presentacion"))
	private Medida medida;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Medida getMedida() {
		return medida;
	}

	public void setMedida(Medida medida) {
		this.medida = medida;
	}
	
	
}
