package service;

import java.util.ArrayList;

import model.entity.Aluno;
import model.repository.AlunoRepository;

public class AlunoService {
	
	private  AlunoRepository repository = new AlunoRepository();

    public Aluno salvar(Aluno novoAluno) {
       return repository.salvar(novoAluno);
    }
    
    public boolean alterar(Aluno alunoAlterado) {
        return repository.alterar(alunoAlterado);
     }
    
    public boolean excluir(int idAluno) {
    	return repository.excluir(idAluno);
    	
    }
    
    public Aluno consultarPorId(int idAluno) {
    	return repository.consultarPorId(idAluno);
    }
    
    public ArrayList<Aluno> consultarTodos() {
    	return repository.consultarTodos();
    }

      
}
	

