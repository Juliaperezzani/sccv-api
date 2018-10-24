package br.com.senai.sccv.api.services;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.senai.sccv.api.dao.AreaDao;
import br.com.senai.sccv.api.vo.ClasseGenerica;
import br.com.senai.sccv.api.vo.Filtro;

@Path("/ws/areas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class AreaService {
	
	AreaDao aDao;
	
	public AreaService() {
		aDao = new AreaDao();
	}
		
	@GET
	@Path("/por-cidades")
	public List<ClasseGenerica> listarAreasPorCidades(Filtro filtro ){
		try {
			
			return aDao.listarAreasPorCidades(filtro.getIdCidade());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
