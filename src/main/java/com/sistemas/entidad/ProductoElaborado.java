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
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "productosElaborados")
@Data
@NoArgsConstructor
public class ProductoElaborado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "El producto no puede ser nulo")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_productos_productosElaborado"))
    private Producto producto;
    
    @NotNull(message = "La presentación no puede ser nula")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_presentacion", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_presentaciones_productosElaborado"))
    private Presentacion presentacion;
    
    @NotNull(message = "El precio no puede estar en nulo")
    @DecimalMin(value = "0.0", message = "El precio no puede ser menor que 0")
    @Column(nullable = false)
    private Double precio;
    
    @NotNull(message = "El stock no puede estar en nulo")
    @DecimalMin(value = "0", message = "El stock no puede ser menor que 0")
    @Column(nullable = false)
    private Integer stock;

}



    

