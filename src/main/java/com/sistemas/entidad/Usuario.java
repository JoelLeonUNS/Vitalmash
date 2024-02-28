package com.sistemas.entidad;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table (name = "usuarios")
@Data
public class Usuario implements Serializable, UserDetails{
	
	private static final long serialVersionUID = -4767333280154521938L;
	
	@Id @GeneratedValue (strategy = GenerationType. IDENTITY) 
	private Long id;
	
	@Column(nullable = false, name = "nombre_usuario")
	@NotBlank(message = "El nombre debe tener al menos una letra") 
	private String nombreusuario;
	
	@Column(nullable = false)
	@NotBlank(message = "El password no debe estar en blanco") 
	private String clave;	
	
	@Column(nullable = false)
	@NotBlank(message = "El rol no debe estar en blanco") 
	private String rol;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(rol));
        return authorities;
    }

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return clave;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return nombreusuario;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}	
}
