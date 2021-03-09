package com.vicentefreitas.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vicentefreitas.cursomc.domain.Categoria;
import com.vicentefreitas.cursomc.repositories.CategoriaRepository;
import com.vicentefreitas.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria buscar(Integer id) {
		// Metodo findById: se encontrar o objeto enviar objeto se não enviar null
		Optional<Categoria> obj = repo.findById(id);

		if (obj == null) {

			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName());
		}

		return obj.orElse(null);
	}
}
