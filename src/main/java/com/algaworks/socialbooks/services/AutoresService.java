package com.algaworks.socialbooks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.socialbooks.domain.Autor;
import com.algaworks.socialbooks.repository.AutoresRepository;
import com.algaworks.socialbooks.services.exceptions.AutorExistenteException;
import com.algaworks.socialbooks.services.exceptions.AutorNaoEncontradoException;

@Service
public class AutoresService {
	
	
	@Autowired
	private AutoresRepository autoresRepository;
	
	public List<Autor> listar() {
		return autoresRepository.findAll();
		
	}
	
	public Autor salvar(Autor autor) {
		if(autor.getId() != null) {
			Optional<Autor> a = autoresRepository.findById(autor.getId());
			
			if(a != null) {
				throw new AutorExistenteException("O autor ja existe");
			}
		}
		
		return autoresRepository.save(autor);
	}
	
	public Optional<Autor> buscar(Long id) {
		Optional<Autor> autor = autoresRepository.findById(id);
		
		if(!autor.isPresent()) {
			
			throw new AutorNaoEncontradoException("O autor não pode ser encontrado");
			
		}
		return autor;
	}
	

}
