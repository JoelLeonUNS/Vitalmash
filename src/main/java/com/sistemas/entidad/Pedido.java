package com.sistemas.entidad;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.ForeignKey;

@Entity
@Table(name = "pedidos")
@Data

public class Pedido {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id", 
    nullable = false, foreignKey = @ForeignKey(name = "fk_clientes_pedidos"))
	private Cliente clientes; 
	
	@ManyToOne
	@JoinColumn(name = "id_descuento", referencedColumnName = "id", 
	nullable = false, foreignKey = @ForeignKey(name = "fk_clientes_descuentos"))
	private Descuento descuento;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fecha;
	
	@Column(nullable = false)
	private Boolean pagado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getClientes() {
		return clientes;
	}

	public void setClientes(Cliente clientes) {
		this.clientes = clientes;
	}

	public Descuento getDescuento() {
		return descuento;
	}

	public void setDescuento(Descuento descuento) {
		this.descuento = descuento;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Boolean getPagado() {
		return pagado;
	}

	public void setPagado(Boolean pagado) {
		this.pagado = pagado;
	}
	
	
}


