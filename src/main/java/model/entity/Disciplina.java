package model.entity;

public class Disciplina {
	
	private int idDisciplina;
	private String nomeDisciplina;
	private String descricao;
	private int professorResponsavel;
	
	public Disciplina(int idDisciplina, String nomeDisciplina, String descricao, int professorResponsavel) {
		super();
		this.idDisciplina = idDisciplina;
		this.nomeDisciplina = nomeDisciplina;
		this.descricao = descricao;
		this.professorResponsavel = professorResponsavel;
	}

	public Disciplina() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getProfessorResponsavel() {
		return professorResponsavel;
	}

	public void setProfessorResponsavel(int professorResponsavel) {
		this.professorResponsavel = professorResponsavel;
	}
	
	

}
