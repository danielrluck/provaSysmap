package com.prova.dto;


public class CursoDTO {

	private long codigo;
	
	private String descricao;
	
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
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public CursoDTO(long codigo, String descricao, String usuario) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.usuario = usuario;
	}

}
