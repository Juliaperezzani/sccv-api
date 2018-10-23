package br.com.senai.sccv.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.senai.sccv.api.config.ConnectionDB;
import br.com.senai.sccv.api.vo.Cidade;

public class AreaDao {
	
	Connection con;
	PreparedStatement ps;
	
	public List<Cidade> listarAreasPorCidades () throws SQLException{
		String sql = "SELECT c.* FROM curriculum_vitae cv "
				+ "INNER JOIN categoria c On (cv.id_categoria = c.id)"
				+ "	+ INNER JOIN usuario u On (cv.id_usuario = u.id)"
				+ "WHERE c.id IN (1,2,3)";
		
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		return null;
		
	}

}
