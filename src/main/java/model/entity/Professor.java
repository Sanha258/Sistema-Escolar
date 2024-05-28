package model.entity;

public class Professor extends Pessoa {
	
	private int salario;
	private String formacao;
	
	public Professor(int id, String nome, String genero, String endereco, String email, int telefone, int salario,
			String formacao) {
		super(id, nome, genero, endereco, email, telefone);
		this.salario = salario;
		this.formacao = formacao;
	}

	public Professor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Professor(int id, String nome, String genero, String endereco, String email, int telefone) {
		super(id, nome, genero, endereco, email, telefone);
		// TODO Auto-generated constructor stub
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	
	

	
}
