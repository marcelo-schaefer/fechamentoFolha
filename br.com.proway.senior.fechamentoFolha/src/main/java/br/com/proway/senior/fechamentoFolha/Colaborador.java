package br.com.proway.senior.fechamentoFolha;

import java.util.ArrayList;

public final class Colaborador extends Pessoa {	
	
	private double salario;
	private ArrayList<Folha> totalFolhas = new ArrayList<Folha>();
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

	public ArrayList<Folha> getTotalFolhas() {
		return totalFolhas;
	}

	/**
	 * Adiciona uma folha do usuário
	 * 
	 * Adiciona uma folha ao ArrayList de folhas do usuário
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
	 * Adiciona dependente ao usuário
	 * 
	 * Adiciona um dependente ao ArrayList de dependentes do usuário
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
