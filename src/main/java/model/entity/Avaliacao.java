package model.entity;

import java.util.Date;

public class Avaliacao {
	
	private int idAvalicao;
	private int idAluno;
	private int idDisciplina;
	private double nota;
	private Date dataNota;
	
	public Avaliacao(int idAvalicao, int idAluno, int idDisciplina, double nota, Date dataNota) {
		super();
		this.idAvalicao = idAvalicao;
		this.idAluno = idAluno;
		this.idDisciplina = idDisciplina;
		this.nota = nota;
		this.dataNota = dataNota;
	}

	public Avaliacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdAvalicao() {
		return idAvalicao;
	}

	public void setIdAvalicao(int idAvalicao) {
		this.idAvalicao = idAvalicao;
	}

	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}

	public int getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public Date getDataNota() {
		return dataNota;
	}

	public void setDataNota(Date dataNota) {
		this.dataNota = dataNota;
	}
	
	

}
