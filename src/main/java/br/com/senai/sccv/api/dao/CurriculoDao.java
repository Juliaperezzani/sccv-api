package br.com.senai.sccv.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.senai.sccv.api.config.ConnectionDB;
import br.com.senai.sccv.api.vo.Curriculo;
import br.com.senai.sccv.api.vo.Experiencia;
import br.com.senai.sccv.api.vo.Filtro;
import br.com.senai.sccv.api.vo.Formacao;

public class CurriculoDao {

	Connection con;
	PreparedStatement ps;

	public CurriculoDao() throws SQLException {
		con = ConnectionDB.getConnection();
	}

	public List<Curriculo> listarCurriculoPorFiltro(Filtro filtro) throws SQLException {

		List<Integer> cidades = filtro.getIdCidade();

		String sql = "SELECT *, cid.nome AS nomeCidade, u.nome AS nomeAluno, cur.nome AS nomeCurso, est.nome AS nomeEstado, cv.id AS idCurriculo FROM curriculum_vitae cv"
				+ " INNER JOIN curso cur On cv.id_curso = cur.id" + " INNER JOIN usuario u On (cv.id_usuario = u.id)"
				+ " INNER JOIN cidade AS cid ON (cid.id = u.id_cidade)"
				+ " INNER JOIN estado AS est ON (est.id = u.id_estado)"
				+ " LEFT JOIN formacao f ON (f.id_curriculum_vitae = cv.id)" + " WHERE u.id_cidade IN (";

		for (Integer c : cidades) {
			sql += c + ",";
		}
		sql = sql.substring(0, sql.length() - 1);
		sql += ")" + " AND cv.id_categoria = ?" + " AND cv.id_curso = ?" + " AND cv.semestre = ?";

		if (filtro.getDeficiencia() != 2) {
			sql += " AND u.pessoa_pcd = " + filtro.getDeficiencia();
		}

		switch (filtro.getQualIdioma()) {
		case 1:
			sql += " AND u.nivel_ingles > 0";
			break;
		case 2:
			sql += " AND u.nivel_espanhol > 0";
			break;
		}

		sql += " AND (SELECT FROM_UNIXTIME((u.idade)/1000, '%Y')) BETWEEN ? AND ?";

		if (filtro.getSexo() != 0) {
			sql += " AND u.id_sexo = " + filtro.getSexo();
		}
		// experiência 1 - sim | 2- não
		if (filtro.getExperiencia() == 1) {
			sql += " AND cv.id IN (SELECT e.id_curriculum_vitae FROM experiencia e WHERE e.id_curriculum_vitae = cv.id)";
		}

		sql += " GROUP BY cv.id;";

		ps = con.prepareStatement(sql);
		ps.setInt(1, filtro.getArea());
		ps.setInt(2, filtro.getIdCurso());
		ps.setInt(3, filtro.getSemestre());
		ps.setInt(4, filtro.getIdade_fim());
		ps.setInt(5, filtro.getIdade_inicio());

		System.out.println(ps.toString());

		ResultSet rs = ps.executeQuery();
		List<Curriculo> curriculos = new ArrayList<>();
		while (rs.next()) {
			Curriculo cid = new Curriculo();
			cid.setId(rs.getInt("id"));
			cid.setNomeDoAluno(rs.getString("nomeAluno"));
			cid.setSemestre(rs.getInt("semestre"));
			cid.setCurso(rs.getString("nomeCurso"));
			cid.setEmail(rs.getString("email"));
			cid.setEstado(rs.getString("nomeEstado"));
			cid.setCidade(rs.getString("nomeCidade"));
			Integer id_curriculum_vitae = rs.getInt("idCurriculo");
			cid.setFormação(buscaFormacao(id_curriculum_vitae));
			cid.setExperiencia(buscaExperiencia(id_curriculum_vitae));
			cid.setSexo(rs.getInt("id_sexo") == 1 ? "Masculino" : "Feminino");
			cid.setDeficiencia(rs.getInt("pessoa_pcd") == 0 ? "" : "Pessoa com deficiencia");
			cid.setNivel_ingles(rs.getInt("nivel_ingles"));
			cid.setNivel_espanhol(rs.getInt("nivel_espanhol"));
			cid.setTelefone(rs.getString("numero_telefone"));
			cid.setIdade(rs.getLong("idade"));

			curriculos.add(cid);
			
			atualizarPeso(rs.getInt("u.id"));
		}
		return curriculos;
	}

	private void atualizarPeso(int idUsuario) {
		
		String sql=" UPDATE Usuario SET peso =?, nome=? WHERE idUsuario = ?;";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
        
		ps.setInt(1,);
		
		
		return ;
		
	}

	private List<Experiencia> buscaExperiencia(Integer id_curriculum_vitae) throws SQLException {
		String sql = "SELECT e.* FROM experiencia AS e "
				
				+ "INNER JOIN curriculum_vitae AS cv ON cv.id = e.id_curriculum_vitae "
				+ "WHERE e.id_curriculum_vitae = ?;";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, id_curriculum_vitae);

		ResultSet rs = ps.executeQuery();

		List<Experiencia> experiencias = new ArrayList<>();

		while (rs.next()) {
			Experiencia e = new Experiencia();
			e.setId(rs.getInt("id"));
			e.setNome(rs.getString("nome"));
			e.setData_inicio(rs.getLong("data_inicio"));
			e.setData_fim(rs.getLong("data_fim"));
			e.setCargo(rs.getString("cargo"));
			e.setEmpresa(rs.getString("empresa"));
			e.setFuncoes(rs.getString("funcoes"));
			e.setIdCurriculo(rs.getInt("id_curriculum_vitae"));

			experiencias.add(e);
		}
		return experiencias;

	}

	private List<Formacao> buscaFormacao(Integer id_curriculum_vitae) throws SQLException {
		String sql = "SELECT f.* FROM formacao AS f "
				+ "INNER JOIN curriculum_vitae AS cv ON cv.id = f.id_curriculum_vitae " + "WHERE cv.id = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id_curriculum_vitae);

		ResultSet rs = ps.executeQuery();

		List<Formacao> formacoes = new ArrayList<>();

		while (rs.next()) {
			Formacao f = new Formacao();
			f.setId(rs.getInt("id"));
			f.setNome(rs.getString("nome"));
			f.setData_fim(rs.getLong("data_fim"));
			f.setData_inicio(rs.getLong("data_inicio"));
			f.setEscola(rs.getString("escola"));
			f.setIdCurriculo(rs.getInt("id_curriculum_vitae"));

			formacoes.add(f);
		}
		return formacoes;
	}
}
