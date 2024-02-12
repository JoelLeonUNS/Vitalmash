package entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "pedidosDetalle")
@Data

public class PedidoDetalle {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long id_numero;
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@ManyToOne
    @JoinColumn(name = "id_pedido", referencedColumnName = "id", 
    nullable = false, foreignKey = @ForeignKey(name = "fk_pedidos_pedidosDetalle"))
	private Pedido pedido;
	
	@ManyToOne
    @JoinColumn(name = "id_productoElaborado", referencedColumnName = "id", 
    nullable = false, foreignKey = @ForeignKey(name = "fk_productosElaborado_pedidosDetalle"))
	private ProductoElaborado idProductoElaborado;
	
	@Min(value = 1)
	@NotNull (message = "La cantidad deben tener un valor")
	private Integer cantidad;
}

