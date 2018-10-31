package br.com.senai.sccv.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.senai.sccv.api.config.ConnectionDB;
import br.com.senai.sccv.api.vo.ClasseGenerica;

public class CursoDao {
	
	Connection con;
	PreparedStatement ps;
	
	@SuppressWarnings("unused")
	public List<ClasseGenerica> listarCursoPorFiltro() throws SQLException{
		String sql="";
		
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		List<ClasseGenerica> Curso = new ArrayList<ClasseGenerica>();
		while(rs.next()) {
			ClasseGenerica cid = new ClasseGenerica();
		}
		return Curso;
	}

}
