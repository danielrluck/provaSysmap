package com.prova.dto;

public class CursoDisciplinaDTO {
	private long codigoCurso;
	private long codigoDisciplina;
	private String usuario;
	
	public long getCodigoCurso() {
		return codigoCurso;
	}
	public void setCodigoCurso(long codigoCurso) {
		this.codigoCurso = codigoCurso;
	}
	public long getCodigoDisciplina() {
		return codigoDisciplina;
	}
	public void setCodigoDisciplina(long codigoDisciplina) {
		this.codigoDisciplina = codigoDisciplina;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public CursoDisciplinaDTO(long codigoCurso, long codigoDisciplina, String usuario) {
		super();
		this.usuario = usuario;
		this.codigoCurso = codigoCurso;
		this.codigoDisciplina = codigoDisciplina;
	}
	public CursoDisciplinaDTO() {
		
	}
	
	
}
