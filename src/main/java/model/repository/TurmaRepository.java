package model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.entity.Turma;
import repositoy.Banco;
import repositoy.BaseRepository;

public class TurmaRepository implements BaseRepository<Turma>{

	@Override
	public Turma salvar(Turma novaTurma) {
		String sql = "INSERT INTO turma (nomeTurma, anoSerie, professorResponsavel) VALUES (?, ?, ?)";
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatementWithPk(conn, sql);
		
        try {
            stmt.setString(1, novaTurma.getNomeTurma());
            stmt.setString(2, novaTurma.getAnoSerie());
            stmt.setInt(3, novaTurma.getProfessorResponsavel());
            
            stmt.execute();
            ResultSet resultado = stmt.getGeneratedKeys();
            if(resultado.next()) {
            	novaTurma.setIdTurma(resultado.getInt(1));
            }
        } catch (SQLException e) {
        	System.out.println("Erro ao salvar turma!");
            System.out.println("Erro ao salvar turma: " + e.getMessage());
        }
    
		return novaTurma;
	}

	@Override
	public boolean excluir(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterar(Turma entidade) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Turma consultarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Turma> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
