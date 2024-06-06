package model.entity;

public class Professor extends Pessoa {
	
	private int idProfessor;
	private double salario;
	private String formacao;
	
	public Professor(int id, String nome, String cpf, String genero, String endereco, String email, int telefone,
			String login, String senha, int idProfessor, double salario, String formacao) {
		super(id, nome, cpf, genero, endereco, email, telefone, login, senha);
		this.idProfessor = idProfessor;
		this.salario = salario;
		this.formacao = formacao;
	}

	public Professor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Professor(int id, String nome, String cpf, String genero, String endereco, String email, int telefone,
			String login, String senha) {
		super(id, nome, cpf, genero, endereco, email, telefone, login, senha);
		// TODO Auto-generated constructor stub
	}

	public int getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	
	
	
}