package br.com.senai.sccv.api.services;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.senai.sccv.api.dao.CursoDao;
import br.com.senai.sccv.api.vo.ClasseGenerica;
import br.com.senai.sccv.api.vo.Filtro;

@Path("/ws/cursos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CursoService {
	
	CursoDao rDao;
	
	public CursoService() {
		rDao = new CursoDao();
	}
	
	@POST
	@Path("/por-filtro")
	public List<ClasseGenerica> listarCursosPorArea (Filtro filtro){
		try {
			

			return rDao.listarCursoPorFiltro(filtro);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
