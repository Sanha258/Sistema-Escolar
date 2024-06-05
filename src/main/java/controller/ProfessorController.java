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
import model.entity.Professor;
import service.ProfessorService;


public class ProfessorController {
	
	private ProfessorService service = new ProfessorService();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Professor salvar(Professor novoProfessor){
		 return service.salvar(novoProfessor);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public boolean alterar (Professor professorAlterado){
		 return service.alterar(professorAlterado);
	}
	
	@DELETE
	@Path("/{id}")
	public boolean excluir(@PathParam("id") int idProfessor) throws EscolaException{
		 return service.excluir(idProfessor);
	}
	
	@GET
	@Path("/{id}")
	public Professor consultarPorId(@PathParam("id") int idProfessor){
		 return service.consultarPorId(idProfessor);
	}
	
	@GET
	@Path("/todas")
	public List<Professor> consultarTodos(){
		 return service.consultarTodos();
	}

}
