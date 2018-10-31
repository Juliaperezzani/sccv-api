package br.com.senai.sccv.api.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.senai.sccv.api.config.ConnectionDB;
import br.com.senai.sccv.api.vo.ClasseGenerica;

public class AreaDao {
	
	Connection con;
	PreparedStatement ps;
	
	
	public List<ClasseGenerica> listarAreasPorCidades (List<Integer> cidades) throws SQLException{
			
		String sql = "SELECT c.* FROM curriculum_vitae cv "
				+ "INNER JOIN categoria c On (cv.id_categoria = c.id) "
				+ "INNER JOIN usuario u On (cv.id_usuario = u.id) "
				+ "WHERE u.id_cidade IN (";
		
		for(Integer c : cidades) {
			sql += c + ",";
		}
		sql = sql.substring(0, sql.length() - 1);
		sql += ")"
				+ " GROUP BY c.nome";
		
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		List<ClasseGenerica> categoria = new ArrayList<ClasseGenerica>();
		while (rs.next()) {
			ClasseGenerica cid = new ClasseGenerica();
			cid.setCodigo(rs.getInt("id"));
			cid.setNome(rs.getString("nome"));
			
			categoria.add(cid);
		}
		
		
		return categoria;
		
	}

}
