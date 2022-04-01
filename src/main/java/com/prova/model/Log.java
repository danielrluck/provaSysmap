package com.prova.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data

@Entity
public class Log {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long codigo;

	@Column(nullable = false)
	private String acao;

	@Column(nullable = false)
	private String usuario;
	
	@Column(columnDefinition = "TIMESTAMP" ) 
	private Date dtAcao;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getDtAcao() {
		return dtAcao;
	}

	public void setDtAcao(Date dtAcao) {
		this.dtAcao = dtAcao;
	}

	public Log(boolean isInsercao, String usuario) {
		if (isInsercao)
			this.acao = "Inserção";
		else
			this.acao = "Edição";
		
		this.usuario = usuario;
		
		this.dtAcao =  new Date(System.currentTimeMillis());
	}
	
	public Log() {
		
	}
	
	
}
