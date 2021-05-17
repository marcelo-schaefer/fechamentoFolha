package br.com.proway.senior.model.externo;

import java.util.ArrayList;

import br.com.proway.senior.model.externo.interfaces.IColaboradorFolha;

/**
 * Pega dados do Colaborador.
 * 
 * Contem os dados necessarios de um Colaborador para a criacao de uma 
 * folha{@link Folha}.
 * 
 * @author sprint3
 * 
 * Sprint 5:
 * @author Leonardo Felipe Silva <felipeleao217@gmail.com>;
 * @author Bruna Carvalho <sh4323202@gmail.com>;
 * @author Leonardo Pereira <leonardopereirajr@gmail.com>;
 * @author Sabrina Schmidt <sabrinaschmidt335@gmail.com>;
 * @author Lucas Nunes <lucasnunes.ln365@gmail.com>.
 *  
 */
public final class ColaboradorFolha implements IColaboradorFolha {

	private int id;
	private String nome;
	private String email;
	private boolean isValeTransporte;
	private double planoSaudeMensalidade;
	private double planoSaudeCooparticipacao;
	private ArrayList<String> dependentes;
	private double valorFGTS;
	

	public ColaboradorFolha(int id, boolean isValeTransporte, double planoSaudeMensalidade,
			double planoSaudeCooparticipacao, double valorFGTS) {
		this.id = id;
		this.isValeTransporte = isValeTransporte;
		this.planoSaudeMensalidade = planoSaudeMensalidade;
		this.planoSaudeCooparticipacao = planoSaudeCooparticipacao;
		this.valorFGTS = valorFGTS;
		this.dependentes = new ArrayList<String>();
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
	
	public double getValorFGTS() {
		return valorFGTS;
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
