package br.com.senai.sccv.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.senai.sccv.api.config.ConnectionDB;
import br.com.senai.sccv.api.vo.ClasseGenerica;

public class CidadeDao {

	Connection con;
	PreparedStatement ps;

	
	public List<ClasseGenerica> listarCidadesDisponiveis() throws SQLException{
		String sql = "SELECT c.id AS id, c.nome as cidade FROM curriculum_vitae cv " + 
				"INNER JOIN usuario u ON (cv.id_usuario = u.id) " + 
				"INNER JOIN cidade c ON (u.id_cidade = c.id)";
		
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		List<ClasseGenerica> lista = new ArrayList<ClasseGenerica>();
		while (rs.next()) {
			ClasseGenerica cid = new ClasseGenerica();
			cid.setCodigo(rs.getInt("id"));
			cid.setNome(rs.getString("cidade"));
			
			lista.add(cid);
		}
		return lista;
	
		
	}

}



