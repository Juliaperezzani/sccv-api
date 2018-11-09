package br.com.senai.sccv.api.entities;

import br.com.senai.sccv.api.vo.Filtro;

public class Usuario {

	public Usuario() {
		status = new Filtro();
		curso = new Filtro();
		turma = new Filtro();
		cidade = new Filtro();
		estado = new Filtro();
		categoria = new Filtro();
		sexo = new Filtro();
		peso = new Integer(0);

	}

	private Integer id;
	private String nome;
	private String email;
	private String senha;
	private Long idade;
	private String cpf;
	private String rg;
	private Integer peso;
	private Filtro status;
	private Filtro curso;
	private Filtro turma;
	private Filtro cidade;
	private Filtro estado;
	private Filtro categoria;
	private Filtro sexo;
	private Integer nivel_ingles;
	private Integer nivel_espanhol;
	private Integer pessoa_pcd;
	private String numero_telefone;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getIdade() {
		return idade;
	}

	public void setIdade(Long idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public Filtro getStatus() {
		return status;
	}

	public void setStatus(Filtro status) {
		this.status = status;
	}

	public Filtro getCurso() {
		return curso;
	}

	public void setCurso(Filtro curso) {
		this.curso = curso;
	}

	public Filtro getTurma() {
		return turma;
	}

	public void setTurma(Filtro turma) {
		this.turma = turma;
	}

	public Filtro getCidade() {
		return cidade;
	}

	public void setCidade(Filtro cidade) {
		this.cidade = cidade;
	}

	public Filtro getEstado() {
		return estado;
	}

	public void setEstado(Filtro estado) {
		this.estado = estado;
	}

	public Filtro getCategoria() {
		return categoria;
	}

	public void setCategoria(Filtro categoria) {
		this.categoria = categoria;
	}

	public Filtro getSexo() {
		return sexo;
	}

	public void setSexo(Filtro sexo) {
		this.sexo = sexo;
	}

	public Integer getNivel_ingles() {
		return nivel_ingles;
	}

	public void setNivel_ingles(Integer nivel_ingles) {
		this.nivel_ingles = nivel_ingles;
	}

	public Integer getNivel_espanhol() {
		return nivel_espanhol;
	}

	public void setNivel_espanhol(Integer nivel_espanhol) {
		this.nivel_espanhol = nivel_espanhol;
	}

	public Integer getPessoa_pcd() {
		return pessoa_pcd;
	}

	public void setPessoa_pcd(Integer pessoa_pcd) {
		this.pessoa_pcd = pessoa_pcd;
	}

	public String getNumero_telefone() {
		return numero_telefone;
	}

	public void setNumero_telefone(String numero_telefone) {
		this.numero_telefone = numero_telefone;
	}

}