package model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import model.entity.Professor;
import repositoy.Banco;
import repositoy.BaseRepository;

public class ProfessorRepository implements BaseRepository<Professor>{

	@Override
	public Professor salvar(Professor novoProfessor) {
		
		String sql = "INSERT INTO professor(nome, cpf, genero, endereco, email, telefone, login, senha, salario, formacao)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		 Connection conn = Banco.getConnection();
		 PreparedStatement stmt = Banco.getPreparedStatementWithPk(conn, sql);
		 try {
			 stmt.setString(1, novoProfessor.getNome());
			 stmt.setString(2, novoProfessor.getCpf());
			 stmt.setString(3, novoProfessor.getGenero());
			 stmt.setString(4, novoProfessor.getEndereco());
			 stmt.setString(5, novoProfessor.getEmail());
			 stmt.setInt(6, novoProfessor.getTelefone());
			 stmt.setString(7, novoProfessor.getLogin());
			 stmt.setString(8, novoProfessor.getSenha());
			 stmt.setDouble(9, novoProfessor.getSalario());
			 stmt.setString(10, novoProfessor.getFormacao());
			 
			 stmt.execute();
			 ResultSet resultado = stmt.getGeneratedKeys();
			 if(resultado.next()) {
				 novoProfessor.setIdProfessor(resultado.getInt(1));
			 }
			 
		 }catch (SQLException e) {
			 System.out.println("Erro ao salvar novo Aluno!");
			 System.out.println("Erro: " + e.getMessage());
		 }
		return novoProfessor;
	}

	@Override
	public boolean excluir(int idProfessor) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		boolean excluiu = false;
		String query = "DELETE FROM professor WHERE id =" + idProfessor;
		try {
			if(stmt.executeUpdate(query) == 1) {
				excluiu = true;
			}
		}catch (SQLException erro) {
			System.out.println("Erro ao excluir Professor!");
			System.out.println("Erro: " + erro.getMessage());
		}finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return excluiu;
	}

	@Override
	public boolean alterar(Professor professorAlterado) {
		boolean alterou = false;
		String query = "UPDATE aluno" + "SET nome=?, cpf=?, dataNascimento=?, genero=?, endereco=?, turma=?, email=?, telefoneResponsavel=?, login=?, senha=?"
						+ " WHERE idAluno=?";
		 Connection conn = Banco.getConnection();
		 PreparedStatement stmt = Banco.getPreparedStatementWithPk(conn, query);
		 try {
			 stmt.setString(1, professorAlterado.getNome());
			 stmt.setString(2, professorAlterado.getCpf());
			 stmt.setString(3, professorAlterado.getGenero());
			 stmt.setString(4, professorAlterado.getEndereco());
			 stmt.setString(5, professorAlterado.getEmail());
			 stmt.setInt(6, professorAlterado.getTelefone());
			 stmt.setString(7, professorAlterado.getLogin());
			 stmt.setString(8, professorAlterado.getSenha());
			 stmt.setDouble(9, professorAlterado.getSalario());
			 stmt.setString(10, professorAlterado.getFormacao());
			 
			
			 
			stmt.setInt(11, professorAlterado.getIdProfessor());
			alterou= stmt.executeUpdate() > 0;
			 
		 }catch (SQLException e) {
			 System.out.println("Erro ao salvar novo Professor!");
			 System.out.println("Erro: " + e.getMessage());
		 }finally {
			 Banco.closeStatement(stmt);
			 Banco.closeConnection(conn);
		 }
		 
		return alterou;
	}

	@Override
	public Professor consultarPorId(int idProfessor) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		
		Professor professor = null;
		ResultSet resultado = null;
		String query = "SELECT * FROM professor WHERE idProfessor =" + idProfessor;
		
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				professor = new Professor();
				
				professor.setIdProfessor(resultado.getInt("idProfessor"));
				professor.setNome(resultado.getString("nome"));
				professor.setCpf(resultado.getString("cpf"));
				professor.setGenero(resultado.getString("genero"));
				professor.setEndereco(resultado.getString("endereco"));
			    professor.setEmail(resultado.getString("email"));
			    professor.setTelefone(resultado.getInt("telefone"));
			    professor.setLogin(resultado.getString("login"));
			    professor.setSenha(resultado.getString("senha"));
			    professor.setSalario(resultado.getDouble("salario"));
			    professor.setFormacao(resultado.getString("formacao"));
			}
			
		}catch (SQLException erro) {
			System.out.println("Erro ao consultar Professor com o id:" + idProfessor);
			System.out.println("Erro: " + erro.getMessage());
		}finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return professor;
	}

	@Override
	public ArrayList<Professor> consultarTodos() {
		Connection conn = Banco.getConnection();
	    Statement stmt = Banco.getStatement(conn);
	    ResultSet resultado = null;
	    ArrayList<Professor> professores = new ArrayList<>();
	   
	    String query = "SELECT * FROM professor"; 
	   

	    try {
	    	 resultado = stmt.executeQuery(query);
	    	 
	        while (resultado.next()) {
	        	Professor professor = new Professor();
	        	
	        	professor.setIdProfessor(resultado.getInt("idProfessor"));
				professor.setNome(resultado.getString("nome"));
				professor.setCpf(resultado.getString("cpf"));
				professor.setGenero(resultado.getString("genero"));
				professor.setEndereco(resultado.getString("endereco"));
			    professor.setEmail(resultado.getString("email"));
			    professor.setTelefone(resultado.getInt("telefone"));
			    professor.setLogin(resultado.getString("login"));
			    professor.setSenha(resultado.getString("senha"));
			    professor.setSalario(resultado.getDouble("salario"));
			    professor.setFormacao(resultado.getString("formacao"));
	           
	            professores.add(professor); 
	        }
	    } catch (SQLException erro) {
	        System.out.println("Erro ao consultar todos os alunos.");
	        System.out.println("Erro: " + erro.getMessage());
	    } finally {
	        
			Banco.closeResultSet(resultado);
	        Banco.closeStatement(stmt);
	        Banco.closeConnection(conn);
	    }

	    return professores; 
	}
		
}
