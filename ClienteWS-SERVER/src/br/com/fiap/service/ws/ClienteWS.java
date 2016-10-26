package br.com.fiap.service.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.exceptions.DBCommitException;
import br.com.fiap.exceptions.IdNotFoundException;
import br.com.fiap.model.Cliente;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

@Path("/cliente")
public class ClienteWS {
	
	private ClienteDAO dao;
	
	//Construtor
	public ClienteWS() {
		dao = new ClienteDAOImpl(EntityManagerFactorySingleton.getInstance());
	}
	
	
	//Cadastrar
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(String cliJson){
		Cliente c = new Gson().fromJson(cliJson, Cliente.class);
			try{
				dao.insert(c);
				
				return Response.status(201).build();
			}catch(DBCommitException e){
				return Response.status(500).build();
			}
		
		
	}
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(String json){
		
		Cliente c = new Gson().fromJson(json, Cliente.class);
			try{
				dao.update(c);
				return Response.status(200).build();
			}catch(DBCommitException e){
				e.printStackTrace();
				return Response.status(500).build();
			}
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletar(@PathParam("id") int id){
		
		try{
			dao.delete(id);
			return Response.status(200).entity("Cliente removido !").build();
		}catch(DBCommitException  | IdNotFoundException e){
			e.printStackTrace();
			
			return Response.status(500).entity("Ocorreu um erro !").build();
			
		}

	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String listar(){
		
		List<Cliente>clientes = dao.list();
		
		return new Gson().toJson(clientes);
		
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public String findByid(@PathParam("id")int id){
		
		Cliente c = dao.findById(id);
		
		return new Gson().toJson(c);
		
	}

}
