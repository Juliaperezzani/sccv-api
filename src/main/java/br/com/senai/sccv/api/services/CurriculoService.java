package br.com.senai.sccv.api.services;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.senai.sccv.api.dao.CurriculoDao;
import br.com.senai.sccv.api.vo.Curriculo;
import br.com.senai.sccv.api.vo.Filtro;

@Path("/ws/curriculos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CurriculoService {
	
	CurriculoDao curriDao;
	
	public CurriculoService(){
		try {
			curriDao = new CurriculoDao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@POST
	@Path("/por-filtro")
	public List<Curriculo> listarCurriculum (Filtro filtro){
		try {
			
			return curriDao.listarCurriculoPorFiltro(filtro);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
