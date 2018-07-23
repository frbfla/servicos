package br.com.fastmanners.servicos.enumeration;

public enum TipoSociedade {
	UPH (1,"União Presbiteriana de Homens"),
	SAF (2,"Sociedade Auxiliadora Feminina"),
	UMP (3,"União de Mocidade Presbiteriana"),
	UPA (4,"União Presbiteriana de Adolescentes"),
	UCP (5,"União de Crianças Presbiterianas");
	
	private Integer tipo;
	private String descricao;
	
	public Integer getTipo() {
		return tipo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	private TipoSociedade(Integer tipo, String descricao) {
		this.tipo = tipo;
		this.descricao = descricao;
	}

	public static TipoSociedade getTipoPorId(Integer tipo) {
		switch (tipo) {
		case 1:
			return TipoSociedade.UPH;
		case 2:
			return TipoSociedade.SAF;
		case 3:
			return TipoSociedade.UMP;
		case 4:
			return TipoSociedade.UPA;
		case 5:
			return TipoSociedade.UCP;	
		}
		
		return null;
	}
}
