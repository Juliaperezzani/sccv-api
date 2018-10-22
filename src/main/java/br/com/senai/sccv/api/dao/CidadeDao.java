package br.com.senai.sccv.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.senai.sccv.api.config.ConnectionDB;
import br.com.senai.sccv.api.vo.Cidade;

public class CidadeDao {

	Connection con;
	PreparedStatement ps;

	
	public List<Cidade> listarCidadesDisponiveis() throws SQLException{
		String sql = "SELECT c.nome as cidade FROM curriculum_vitae cv " + 
				"INNER JOIN usuario u ON (cv.id_usuario = u.id) " + 
				"INNER JOIN cidade c ON (u.id_cidade = c.id)";
		
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		List<Cidade> lista = new ArrayList<Cidade>();
		while (rs.next()) {
			Cidade cid = new Cidade();
			cid.setCodigo(rs.getInt("id"));
			cid.setNome(rs.getString("nome"));
			
			lista.add(cid);
		}
		return lista;
	
		
	}

}
