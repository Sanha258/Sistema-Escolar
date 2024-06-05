package model.entity;

import java.util.Date;

public class Presenca {
	
	private int idPresenca;
	private int idAluno;
	private int idTurma;
	private Date dataPresenca;
	private String presenca;
	
	public Presenca(int idPresenca, int idAluno, int idTurma, Date dataPresenca, String presenca) {
		super();
		this.idPresenca = idPresenca;
		this.idAluno = idAluno;
		this.idTurma = idTurma;
		this.dataPresenca = dataPresenca;
		this.presenca = presenca;
	}

	public Presenca() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdPresenca() {
		return idPresenca;
	}

	public void setIdPresenca(int idPresenca) {
		this.idPresenca = idPresenca;
	}

	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}

	public int getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}

	public Date getDataPresenca() {
		return dataPresenca;
	}

	public void setDataPresenca(Date dataPresenca) {
		this.dataPresenca = dataPresenca;
	}

	public String getPresenca() {
		return presenca;
	}

	public void setPresenca(String presenca) {
		this.presenca = presenca;
	}
	
	

}
