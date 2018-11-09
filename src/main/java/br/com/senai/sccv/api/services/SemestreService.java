package br.com.senai.sccv.api.services;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.senai.sccv.api.dao.SemestreDao;
import br.com.senai.sccv.api.vo.ClasseGenerica;
import br.com.senai.sccv.api.vo.Filtro;

@Path("/ws/semestre")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SemestreService {
	
	SemestreDao sDao;
	
	public SemestreService() {
		sDao = new SemestreDao();
	}
	
	@POST
	@Path("/por-filtro")
	public List<ClasseGenerica> listarSemestrePorCurso (Filtro filtro){
		try {
			
			return sDao.listarSemestrePorFiltro(filtro);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
 

}
