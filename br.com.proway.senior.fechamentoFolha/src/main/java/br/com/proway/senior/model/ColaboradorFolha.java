package br.com.proway.senior.model;

import java.util.ArrayList;

public final class ColaboradorFolha implements InterfaceColaboradorFolha {

	private int id;
	private String nome;
	private String email;
	private boolean isValeTransporte;
	private double planoSaudeMensalidade;
	private double planoSaudeCooparticipacao;
	private ArrayList<String> dependentes = new ArrayList<String>();

	public ColaboradorFolha() {}

	public ColaboradorFolha(int id, boolean isValeTransporte,
			double planoSaudeMensalidade, double planoSaudeCooparticipacao, ArrayList<String> dependentes) {
		this.id = id;
		this.isValeTransporte = isValeTransporte;
		this.planoSaudeMensalidade = planoSaudeMensalidade;
		this.planoSaudeCooparticipacao = planoSaudeCooparticipacao;
		this.dependentes = dependentes;
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

	public boolean isValeTransporte() {
		return isValeTransporte;
	}

	public void setValeTransporte(boolean isValeTransporte) {
		this.isValeTransporte = isValeTransporte;
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

	public boolean getValeTransporte() {
		return isValeTransporte;
	}

	public double getPlanoSaudeMensalidade() {
		return planoSaudeMensalidade;
	}

	public void setPlanoSaudeMensalidade(double planoSaudeMensalidade) {
		this.planoSaudeMensalidade = planoSaudeMensalidade;
	}

	public double getPlanoSaudeCooparticipacao() {
		return planoSaudeCooparticipacao;
	}

	public void setPlanoSaudeCooparticipacao(double planoSaudeCooparticipacao) {
		this.planoSaudeCooparticipacao = planoSaudeCooparticipacao;
	}

}
