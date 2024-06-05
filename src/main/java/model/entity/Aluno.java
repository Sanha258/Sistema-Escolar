package model.entity;

import java.sql.Date;

public class Aluno extends Pessoa {
	
	private int idAluno;
	private Date dataNascimeto ;
	private Turma turma;
	
	public Aluno() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Aluno(int id, String nome, String cpf, String genero, String endereco, String email, int telefone,
			String login, String senha) {
		super(id, nome, cpf, genero, endereco, email, telefone, login, senha);
		// TODO Auto-generated constructor stub
	}

	public Aluno(int id, String nome, String cpf, String genero, String endereco, String email, int telefone,
			String login, String senha, int idAluno, Date dataNascimeto, Turma turma) {
		super(id, nome, cpf, genero, endereco, email, telefone, login, senha);
		this.idAluno = idAluno;
		this.dataNascimeto = dataNascimeto;
		this.turma = turma;
	}

	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}

	public Date getDataNascimeto() {
		return dataNascimeto;
	}

	public void setDataNascimeto(Date dataNascimeto) {
		this.dataNascimeto = dataNascimeto;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}


}
