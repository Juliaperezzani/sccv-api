package br.com.senai.sccv.api.services;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.senai.sccv.api.dao.FiltroDao;
import br.com.senai.sccv.api.vo.ClasseGenerica;

@Path("/ws/filtro")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FiltroService {
	
	FiltroDao iDao;
	
	public FiltroService() {
		iDao = new FiltroDao();
		
	}
	
	@POST
	@Path("/por-filtro")
	public List<ClasseGenerica> porFiltro(){
		try {
			
			return iDao.quantidade();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
