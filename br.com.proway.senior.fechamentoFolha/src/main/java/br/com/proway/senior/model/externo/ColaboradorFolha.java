package br.com.proway.senior.model.externo;

import java.util.ArrayList;

import br.com.proway.senior.model.externo.interfaces.IColaboradorFolha;

/**
 * ColaboradorFolha
 * 
 * Objeto conténdo os dados necessários de um colaborador para utilização interna na
 * criação de uma folha.
 * 
 * @author sprint3
 */
public final class ColaboradorFolha implements IColaboradorFolha {

	private int id;
	private String nome;
	private String email;
	private boolean isValeTransporte;
	private double planoSaudeMensalidade;
	private double planoSaudeCooparticipacao;
	private ArrayList<String> dependentes;

	public ColaboradorFolha(int id, boolean isValeTransporte, double planoSaudeMensalidade,
			double planoSaudeCooparticipacao) {
		this.id = id;
		this.isValeTransporte = isValeTransporte;
		this.planoSaudeMensalidade = planoSaudeMensalidade;
		this.planoSaudeCooparticipacao = planoSaudeCooparticipacao;
		this.dependentes = new ArrayList<String>();
	}

//	public ColaboradorFolha(int id, boolean isValeTransporte, double planoSaudeMensalidade,
//			double planoSaudeCooparticipacao, ArrayList<String> dependentes) {
//		this.id = id;
//		this.isValeTransporte = isValeTransporte;
//		this.planoSaudeMensalidade = planoSaudeMensalidade;
//		this.planoSaudeCooparticipacao = planoSaudeCooparticipacao;
//		this.dependentes = dependentes;
//	}

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

	public int getNumeroDeDependentes() {
		if (dependentes.isEmpty()) {
			return 0;
		} else {
			return dependentes.size();
		}
	}
}
