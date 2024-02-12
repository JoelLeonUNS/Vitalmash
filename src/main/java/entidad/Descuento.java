package entidad;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity //anota la clase  como persistente
@Table(name="descuentos") //nombre de la tabla de la DB
@Data //loombok para generar los getters y setters automaticamente

public class Descuento {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY) //establece que la clave primaria sea tipo identidad
	private Long id_descuento;
	
	@Column(length = 8, nullable = false, unique = true)
	@NotBlank(message = "El código no puede estar en blanco")
	@Size(min = 8, max = 8, message = "El código debe de tener 8 caracteres")
	private String codigoDescuento;
	
	@Column(length = 50, nullable = false)
	@NotBlank(message = "La descripción no puede estar en blanco")
	@Size(min = 2, max = 50, message = "la descripción debe tener entre 2 y 50 caracteres")
	private String descripcion;
	
	@DecimalMin(value = "0.0", inclusive = true, message = "El porcentaje debe ser igual o mayor que 0.0")
	@DecimalMax(value = "1.0", inclusive = true, message = "El porcentaje debe ser igual o menor que 1.0")
	private Double porcentaje;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date fechaInicio;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date fechaFinal;

}
