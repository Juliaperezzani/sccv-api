package br.com.senai.sccv.api.vo;

import java.util.List;

public class Filtro {

	private String nomeFiltro;
	private Integer id;
	private Integer idCurso; 
	private Integer semestre; 
	private List<Integer> idCidade; 
	private Integer experiencia; // 0=indiferente 1=SIM 2= NÃO
	private Integer sexo; // vai 0=indiferente 1=MACHO 2= MULHER      FOOOOOOOOOOOI
	private Integer deficiencia;// vai 0=indiferente 1=SIM 2= NÃO     FOOOOOOOOOOOI
	private Integer idade_inicio;
	private Integer idade_fim; 
	private Integer area;

	// nome, idade inicoon idade fim area


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getNomeFiltro() {
		return nomeFiltro;
	}

	public void setNomeFiltro(String nomeFiltro) {
		this.nomeFiltro = nomeFiltro;
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



	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
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

	public Integer getDeficiencia() {
		return deficiencia;
	}

	public void setDeficiencia(Integer deficiencia) {
		this.deficiencia = deficiencia;
	}

}
