package com.prova.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Disciplina {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long codigo;

	@Column
	private String descricao;
	
	@Column
	private Integer qtCargaHorariaTotal;

	@Column
	private Integer qtCargaHorariaPratica;
	
	@Column
	private Integer qtCargaHorariaTeorica;

	@Column
	private Integer qtAlunos;

	@OneToMany(fetch = FetchType.EAGER)
	private List<Log> logs = new ArrayList<Log>();

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

	public List<Log> getLogs() {
		return logs;
	}

	public void setLogs(List<Log> logs) {
		this.logs = logs;
	}

	
}
