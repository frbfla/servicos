package br.com.fastmanners.servicos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fastmanners.servicos.model.Evento;
import br.com.fastmanners.servicos.repository.EventoRepository;

@Service
public class EventoService {

	@Autowired
	private EventoRepository repository;
	
	public Iterable<Evento> obterTodos(){
		Iterable<Evento> eventos = repository.findAll();
		return eventos;
	}
	
	
	public void salvar(Evento evento){
		repository.save(evento);
	}


	public Evento obterEventoPorId(Long id) {
		return this.repository.findOne(id);
	}

}
