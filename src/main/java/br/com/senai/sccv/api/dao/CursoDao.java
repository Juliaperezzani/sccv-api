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

public class CursoDao {
	
	Connection con;
	PreparedStatement ps;
	
	public List<ClasseGenerica> listarCursoPorFiltro(Filtro filtro) throws SQLException{
		
		List<Integer> cidades = filtro.getIdCidade();
		
		String sql = "SELECT cur.* FROM curriculum_vitae cv "
				+ "INNER JOIN curso cur On cv.id_curso = cur.id "
				+ "INNER JOIN usuario u On (cv.id_usuario = u.id) "
				+ "WHERE u.id_cidade IN (";
				
				for(Integer c : cidades) {
					sql += c + ",";
				}
				sql = sql.substring(0, sql.length() - 1);
				sql += ")"
				
				+ " AND cv.id_categoria = ? "
				+ " GROUP BY cur.nome ";
				
		
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		ps.setString(1, filtro.getArea());
		
		System.out.println(ps.toString());
		
		ResultSet rs = ps.executeQuery();
		List<ClasseGenerica> cursos = new ArrayList<ClasseGenerica>();
		while(rs.next()) {
			ClasseGenerica cid = new ClasseGenerica();
			cid.setCodigo(rs.getInt("id"));
			cid.setNome(rs.getString("nome"));
			
			cursos.add(cid);
		}
		return cursos;
	}

}
