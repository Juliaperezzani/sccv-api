package br.com.senai.sccv.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.senai.sccv.api.config.ConnectionDB;
import br.com.senai.sccv.api.entities.Usuario;
import br.com.senai.sccv.api.utils.FormatarCPFouRGtoString;
import br.com.senai.sccv.api.utils.StringToMD5;

public class UsuarioDao {

	private Connection conn;

	public UsuarioDao() {
		try {
			conn = ConnectionDB.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean updateUsuarioModoAdministrador(Usuario u) throws SQLException {
		String sql = "UPDATE usuario SET email = ?, id_status = ? WHERE usuario.id = ?;";

		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setString(1, u.getEmail());
		ps.setInt(2, u.getStatus().getId());
		ps.setInt(3, u.getId());

		return ps.executeUpdate() > 0;
	}

	public boolean updateUsuario(Usuario u) throws SQLException {
		String sql = "UPDATE usuario SET nome = ?, id_status = ?, email = ?, senha = ?, idade = ?, cpf = ?, rg = ?, id_curso = ?, id_turma = ?, id_cidade = ?, id_estado = ?, id_categoria = ?, id_sexo = ?, peso = ?, nivel_ingles = ?, nivel_espanhol = ?, pessoa_pcd = ?, numero_telefone = ? WHERE usuario.id = ?;";

		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setString(1, u.getNome());
		ps.setInt(2, u.getStatus().getId());
		ps.setString(3, u.getEmail());
		ps.setString(4, StringToMD5.convertStringToMd5(u.getSenha()));
		ps.setLong(5, u.getIdade());
		ps.setString(6, FormatarCPFouRGtoString.format(u.getCpf()));
		ps.setString(7, FormatarCPFouRGtoString.format(u.getRg()));
		ps.setInt(8, u.getCurso().getId());
		ps.setInt(9, u.getTurma().getId());
		ps.setInt(10, u.getCidade().getId());
		ps.setInt(11, u.getEstado().getId());
		ps.setInt(12, u.getCategoria().getId());
		ps.setInt(13, u.getSexo().getId());
		ps.setInt(14, u.getPeso());
		ps.setInt(15, u.getNivel_ingles());
		ps.setInt(16, u.getNivel_espanhol());
		ps.setInt(17, u.getPessoa_pcd());
		ps.setString(18, u.getNumero_telefone());
		ps.setInt(19, u.getId());

		return ps.executeUpdate() > 0;
	}

	public boolean inserirUsuario(Usuario u) throws SQLException {
		String sql = "INSERT INTO usuario(nome, email, senha, idade, cpf, rg, id_curso, id_turma, id_cidade, id_estado, id_categoria, id_sexo, nivel_ingles, nivel_espanhol, pessoa_pcd, numero_telefone)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setString(1, u.getNome());
		ps.setString(2, u.getEmail());
		ps.setString(3, StringToMD5.convertStringToMd5(u.getSenha()));
		ps.setLong(4, u.getIdade());
		ps.setString(5, FormatarCPFouRGtoString.format(u.getCpf()));
		ps.setString(6, FormatarCPFouRGtoString.format(u.getRg()));
		ps.setInt(7, u.getCurso().getId());
		ps.setInt(8, u.getTurma().getId());
		ps.setInt(9, u.getCidade().getId());
		ps.setInt(10, u.getEstado().getId());
		ps.setInt(11, u.getCategoria().getId());
		ps.setInt(12, u.getSexo().getId());
		ps.setInt(13, u.getNivel_ingles());
		ps.setInt(14, u.getNivel_espanhol());
		ps.setInt(15, u.getPessoa_pcd());
		ps.setString(16, u.getNumero_telefone());

		return ps.executeUpdate() > 0;
	};

	public Usuario buscaUsuarioPorEmail(String email) throws SQLException {
		String sql = "SELECT u.*, c.nome AS nomeCidade, e.nome AS nomeEstado, st.nome AS nomeStatus, cur.nome AS nomeCurso, tur.nome AS nomeTurma, cat.nome AS nomeCategoria, s.nome AS nomeSexo FROM usuario AS u "
				+ "INNER JOIN cidade AS c ON c.id = u.id_cidade " + "INNER JOIN estado AS e ON e.id = u.id_estado "
				+ "INNER JOIN status_ AS st ON st.id = u.id_status " + "INNER JOIN curso AS cur ON cur.id = u.id_curso "
				+ "INNER JOIN turma AS tur ON tur.id = u.id_turma "
				+ "INNER JOIN categoria AS cat ON cat.id = u.id_categoria "
				+ "INNER JOIN sexo AS s ON s.id = u.id_sexo " + "WHERE u.email = ?;";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, email);

		ResultSet rs = ps.executeQuery();

		Usuario u = null;
		if (rs.next()) {
			u = new Usuario();

			u.setId(rs.getInt("id"));
			u.setNome(rs.getString("nome"));
			u.setEmail(rs.getString("email"));
			u.setSenha(rs.getString("senha"));
			u.setIdade(rs.getLong("idade"));
			u.setCpf(rs.getString("cpf"));
			u.setRg(rs.getString("rg"));
			u.getStatus().setId(rs.getInt("id_status"));
			u.getStatus().setNomeFiltro(rs.getString("nomeStatus"));
			u.getCurso().setId(rs.getInt("id_curso"));
			u.getCurso().setNomeFiltro(rs.getString("nomeCurso"));
			u.getTurma().setId(rs.getInt("id_turma"));
			u.getTurma().setNomeFiltro(rs.getString("nomeTurma"));
			u.getCidade().setId(rs.getInt("id_cidade"));
			u.getCidade().setNomeFiltro(rs.getString("nomeCidade"));
			u.getEstado().setId(rs.getInt("id_estado"));
			u.getEstado().setNomeFiltro(rs.getString("nomeEstado"));
			u.getCategoria().setId(rs.getInt("id_categoria"));
			u.getCategoria().setNomeFiltro(rs.getString("nomeCategoria"));
			u.getSexo().setId(rs.getInt("id_sexo"));
			u.getSexo().setNomeFiltro(rs.getString("nomeSexo"));
			u.setPeso(rs.getInt("peso"));
			u.setNivel_ingles(rs.getInt("nivel_ingles"));
			u.setNivel_espanhol(rs.getInt("nivel_espanhol"));
			u.setPessoa_pcd(rs.getInt("pessoa_pcd"));
			u.setNumero_telefone(rs.getString("numero_telefone"));

		}
		return u;
	}

	public Usuario buscaUsuarioPorCpf(String cpf) throws SQLException {
		String sql = "SELECT u.*, c.nome AS nomeCidade, e.nome AS nomeEstado, st.nome AS nomeStatus, cur.nome AS nomeCurso, tur.nome AS nomeTurma, cat.nome AS nomeCategoria, s.nome AS nomeSexo FROM usuario AS u "
				+ "INNER JOIN cidade AS c ON c.id = u.id_cidade " + "INNER JOIN estado AS e ON e.id = u.id_estado "
				+ "INNER JOIN status_ AS st ON st.id = u.id_status " + "INNER JOIN curso AS cur ON cur.id = u.id_curso "
				+ "INNER JOIN turma AS tur ON tur.id = u.id_turma "
				+ "INNER JOIN categoria AS cat ON cat.id = u.id_categoria "
				+ "INNER JOIN sexo AS s ON s.id = u.id_sexo " + "WHERE u.cpf = ?;";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, FormatarCPFouRGtoString.format(cpf));

		ResultSet rs = ps.executeQuery();

		Usuario u = null;
		if (rs.next()) {
			u = new Usuario();

			u.setId(rs.getInt("id"));
			u.setNome(rs.getString("nome"));
			u.setEmail(rs.getString("email"));
			u.setSenha(rs.getString("senha"));
			u.setIdade(rs.getLong("idade"));
			u.setCpf(rs.getString("cpf"));
			u.setRg(rs.getString("rg"));
			u.getStatus().setId(rs.getInt("id_status"));
			u.getStatus().setNomeFiltro(rs.getString("nomeStatus"));
			u.getCurso().setId(rs.getInt("id_curso"));
			u.getCurso().setNomeFiltro(rs.getString("nomeCurso"));
			u.getTurma().setId(rs.getInt("id_turma"));
			u.getTurma().setNomeFiltro(rs.getString("nomeTurma"));
			u.getCidade().setId(rs.getInt("id_cidade"));
			u.getCidade().setNomeFiltro(rs.getString("nomeCidade"));
			u.getEstado().setId(rs.getInt("id_estado"));
			u.getEstado().setNomeFiltro(rs.getString("nomeEstado"));
			u.getCategoria().setId(rs.getInt("id_categoria"));
			u.getCategoria().setNomeFiltro(rs.getString("nomeCategoria"));
			u.getSexo().setId(rs.getInt("id_sexo"));
			u.getSexo().setNomeFiltro(rs.getString("nomeSexo"));
			u.setPeso(rs.getInt("peso"));
			u.setNivel_ingles(rs.getInt("nivel_ingles"));
			u.setNivel_espanhol(rs.getInt("nivel_espanhol"));
			u.setPessoa_pcd(rs.getInt("pessoa_pcd"));
			u.setNumero_telefone(rs.getString("numero_telefone"));
		}
		return u;
	}

	public List<Usuario> listarUsuario() throws SQLException {
		String sql = "SELECT u.*, s.nome AS nomeSexo, c.nome AS nomeCidade, e.nome AS nomeEstado, sts.nome AS nomeStatus, ca.nome AS nomeCategoria, cur.nome AS nomeCurso, tur.nome AS nomeTurma FROM usuario AS u "
				+ "INNER JOIN sexo AS s ON s.id = u.id_sexo " + "INNER JOIN cidade AS c ON c.id = u.id_cidade "
				+ "INNER JOIN estado AS e ON e.id = u.id_estado " + "INNER JOIN status_ AS sts ON sts.id = u.id_status "
				+ "INNER JOIN categoria AS ca ON ca.id = u.id_categoria "
				+ "INNER JOIN curso AS cur ON cur.id = u.id_curso " + "INNER JOIN turma AS tur ON tur.id = u.id_turma;";

		PreparedStatement ps = conn.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		List<Usuario> lista = new ArrayList<Usuario>();

		while (rs.next()) {
			Usuario u = new Usuario();

			u.setId(rs.getInt("id"));
			u.setNome(rs.getString("nome"));
			u.setEmail(rs.getString("email"));
			u.setSenha(rs.getString("senha"));
			u.setIdade(rs.getLong("idade"));
			u.setCpf(rs.getString("cpf"));
			u.setRg(rs.getString("rg"));
			u.setPeso(rs.getInt("peso"));
			u.getSexo().setId(rs.getInt("id_sexo"));
			u.getSexo().setNomeFiltro(rs.getString("nomeSexo"));
			u.getCidade().setId(rs.getInt("id_cidade"));
			u.getCidade().setNomeFiltro(rs.getString("nomeCidade"));
			u.getEstado().setId(rs.getInt("id_estado"));
			u.getEstado().setNomeFiltro(rs.getString("nomeEstado"));
			u.getStatus().setId(rs.getInt("id_status"));
			u.getStatus().setNomeFiltro(rs.getString("nomeStatus"));
			u.getCategoria().setId(rs.getInt("id_categoria"));
			u.getCategoria().setNomeFiltro(rs.getString("nomeCategoria"));
			u.getCurso().setId(rs.getInt("id_curso"));
			u.getCurso().setNomeFiltro(rs.getString("nomeCurso"));
			u.getTurma().setId(rs.getInt("id_turma"));
			u.getTurma().setNomeFiltro(rs.getString("nomeTurma"));
			u.setNivel_ingles(rs.getInt("nivel_ingles"));
			u.setNivel_espanhol(rs.getInt("nivel_espanhol"));
			u.setPessoa_pcd(rs.getInt("pessoa_pcd"));
			u.setNumero_telefone(rs.getString("numero_telefone"));

			lista.add(u);
		}
		return lista;
	}

	public List<Usuario> listarUsuario(String nome) throws SQLException {
		String sql = "SELECT u.*, s.nome AS nomeSexo, c.nome AS nomeCidade, e.nome AS nomeEstado, sts.nome AS nomeStatus, ca.nome AS nomeCategoria, cur.nome AS nomeCurso, tur.nome AS nomeTurma FROM usuario AS u "
				+ "INNER JOIN sexo AS s ON s.id = u.id_sexo " + "INNER JOIN cidade AS c ON c.id = u.id_cidade "
				+ "INNER JOIN estado AS e ON e.id = u.id_estado " + "INNER JOIN status_ AS sts ON sts.id = u.id_status "
				+ "INNER JOIN categoria AS ca ON ca.id = u.id_categoria "
				+ "INNER JOIN curso AS cur ON cur.id = u.id_curso " + "INNER JOIN turma AS tur ON tur.id = u.id_turma "
				+ "WHERE u.nome like ?;";

		if (nome.equals("")) {
			return listarUsuario();
		}

		String local = "%" + nome + "%";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, local);

		ResultSet rs = ps.executeQuery();
		List<Usuario> lista = new ArrayList<Usuario>();

		while (rs.next()) {
			Usuario u = new Usuario();

			u.setId(rs.getInt("id"));
			u.setNome(rs.getString("nome"));
			u.setEmail(rs.getString("email"));
			u.setSenha(rs.getString("senha"));
			u.setIdade(rs.getLong("idade"));
			u.setCpf(rs.getString("cpf"));
			u.setRg(rs.getString("rg"));
			u.setPeso(rs.getInt("peso"));
			u.getSexo().setId(rs.getInt("id_sexo"));
			u.getSexo().setNomeFiltro(rs.getString("nomeSexo"));
			u.getCidade().setId(rs.getInt("id_cidade"));
			u.getCidade().setNomeFiltro(rs.getString("nomeCidade"));
			u.getEstado().setId(rs.getInt("id_estado"));
			u.getEstado().setNomeFiltro(rs.getString("nomeEstado"));
			u.getStatus().setId(rs.getInt("id_status"));
			u.getStatus().setNomeFiltro(rs.getString("nomeStatus"));
			u.getCategoria().setId(rs.getInt("id_categoria"));
			u.getCategoria().setNomeFiltro(rs.getString("nomeCategoria"));
			u.getCurso().setId(rs.getInt("id_curso"));
			u.getCurso().setNomeFiltro(rs.getString("nomeCurso"));
			u.getTurma().setId(rs.getInt("id_turma"));
			u.getTurma().setNomeFiltro(rs.getString("nomeTurma"));
			u.setPessoa_pcd(rs.getInt("pessoa_pcd"));
			u.setNumero_telefone(rs.getString("numero_telefone"));

			lista.add(u);
		}
		return lista;
	}

	public List<Usuario> listarUsuarioCpf(String nome) throws SQLException {
		String sql = "SELECT u.*, s.nome AS nomeSexo, c.nome AS nomeCidade, e.nome AS nomeEstado, sts.nome AS nomeStatus, ca.nome AS nomeCategoria, cur.nome AS nomeCurso, tur.nome AS nomeTurma FROM usuario AS u "
				+ "INNER JOIN sexo AS s ON s.id = u.id_sexo " + "INNER JOIN cidade AS c ON c.id = u.id_cidade "
				+ "INNER JOIN estado AS e ON e.id = u.id_estado " + "INNER JOIN status_ AS sts ON sts.id = u.id_status "
				+ "INNER JOIN categoria AS ca ON ca.id = u.id_categoria "
				+ "INNER JOIN curso AS cur ON cur.id = u.id_curso " + "INNER JOIN turma AS tur ON tur.id = u.id_turma "
				+ "WHERE u.cpf like ?;";

		String local = nome + "%";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, local);

		ResultSet rs = ps.executeQuery();
		List<Usuario> lista = new ArrayList<Usuario>();

		while (rs.next()) {
			Usuario u = new Usuario();

			u.setId(rs.getInt("id"));
			u.setNome(rs.getString("nome"));
			u.setEmail(rs.getString("email"));
			u.setSenha(rs.getString("senha"));
			u.setIdade(rs.getLong("idade"));
			u.setCpf(rs.getString("cpf"));
			u.setRg(rs.getString("rg"));
			u.setPeso(rs.getInt("peso"));
			u.getSexo().setId(rs.getInt("id_sexo"));
			u.getSexo().setNomeFiltro(rs.getString("nomeSexo"));
			u.getCidade().setId(rs.getInt("id_cidade"));
			u.getCidade().setNomeFiltro(rs.getString("nomeCidade"));
			u.getEstado().setId(rs.getInt("id_estado"));
			u.getEstado().setNomeFiltro(rs.getString("nomeEstado"));
			u.getStatus().setId(rs.getInt("id_status"));
			u.getStatus().setNomeFiltro(rs.getString("nomeStatus"));
			u.getCategoria().setId(rs.getInt("id_categoria"));
			u.getCategoria().setNomeFiltro(rs.getString("nomeCategoria"));
			u.getCurso().setId(rs.getInt("id_curso"));
			u.getCurso().setNomeFiltro(rs.getString("nomeCurso"));
			u.getTurma().setId(rs.getInt("id_turma"));
			u.getTurma().setNomeFiltro(rs.getString("nomeTurma"));
			u.setNivel_ingles(rs.getInt("nivel_ingles"));
			u.setNivel_espanhol(rs.getInt("nivel_espanhol"));
			u.setPessoa_pcd(rs.getInt("pessoa_pcd"));
			u.setNumero_telefone(rs.getString("numero_telefone"));
			lista.add(u);
		}
		return lista;
	}
}
