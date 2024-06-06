package controller;

import java.util.List;

import exception.EscolaException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.entity.Aluno;
import service.AlunoService;

@Path("/aluno")
public class AlunoController {
	
	private AlunoService service = new AlunoService();
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Aluno salvar(Aluno novoAluno){
		 return service.salvar(novoAluno);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public boolean alterar (Aluno alunoAlterado){
		 return service.alterar(alunoAlterado);
	}
	
	@DELETE
	@Path("/{id}")
	public boolean excluir(@PathParam("id") int idAluno) throws EscolaException{
		 return service.excluir(idAluno);
	}
	
	@GET
	@Path("/{id}")
	public Aluno consultarPorId(@PathParam("id") int idAluno){
		 return service.consultarPorId(idAluno);
	}
	
	@GET
	@Path("/todas")
	public List<Aluno> consultarTodos(){
		 return service.consultarTodos();
	}

}