package com.prova.dto;


public class DisciplinaDTO {
	private long codigo;
	
	private String descricao;

	private Integer qtCargaHorariaTotal;
	
	private Integer qtCargaHorariaPratica;
	
	private Integer qtCargaHorariaTeorica;

	private Integer qtAlunos;

	private String usuario;
	
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQtCargaHorariaTotal() {
		return qtCargaHorariaTotal;
	}

	public void setQtCargaHorariaTotal(Integer qtCargaHorariaTotal) {
		this.qtCargaHorariaTotal = qtCargaHorariaTotal;
	}

	public Integer getQtCargaHorariaPratica() {
		return qtCargaHorariaPratica;
	}

	public void setQtCargaHorariaPratica(Integer qtCargaHorariaPratica) {
		this.qtCargaHorariaPratica = qtCargaHorariaPratica;
	}

	public Integer getQtCargaHorariaTeorica() {
		return qtCargaHorariaTeorica;
	}

	public void setQtCargaHorariaTeorica(Integer qtCargaHorariaTeorica) {
		this.qtCargaHorariaTeorica = qtCargaHorariaTeorica;
	}

	public Integer getQtAlunos() {
		return qtAlunos;
	}

	public void setQtAlunos(Integer qtAlunos) {
		this.qtAlunos = qtAlunos;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
