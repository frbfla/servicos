package br.com.fastmanners.servicos.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.fastmanners.servicos.model.Evento;

public interface EventoRepository extends CrudRepository<Evento, Long>{

}
