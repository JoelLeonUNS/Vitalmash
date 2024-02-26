package com.sistemas.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
    @PostMapping("/login")
    public String usuario(@RequestParam String nombreUsuario, @RequestParam String clave, Model model) {
        // validar que tipo de usuario es
    	if(nombreUsuario.equals("cliente")) {
    		return "cliente/clienteIndex";
    	} else {
    		return "empleado/empleadoIndex";
    	}
        
    }
}
