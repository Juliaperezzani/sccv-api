package br.com.senai.sccv.api.services;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.senai.sccv.api.dao.CidadeDao;
import br.com.senai.sccv.api.vo.Cidade;
import br.com.senai.sccv.api.vo.GenericResponse;

@Path("/ws/cidades")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CidadeService {
	
	CidadeDao cDao;
	
	public CidadeService() {
		cDao = new CidadeDao(); 
	}
	
	@GET
	@Path("/todos")
	public List<Cidade> buscarTodas(){
		try {
			
			return cDao.listar();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GET
	@Path("/disponiveis")
	public List<Cidade> listarCurriculos(){
		try {
			
			return cDao.listarCidadesDisponiveis();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@POST
	@Path("/add")
	public Response adicionarCidade(Cidade c){
		GenericResponse response = new GenericResponse();
		try {
			cDao.inserir(c);
			response.setStatus(true);
			response.setMessage("Cidade incluído com sucesso");
			return Response.ok(response).build();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}

	
}
