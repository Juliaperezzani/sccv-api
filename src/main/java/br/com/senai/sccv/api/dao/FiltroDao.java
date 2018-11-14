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
	
	public List<ClasseGenerica> quantidade(Filtro filtro) throws SQLException{
		
		List<Integer> cidades = filtro.getIdCidade();
		
		String sql="SELECT * FROM curriculum_vitae cv "
				+ " INNER JOIN curso cur On cv.id_curso = cur.id "
				+ " INNER JOIN usuario u On (cv.id_usuario = u.id) "
				+ " INNER JOIN formacao f ON (f.id_curriculum_vitae = cv.id) "
				+ " WHERE u.id_cidade IN ( 229, 3852) "
                + " AND cv.id_categoria = ? "
                + " AND cv.id_curso = ? "
                + " AND cv.semestre = ? "
                + " AND u.id_sexo = ? " 
				+ " AND u.pessoa_pcd = 0 "
                + " AND (SELECT FROM_UNIXTIME((u.idade)/1000, '%Y')) BETWEEN "?" AND "?"
                + " AND cv.id IN (SELECT e.id_curriculum_vitae FROM experiencia e WHERE e.id_curriculum_vitae = cv.id)";
		
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		ps.setInt(1, filtro.getArea());
		ps.setInt(2, filtro.getExperiencia());
		ps.setInt(3, filtro.getIdCurso());
		ps.setInt(4, filtro.getSemestre());
		ps.setInt(5, filtro.getSexo());
		
		
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
