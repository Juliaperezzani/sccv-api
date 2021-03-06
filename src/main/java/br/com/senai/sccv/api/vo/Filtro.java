package br.com.senai.sccv.api.vo;

import java.util.List;

public class Filtro {

	private String nomeFiltro;
	private Integer id;
	private Integer idEmpresa;
	private Integer idAdm;
	private Integer idCurso; // vai
	private Integer semestre; // vai
	private List<Integer> idCidade; // vai
	private Integer experiencia; // 0=indiferente 1=SIM 2= N�O
	private Integer sexo; // vai 0=indiferente 1=MACHO 2= MULHER
	private Integer qualIdioma;// vai 0=indiferente 1=INGLES 2= ESPANHOL
	private Integer nvIdioma;
	private Integer deficiencia;// vai 0=indiferente 1=SIM 2= N�O
	private Integer idade_inicio;
	private Integer idade_fim; // VER SE JA DA PRA SETAR O 18 E 40 AQUI PRA PODER MANDAR ELES DIRETO
	private Integer idEstado;
	private Integer area;

	public Integer getNvIdioma() {
		return nvIdioma;
	}

	public void setNvIdioma(Integer nvIdioma) {
		this.nvIdioma = nvIdioma;
	}

	public String getNomeFiltro() {
		return nomeFiltro;
	}

	public void setNomeFiltro(String nomeFiltro) {
		this.nomeFiltro = nomeFiltro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Integer getIdAdm() {
		return idAdm;
	}

	public void setIdAdm(Integer idAdm) {
		this.idAdm = idAdm;
	}

	public Integer getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	public Integer getSemestre() {
		return semestre;
	}

	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}

	public List<Integer> getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(List<Integer> idCidade) {
		this.idCidade = idCidade;
	}

	public Integer getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(Integer experiencia) {
		this.experiencia = experiencia;
	}

	public Integer getSexo() {
		return sexo;
	}

	public void setSexo(Integer sexo) {
		this.sexo = sexo;
	}

	public Integer getQualIdioma() {
		return qualIdioma;
	}

	public void setQualIdioma(Integer qualIdioma) {
		this.qualIdioma = qualIdioma;
	}

	public Integer getDeficiencia() {
		return deficiencia;
	}

	public void setDeficiencia(Integer deficiencia) {
		this.deficiencia = deficiencia;
	}

	public Integer getIdade_inicio() {
		return idade_inicio;
	}

	public void setIdade_inicio(Integer idade_inicio) {
		this.idade_inicio = idade_inicio;
	}

	public Integer getIdade_fim() {
		return idade_fim;
	}

	public void setIdade_fim(Integer idade_fim) {
		this.idade_fim = idade_fim;
	}

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

}