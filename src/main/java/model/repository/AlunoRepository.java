package model.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import model.entity.Aluno;
import repositoy.Banco;
import repositoy.BaseRepository;

public class AlunoRepository implements BaseRepository<Aluno>{
	
	@Override
	public Aluno salvar(Aluno novoAluno) {
		String sql = "INSERT INTO Aluno (ID, Nome, DataNascimento, Genero, Endereco, Turma, Email, TelefoneResponsavel)" 
				+"VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		Connection conexao =  (Connection) Banco.getConnection();
		PreparedStatement stmt= Banco.getPreparedStatement(conexao, sql);
		
		try {
			stmt.setInt(1, novoAluno.getIdAluno());
			stmt.setString(2, novoAluno.getNome());
			
			
		} catch (SQLException e) {
			System.out.println("Erro ao salvar novo Aluno!");
			System.out.println("Erro: " + e.getMessage());
		}
		
		return novoAluno;
		
	}

	
	@Override
	public boolean excluir(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterar(Aluno entidade) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Aluno consultarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Aluno> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	
	// resolver os proximos passos
 
}
