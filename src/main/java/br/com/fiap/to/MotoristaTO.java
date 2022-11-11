package br.com.fiap.to;

public class MotoristaTO extends Pessoa {
	
	private String categoriaHabilitacao, dataExpedicao, numeroHabilitacao;
	private int id;
	
	public MotoristaTO() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	public MotoristaTO(String categoriaHabilitacao, String numeroHabilitacao, String dataExpedicao) {
		super();
		this.categoriaHabilitacao = categoriaHabilitacao;
		this.numeroHabilitacao = numeroHabilitacao;
		this.dataExpedicao = dataExpedicao;
	}

	public String getCategoriaHabilitacao() {
		return categoriaHabilitacao;
	}
	public void setCategoriaHabilitacao(String categoriaHabilitacao) {
		this.categoriaHabilitacao = categoriaHabilitacao;
	}
	public String getNumeroHabilitacao() {
		return numeroHabilitacao;
	}
	public void setNumeroHabilitacao(String numeroHabilitacao) {
		this.numeroHabilitacao = numeroHabilitacao;
	}
	public String getDataExpedicao() {
		return dataExpedicao;
	}
	public void setDataExpedicao(String dataExpedicao) {
		this.dataExpedicao = dataExpedicao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
