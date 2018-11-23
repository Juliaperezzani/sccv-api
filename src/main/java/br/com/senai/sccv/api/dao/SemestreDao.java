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

public class SemestreDao {

	Connection con;
	PreparedStatement ps;

	public List<ClasseGenerica> listarSemestrePorFiltro(Filtro filtro) throws SQLException {

		List<Integer> cidades = filtro.getIdCidade();

		String sql = "SELECT cv.* FROM curriculum_vitae cv " + "INNER JOIN curso cur On cv.id_curso = cur.id "
				+ "INNER JOIN usuario u On (cv.id_usuario = u.id) " + "WHERE u.id_cidade IN (";

		for (Integer c : cidades) {
			sql += c + ",";
		}
		sql = sql.substring(0, sql.length() - 1);
		sql += ")"

				+ " AND cv.id_categoria = ? " + " AND cv.id_curso = ? " + " GROUP BY cur.nome ";

		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		ps.setInt(1, filtro.getArea());
		ps.setInt(2, filtro.getIdCurso());

		System.out.println(ps.toString());

		ResultSet rs = ps.executeQuery();
		List<ClasseGenerica> semestre = new ArrayList<ClasseGenerica>();
		while (rs.next()) {
			ClasseGenerica cid = new ClasseGenerica();
			cid.setCodigo(rs.getInt("semestre"));
			cid.setNome(rs.getString("semestre"));

			semestre.add(cid);
		}
		return semestre;
	}
}
