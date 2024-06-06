package service;

import java.util.ArrayList;

import model.entity.Professor;
import model.repository.ProfessorRepository;

public class ProfessorService {
	
	private ProfessorRepository repository = new ProfessorRepository();
	
		public Professor salvar(Professor novoProfessor) {
	       return repository.salvar(novoProfessor);
	    }
	    
	    public boolean alterar(Professor professorAlterado) {
	        return repository.alterar(professorAlterado);
	     }
	    
	    public boolean excluir(int idProfessor) {
	    	return repository.excluir(idProfessor);
	    	
	    }
	    
	    public Professor consultarPorId(int idProfessor) {
	    	return repository.consultarPorId(idProfessor);
	    }
	    
	    public ArrayList<Professor> consultarTodos() {
	    	return repository.consultarTodos();
	    }

}