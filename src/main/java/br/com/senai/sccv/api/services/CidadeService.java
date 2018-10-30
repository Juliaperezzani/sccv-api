package br.com.senai.sccv.api.services;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import br.com.senai.sccv.api.dao.CidadeDao;
import br.com.senai.sccv.api.vo.ClasseGenerica;


@Path("/ws/cidades")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CidadeService {
	
	CidadeDao cDao;
	
	public CidadeService() {
		cDao = new CidadeDao(); 
	}

	
	@GET
	@Path("/disponiveis")
	
	
	public List<ClasseGenerica> listarCurriculos(){
		try {
			
			return cDao.listarCidadesDisponiveis();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
	
	

	

