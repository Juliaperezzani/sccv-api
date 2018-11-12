package br.com.senai.sccv.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.senai.sccv.api.config.ConnectionDB;
import br.com.senai.sccv.api.vo.ClasseGenerica;
import br.com.senai.sccv.api.vo.Filtro;

public class FiltroDao {
	
	Connection con;
	PreparedStatement ps;
	
	public List<ClasseGenerica> quantidade() throws SQLException{
		String sql="SELECT * FROM curriculum_vitae cv";
		
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		
		System.out.println(ps.toString());
		
		ResultSet rs = ps.executeQuery();
		List<ClasseGenerica> quantidade = new ArrayList<ClasseGenerica>();
		while (rs.next()) {
			ClasseGenerica cid = new ClasseGenerica();
			cid.setCodigo(rs.getInt("id"));
			cid.setNome(rs.getString("nome"));
			
			quantidade.add(cid);
		}
		
		return quantidade;
	}

}
