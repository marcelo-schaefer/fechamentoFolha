package br.com.proway.senior.model;

import java.util.ArrayList;

public final class ColaboradorFolha {

	private double salario;
	private ArrayList<Folha> totalFolhas = new ArrayList<Folha>();
	private ArrayList<String> dependentes = new ArrayList<String>();
	private Ponto ponto;
	private int id;
	private String nome;
	private String email;

	public ColaboradorFolha(String nome, int id, String email, double salario) {
		this.nome = nome;
		this.id = id;
		this.email = email;
		this.salario = salario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public ArrayList<Folha> getTotalFolhas() {
		return totalFolhas;
	}

	/**
	 * Cadastra Folha
	 * 
	 * Adiciona uma Folha do Colaborador em sua lista de folhas totais
	 * 
	 * @param f; Um objeto da classe Folha
	 */
	public void addTotalFolhas(Folha f) {
		this.totalFolhas.add(f);
	}

	public ArrayList<String> getDependentes() {
		return dependentes;
	}

	public void setDependentes(ArrayList<String> dependentes) {
		this.dependentes = dependentes;
	}

	/**
	 * Cadastra dependente
	 * 
	 * Adiciona um dependente do Colaborador em sua lista de dependentes totais
	 * 
	 * @param p; Nome do dependente
	 */
	public void addDependentes(String p) {
		this.dependentes.add(p);
	}

	public Ponto getPonto() {
		return ponto;
	}

	public void setPonto(Ponto ponto) {
		this.ponto = ponto;
	}

}
