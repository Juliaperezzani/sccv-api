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
	
	public List<ClasseGenerica> listarCursoPorFiltro() throws SQLException{
		String sql = "SELECT cur.* FROM curriculum_vitae cv "
				+ "INNER JOIN curso cur On cv.id_curso = cur.id "
				+ "INNER JOIN usuario u On (cv.id_usuario = u.id) "
				+ "WHERE u.id_cidade IN (222,222,3591,4727) A"
				+ "ND u.id_categoria = ?( ";
		
		
		sql = sql.substring(0, sql.length() - 1);
		sql += ")"
				+ " GROUP BY cur.nome";
		
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		List<ClasseGenerica> Curso = new ArrayList<ClasseGenerica>();
		while(rs.next()) {
			ClasseGenerica cid = new ClasseGenerica();
			cid.setCodigo(rs.getInt("id"));
			cid.setNome(rs.getString("nome"));
		}
		return Curso;
	}

}
