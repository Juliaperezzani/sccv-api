package br.com.senai.sccv.api.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.senai.sccv.api.dao.SemestreDao;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SemestreService {
	
	SemestreDao sDao;
	
	public SemestreService() {
		sDao = new SemestreDao();
	}
	


}
