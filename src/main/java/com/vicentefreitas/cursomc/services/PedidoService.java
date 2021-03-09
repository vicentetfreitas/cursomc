package com.vicentefreitas.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vicentefreitas.cursomc.domain.Pedido;
import com.vicentefreitas.cursomc.repositories.PedidoRepository;
import com.vicentefreitas.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	public Pedido buscar(Integer id) {
		// Metodo findById: se encontrar o objeto enviar objeto se não enviar null
		Optional<Pedido> obj = repo.findById(id);

		if (obj == null) {

			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName());
		}

		return obj.orElse(null);
	}
}
