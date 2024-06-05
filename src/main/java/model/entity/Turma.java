package model.entity;

public class Turma {
	
	private int idTurma;
	private String nomeTurma;
	private String anoSerie;
	private int professorResponsavel;
	
	public Turma(int idTurma, String nomeTurma, String anoSerie, int professorResponsavel) {
		super();
		this.idTurma = idTurma;
		this.nomeTurma = nomeTurma;
		this.anoSerie = anoSerie;
		this.professorResponsavel = professorResponsavel;
	}

	public Turma() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}

	public String getNomeTurma() {
		return nomeTurma;
	}

	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}

	public String getAnoSerie() {
		return anoSerie;
	}

	public void setAnoSerie(String anoSerie) {
		this.anoSerie = anoSerie;
	}

	public int getProfessorResponsavel() {
		return professorResponsavel;
	}

	public void setProfessorResponsavel(int professorResponsavel) {
		this.professorResponsavel = professorResponsavel;
	}
	
	

}
