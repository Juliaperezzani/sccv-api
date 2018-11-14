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

public class CurriculoDao {

	Connection con;
	PreparedStatement ps;
	
	public List<ClasseGenerica> listarCurriculoPorFiltro(Filtro filtro) throws SQLException{
		
		List<Integer> cidades = filtro.getIdCidade();
		
		String sql = "SELECT * FROM curriculum_vitae cv"
			+	"INNER JOIN curso cur On cv.id_curso = cur.id" 
			+	"INNER JOIN usuario u On (cv.id_usuario = u.id)"
            +   "INNER JOIN formacao f ON (f.id_curriculum_vitae = cv.id)"
			+	"WHERE u.id_cidade IN ( ?, ?)"
            +   "AND cv.id_categoria = ?"
            +   "AND cv.id_curso = ?"
            +   "AND cv.semestre = ?"
            +   "AND u.id_sexo = ?"
			+   "AND u.pessoa_pcd = ?"
            +   "AND (SELECT FROM_UNIXTIME((u.idade)/1000, '%Y')) BETWEEN "?" AND "?""
            +    "AND cv.id IN (SELECT e.id_curriculum_vitae FROM experiencia e WHERE e.id_curriculum_vitae = cv.id)"
		  
	
				
				con = ConnectionDB.getConnection();
				ps = con.prepareStatement(sql);
				ps.setInt(1, filtro.getArea());
				ps.setInt(2,filtro.getIdCurso());
				ps.setInt(3, filtro.getIdCidade());
				ps.setInt(4,filtro.getIdCurso());
				ps.setInt(5, filtro.getSemestre());
				ps.setInt(6, filtro.getSexo());
				ps.setInt(7, filtro.getDeficiencia());
				ps.setInt(8, filtro.getIdade_inicio());
				ps.setInt(9, filtro.getIdade_fim());
				ps.setInt(10, filtro.getExperiencia());
				
				System.out.println(ps.toString());
				
				ResultSet rs = ps.executeQuery();
				List<ClasseGenerica> curriculos = new ArrayList<ClasseGenerica>();
				while(rs.next()) {
					ClasseGenerica cid = new ClasseGenerica();
					cid.setCodigo(rs.getInt("id"));
					cid.setNome(rs.getString("nome"));
					
					curriculos.add(cid);
				}
				return curriculos;
			}
}
