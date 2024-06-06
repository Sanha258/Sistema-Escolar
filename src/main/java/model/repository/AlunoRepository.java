package model.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



import model.entity.Aluno;
import repositoy.Banco;
import repositoy.BaseRepository;

public class AlunoRepository implements BaseRepository<Aluno> {

	 
	@Override
	public Aluno salvar(Aluno novoAluno) {
		String sql = "INSERT INTO aluno(nome, cpf, dataNascimento, genero, endereco, turma, email, telefoneResponsavel, login, senha)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		 Connection conn = Banco.getConnection();
		 PreparedStatement stmt = Banco.getPreparedStatementWithPk(conn, sql);
		 try {
			 stmt.setString(1, novoAluno.getNome());
			 stmt.setString(2, novoAluno.getCpf());
			 stmt.setDate(3, Date.valueOf(novoAluno.getDataNascimeto().toLocalDate()));
			 stmt.setString(4, novoAluno.getGenero());
			 stmt.setString(5, novoAluno.getEndereco());
			 stmt.setObject(6, novoAluno.getTurma());
			 stmt.setString(7, novoAluno.getEmail());
			 stmt.setInt(8, novoAluno.getTelefone());
			 stmt.setString(9, novoAluno.getLogin());
			 stmt.setString(10, novoAluno.getSenha());
			 
			 stmt.execute();
			 ResultSet resultado = stmt.getGeneratedKeys();
			 if(resultado.next()) {
				 novoAluno.setIdAluno(resultado.getInt(1));
			 }
			 
		 }catch (SQLException e) {
			 System.out.println("Erro ao salvar novo Aluno!");
			 System.out.println("Erro: " + e.getMessage());
		 }
		return novoAluno;
	}
	@Override
	public boolean excluir(int idAluno) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		boolean excluiu = false;
		String query = "DELETE FROM aluno WHERE id =" + idAluno;
		try {
			if(stmt.executeUpdate(query) == 1) {
				excluiu = true;
			}
		}catch (SQLException erro) {
			System.out.println("Erro ao excluir Aluno!");
			System.out.println("Erro: " + erro.getMessage());
		}finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return excluiu;
	}

	@Override
	public boolean alterar(Aluno alunoAlterado) {
		boolean alterou = false;
		String query = "UPDATE aluno" + "SET nome=?, cpf=?, dataNascimento=?, genero=?, endereco=?, turma=?, email=?, telefoneResponsavel=?, login=?, senha=?"
						+ " WHERE idAluno=?";
		 Connection conn = Banco.getConnection();
		 PreparedStatement stmt = Banco.getPreparedStatementWithPk(conn, query);
		 try {
			 stmt.setString(1, alunoAlterado.getNome());
			 stmt.setString(2, alunoAlterado.getCpf());
			 stmt.setDate(3, Date.valueOf(alunoAlterado.getDataNascimeto().toLocalDate()));
			 stmt.setString(4, alunoAlterado.getGenero());
			 stmt.setString(5, alunoAlterado.getEndereco());
			 stmt.setObject(6, alunoAlterado.getTurma());
			 stmt.setString(7, alunoAlterado.getEmail());
			 stmt.setInt(8, alunoAlterado.getTelefone());
			 stmt.setString(9, alunoAlterado.getLogin());
			 stmt.setString(10, alunoAlterado.getSenha());
			 
			stmt.setInt(11, alunoAlterado.getIdAluno());
			alterou= stmt.executeUpdate() > 0;
			 
		 }catch (SQLException e) {
			 System.out.println("Erro ao salvar novo Aluno!");
			 System.out.println("Erro: " + e.getMessage());
		 }finally {
			 Banco.closeStatement(stmt);
			 Banco.closeConnection(conn);
		 }
		 
		return alterou;
	}
		
	

	@Override
	public Aluno consultarPorId(int idAluno) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		
		Aluno aluno = null;
		ResultSet resultado = null;
		String query = "SELECT * FROM aluno WHERE id =" + idAluno;
		
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				aluno = new Aluno();
				
				aluno.setIdAluno(resultado.getInt("idAluno"));
				aluno.setNome(resultado.getString("nome"));
				aluno.setDataNascimeto(resultado.getDate("dataNascimento"));
				aluno.setGenero(resultado.getString("genero"));
				aluno.setEndereco(resultado.getString("endereco"));
			      
				TurmaRepository turmaRepository = new TurmaRepository();
			    aluno.setTurma(turmaRepository.consultarPorId(resultado.getInt("turma")));
			    aluno.setEmail(resultado.getString("email"));
			    aluno.setTelefone(resultado.getInt("telefoneResponsavel"));
			    aluno.setLogin(resultado.getString("login"));
			    aluno.setSenha(resultado.getString("senha"));
			}
			
		}catch (SQLException erro) {
			System.out.println("Erro ao consultar Aluno com o id:" + idAluno);
			System.out.println("Erro: " + erro.getMessage());
		}finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return aluno;
	}

	@Override
	public ArrayList<Aluno> consultarTodos() {
	    Connection conn = Banco.getConnection();
	    Statement stmt = Banco.getStatement(conn);
	    ResultSet resultado = null;
	    ArrayList<Aluno> alunos = new ArrayList<>();
	   
	    String query = "SELECT * FROM aluno"; 
	   

	    try {
	    	 resultado = stmt.executeQuery(query);
	    	 
	        while (resultado.next()) {
	            Aluno aluno = new Aluno(); 

	            aluno.setIdAluno(resultado.getInt("idAluno"));
				aluno.setNome(resultado.getString("nome"));
				aluno.setDataNascimeto(resultado.getDate("dataNascimento"));
				aluno.setGenero(resultado.getString("genero"));
				aluno.setEndereco(resultado.getString("endereco"));
			      
				TurmaRepository turmaRepository = new TurmaRepository();
			    aluno.setTurma(turmaRepository.consultarPorId(resultado.getInt("turma")));
			    aluno.setEmail(resultado.getString("email"));
			    aluno.setTelefone(resultado.getInt("telefoneResponsavel"));
			    aluno.setLogin(resultado.getString("login"));
			    aluno.setSenha(resultado.getString("senha")); 
			    
	            alunos.add(aluno); 
	        }
	    } catch (SQLException erro) {
	        System.out.println("Erro ao consultar todos os alunos.");
	        System.out.println("Erro: " + erro.getMessage());
	    } finally {
	        
			Banco.closeResultSet(resultado);
	        Banco.closeStatement(stmt);
	        Banco.closeConnection(conn);
	    }

	    return alunos; 
	}
	
	
}
