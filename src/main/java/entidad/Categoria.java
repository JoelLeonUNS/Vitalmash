package entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table (name = "categorias")
@Data
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 45, nullable = false)
	@NotBlank(message = "El nombre no puede estar en blanco")
	@Size(min = 2, max = 45, message = "El nombre debe tener entre 2 y 45 caracteres")
	private String nombre;
	
	@Column(length = 75, nullable = false)
	@NotBlank(message = "La descripción no puede estar en blanco")
	@Size(min = 15, max = 35, message = "La descripción debe tener entre 15 y 75 caracteres")
	private String descripcion;
}
