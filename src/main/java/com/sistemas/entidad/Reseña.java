package com.sistemas.entidad;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table (name = "reseñas")
@Data
public class Reseña {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@Id
	@NotNull
	@ManyToOne
	@JoinColumn(referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_productos_reseñas"))
	private Producto producto;
	
	//@Id
	@NotNull
	@ManyToOne
	@JoinColumn(referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_clientes_reseñas"))
	private Cliente cliente;
	
	@Column(length = 255, nullable = false)
	@NotBlank(message = "El comentario no puede estar en blanco")
	@Size(min = 2, max = 255, message = "El comentario debe tener entre 2 y 255 caracteres")
	private String comentario;
	
	@DecimalMin(value = "0.0", message = "La calificación no puede ser menor que 0")
	@DecimalMax(value = "20.0", message = "La calificación no puede ser mayor que 5")
	@NotNull(message = "La calificación no puede estar en nulo")
	private double calificacion;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date fecha;
	
}
