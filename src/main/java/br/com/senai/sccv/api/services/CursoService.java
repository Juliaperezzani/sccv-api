package br.com.senai.sccv.api.services;

import java.sql.SQLException;
import java.util.List;

import br.com.senai.sccv.api.dao.CursoDao;
import br.com.senai.sccv.api.vo.ClasseGenerica;

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
