package com.vicentefreitas.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vicentefreitas.cursomc.domain.Cliente;
import com.vicentefreitas.cursomc.repositories.ClienteRepository;
import com.vicentefreitas.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Cliente buscar(Integer id) {
		// Metodo findById: se encontrar o objeto enviar objeto se não enviar null
		Optional<Cliente> obj = repo.findById(id);

		if (obj == null) {

			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName());
		}

		return obj.orElse(null);
	}
}
