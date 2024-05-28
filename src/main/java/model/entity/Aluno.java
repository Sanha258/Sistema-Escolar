package model.entity;

public class Aluno extends Pessoa {
	
	private int idAluno;
	private String dataNascimeto ;
	private Turma turma;
	
	public Aluno(int id, String nome, String genero, String endereco, String email, int telefone, int idAluno,
			String dataNascimeto, Turma turma) {
		super(id, nome, genero, endereco, email, telefone);
		this.idAluno = idAluno;
		this.dataNascimeto = dataNascimeto;
		this.turma = turma;
	}

	public Aluno() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Aluno(int id, String nome, String genero, String endereco, String email, int telefone) {
		super(id, nome, genero, endereco, email, telefone);
		// TODO Auto-generated constructor stub
	}

	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}

	public String getDataNascimeto() {
		return dataNascimeto;
	}

	public void setDataNascimeto(String dataNascimeto) {
		this.dataNascimeto = dataNascimeto;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	
	
}
