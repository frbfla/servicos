package br.com.fastmanners.servicos.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.fastmanners.servicos.model.Mensagem;

public interface MensagemRepository extends CrudRepository<Mensagem, Long>{

}
