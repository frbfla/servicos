package br.com.fastmanners.servicos.model;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.fastmanners.servicos.enumeration.TipoSociedade;

@Entity(name = "evento")
public class Evento {

	@Id
	@GeneratedValue
	private Long id;	
	
	@Column(nullable = false, length= 500)
	@NotBlank(message = "Descrição é uma informação obrigatória.")
	private String descricao;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "Data é uma informação obrigatória.")
	private Date dataEvento;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "Data é uma informação obrigatória.")
	private Date dataPublicacao;
	
	@Column(nullable = false)
	@Enumerated
	private TipoSociedade tipoSociedade;
	
	private Blob arquivoImagem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}

	public TipoSociedade getTipoSociedade() {
		return tipoSociedade;
	}

	public void setTipoSociedade(TipoSociedade tipoSociedade) {
		this.tipoSociedade = tipoSociedade;
	}
	
	public Date getDataPublicacao() {
		return dataPublicacao;
	}
	
	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Blob getArquivoImagem() {
		return arquivoImagem;
	}
	
	public void setArquivoImagem(Blob arquivoImagem) {
		this.arquivoImagem = arquivoImagem;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
