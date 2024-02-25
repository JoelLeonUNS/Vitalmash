package com.sistemas.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemas.entidad.Cliente;
import com.sistemas.repositorio.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public Cliente agregar(Cliente entidad) {
		// TODO Auto-generated method stub
		return clienteRepository.save(entidad);
	}

	@Override
	public List<Cliente> listarTodos() {
		// TODO Auto-generated method stub
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscar(Long id) {
		Cliente encontrado = null;
		Optional<Cliente> buscado = clienteRepository.findById(id);
		
		if(buscado.isPresent()) {
			encontrado = buscado.get();
		}
		
		return encontrado;
	}

	@Override
	public Cliente actualizar(Cliente entidad) {
		// TODO Auto-generated method stub
		return clienteRepository.save(entidad);
	}

	@Override
	public void eliminar(Long id) {
		clienteRepository.deleteById(id);
		
	}

}
