package br.com.fastmanners.servicos.enumeration;

public enum TipoMinisterio {
	
	LOUVOR (1,"Ministério de Louvor"),
	CORAL (2,"Grupo Coral"),
	ORACAO (3,"Ministério de Oração"),
	VISITACAO (4,"Ministério de Visitação");
	
	private Integer tipo;
	private String descricao;
	
	public Integer getTipo() {
		return tipo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	private TipoMinisterio(Integer tipo, String descricao) {
		this.tipo = tipo;
		this.descricao = descricao;
	}

	public static TipoMinisterio getTipoPorId(Integer tipo) {
		switch (tipo) {
			case 1:
				return TipoMinisterio.LOUVOR;
			case 2:
				return TipoMinisterio.CORAL;
			case 3:
				return TipoMinisterio.ORACAO;
			case 4:
				return TipoMinisterio.VISITACAO;
		}
		return null;
	}
}
