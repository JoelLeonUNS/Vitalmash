package entidad;

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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "productos")
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "La categoría no puede ser nula")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_categorias_productos"))
    private Categoria categoria;
    
    @NotBlank(message = "El nombre no puede estar en blanco")
    @Size(min = 1, max = 50, message = "El nombre debe tener entre 1 y 50 caracteres")
    @Column(length = 50, nullable = false)
    private String nombre;
    
    @NotBlank(message = "La descripción no puede estar en blanco")
    @Size(min = 1, max = 150, message = "La descripción debe tener un máximo de 150 caracteres")
    @Column(length = 150, nullable = false)
    private String descripcion;
}







    

