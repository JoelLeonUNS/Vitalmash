package com.sistemas.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sistemas.entidad.Usuario;
import com.sistemas.servicio.LoginService;
import com.sistemas.servicio.UsuarioService;
import com.sistemas.servicio.UsuarioServiceImpl;

@Controller
public class LoginController {
	
	@Autowired
    private LoginService loginService;
	
    @PostMapping("/login")
    public String usuario(@RequestParam String nombreUsuario, @RequestParam String clave, Model model) {
    	
    	Usuario usuario = loginService.autenticar(nombreUsuario, clave);
        
        if(usuario != null) {
           model.addAttribute("usuario", usuario);
           String rol = usuario.getRol().toLowerCase();
           return "redirect:/" + rol;
        }
        
        model.addAttribute("error", "Usuario o clave incorrecto!");
        return "publico/login";
        
    }
}
