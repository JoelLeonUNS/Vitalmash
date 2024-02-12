package entidad;

import java.io.Serializable;

import lombok.Data;

@Data
public class ElaboracionDetalleID implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long productoElaborado;
	private Long elaboracion;
	

	public ElaboracionDetalleID() {
	}
	
	public ElaboracionDetalleID(Long productoElaborado, Long elaboracion) {
		super();
		this.productoElaborado = productoElaborado;
		this.elaboracion = elaboracion;
	}	
}
