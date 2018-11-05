package br.com.senai.sccv.api.services;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.senai.sccv.api.dao.CursoDao;
import br.com.senai.sccv.api.vo.ClasseGenerica;

@Path("/ws/porfiltro")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CursoService {
	
	CursoDao rDao;
	
	public CursoService() {
		rDao = new CursoDao();
	}
	
	public List<ClasseGenerica> listarCursosPorArea (){
		try {
			
			return rDao.listarCursoPorFiltro();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
