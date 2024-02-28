package com.sistemas.servicio;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.sistemas.entidad.Pedido;
import com.sistemas.entidad.PedidoDetalle;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Service;

@Service
public class GeneradorPDFServicio {

	public void generar(Pedido pedido, PedidoDetalle pedidoDetalle){
		try {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		// Crear un nuevo documento
	      Document document = new Document();
	      PdfWriter.getInstance(document, new FileOutputStream("pedido.pdf"));
	      document.open();            
	      // Agregar logo de Vitalmash
	      Image logo = Image.getInstance("logo.png");
	      logo.scaleToFit(100, 100);
	      logo.setAlignment(Element.ALIGN_LEFT);
	      document.add(logo);      
	      // Agregar título
	      Font fontTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 22);
	      Paragraph title = new Paragraph("Pedido - " + formatter.format(pedido.getFecha()), fontTitulo); //
	      title.setSpacingAfter(30);
	      document.add(title);      
	      // Agregar detalles del cliente 
	      Font fontInfo = FontFactory.getFont(FontFactory.HELVETICA, 12);      
	      Paragraph cliente = new Paragraph();
	      cliente.add("Cliente: " + pedido.getClientes().getNombre() + "\n");
	      cliente.add("Fecha del pedido: " + pedido.getFecha() + "\n\n");
	      document.add(cliente);  
	      // Agregar detalles del producto
	      Paragraph producto = new Paragraph(); 
	      producto.add("Producto \n\n");    
	      producto.add("Nombre: " + pedidoDetalle.getIdProductoElaborado().getProducto().getNombre() + "\n");
	      producto.add("Descripción: " + pedidoDetalle.getIdProductoElaborado().getProducto().getDescripcion() + "\n"); 
	      producto.add("Cantidad: " + pedidoDetalle.getCantidad() + "\n");
	      producto.add("Total: " + (pedidoDetalle.getCantidad()*pedidoDetalle.getIdProductoElaborado().getPrecio()) + "\n");
	      document.add(producto);     
	      // Cerrar el documento  
	      document.close(); 	  
		} catch (Exception e) {
		      e.printStackTrace();
		    }
		}
	}