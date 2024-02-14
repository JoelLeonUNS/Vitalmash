package com.sistemas.controlador;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
 
import com.sistemas.entidad.Categoria;
import com.sistemas.entidad.Presentacion;
import com.sistemas.entidad.Producto;
import com.sistemas.entidad.ProductoElaborado;
import com.sistemas.servicio.CategoriaService;
import com.sistemas.servicio.PresentacionService;
import com.sistemas.servicio.ProductoElaboradoService;
import com.sistemas.servicio.ProductoService;
 
import jakarta.validation.Valid;
 
@Controller
@RequestMapping("/productos")
public class ProductosController {
    @Autowired
    private ProductoService productoService;
 
    @Autowired
    private ProductoElaboradoService productoElaboradoService;
 
    @Autowired
    private CategoriaService categoriaService;
 
    @Autowired
    private PresentacionService presentacionService;
 
    @GetMapping("/index")
    public String listarProductos(Model modelo) {
        modelo.addAttribute("listaProductos", productoService.listarTodos());
        modelo.addAttribute("listaProductosElaborados", productoElaboradoService.listarTodos());
        return "Empleado/producto/productoIndex";
    }
 
    @GetMapping("/nuevo")
    public String mostrarFormularioDeNuevoProducto(Model modelo) {
        modelo.addAttribute("producto", new Producto());
        modelo.addAttribute("productoElaborado", new ProductoElaborado());
        modelo.addAttribute("listaCategorias", categoriaService.listarTodos());
        modelo.addAttribute("listaPresentaciones", presentacionService.listarTodos());
        return "Empleado/producto/productoForm";
    }
 /*
    @PostMapping("/guardarProducto")
    public String guardarProducto(@Valid @ModelAttribute("producto") Producto producto, BindingResult resultProducto, Model modelo) {
        if (resultProducto.hasErrors()) {
            prepararModeloParaFormulario(modelo);
            return "Empleado/producto/productoForm";
        }
        productoService.guardarProducto(producto);
        return "redirect:/productos/index";
    }
 
    @PostMapping("/guardarProductoElaborado")
    public String guardarProductoElaborado(@Valid @ModelAttribute("productoElaborado") ProductoElaborado productoElaborado, BindingResult resultProductoElaborado, Model modelo) {
        if (resultProductoElaborado.hasErrors()) {
            prepararModeloParaFormulario(modelo);
            return "Empleado/producto/productoForm";
        }
        productoElaboradoService.guardarProductoElaborado(productoElaborado);
        return "redirect:/productos/index";
    }
 
    private void prepararModeloParaFormulario(Model modelo) {
        modelo.addAttribute("listaCategorias", categoriaService.listarTodos());
        modelo.addAttribute("listaPresentaciones", presentacionService.listarTodos());
        // Añadir cualquier otro atributo necesario
    }*/
}