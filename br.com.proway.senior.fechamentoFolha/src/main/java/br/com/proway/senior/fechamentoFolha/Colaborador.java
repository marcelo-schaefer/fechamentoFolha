package br.com.proway.senior.fechamentoFolha;

import java.util.ArrayList;

public final class Colaborador extends Pessoa {	
	
	private double salario;
	private ArrayList<FolhaProvisoria> totalFolhas = new ArrayList<FolhaProvisoria>();
	private ArrayList<String> dependentes = new ArrayList<String>();	
	private Ponto ponto;
	
	public Colaborador(String nome, int id, String email, double salario) {
		super(nome, id, email);				
		this.salario = salario;				
	}	

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public ArrayList<FolhaProvisoria> getTotalFolhas() {
		return totalFolhas;
	}

	/**
	 * Cadastra Folha
	 * 
	 * Adiciona uma Folha do Colaborador em sua lista de folhas totais
	 * 
	 * @param f; Um objeto da classe Folha
	 */
	public void addTotalFolhas(FolhaProvisoria f) {
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
