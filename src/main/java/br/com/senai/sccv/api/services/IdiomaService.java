package br.com.senai.sccv.api.services;

import javax.ws.rs.Consumes;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.senai.sccv.api.dao.IdiomaDao;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class IdiomaService {
	
	IdiomaDao iDao;
	
	public IdiomaService() {
		iDao = new IdiomaDao();
		
	}
	
	

}
