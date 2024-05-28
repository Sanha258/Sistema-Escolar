package model.entity;

public class Pessoa {
	
	private int id;
	private String nome;
	private String genero;
	private String endereco;
	private String email;
	private int telefone;
	
	public Pessoa(int id, String nome, String genero, String endereco, String email, int telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.genero = genero;
		this.endereco = endereco;
		this.email = email;
		this.telefone = telefone;
	}

	public Pessoa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
	

}
