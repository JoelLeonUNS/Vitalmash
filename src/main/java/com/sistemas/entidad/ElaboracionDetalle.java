package com.sistemas.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@IdClass(ElaboracionDetalleID.class)
@Table(name = "elaboracionesDetalle")
@Data
public class ElaboracionDetalle {
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName = "id",
	nullable = false,
	foreignKey = @ForeignKey(name = "id_productosElaborado_elaboracionesDetalle"))
	private ProductoElaborado productoElaborado;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName = "id",
	nullable = false,
	foreignKey = @ForeignKey(name = "id_elaboraciones_elaboracionesDetalle"))
	private Elaboracion elaboracion;
	
	private int cantidad_elaborada;
}
