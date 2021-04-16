package br.com.proway.senior.fechamentoFolha;

import java.util.ArrayList;

public final class Colaborador extends Pessoa {	
	
	private double salario;
	private ArrayList<Folha> totalFolhas = new ArrayList<Folha>();
	private ArrayList<String> dependentes = new ArrayList<String>();	
	private Ponto ponto;
	
	public Colaborador(String nome, int id, double salario) {
		super(nome, id);				
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

	public void addTotalFolhas(Folha f) {
		this.totalFolhas.add(f);
	}

	public ArrayList<String> getDependentes() {
		return dependentes;
	}

	public void setDependentes(ArrayList<String> dependentes) {
		this.dependentes = dependentes;
	}

	public Ponto getPonto() {
		return ponto;
	}

	public void setPonto(Ponto ponto) {
		this.ponto = ponto;
	}
	
}
