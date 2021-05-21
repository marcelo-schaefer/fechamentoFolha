package br.com.proway.senior.dto;


import br.com.proway.senior.model.Bonificacao;
import br.com.proway.senior.model.Folha;
import br.com.proway.senior.model.Plr;
import br.com.proway.senior.model.externo.ColaboradorFolha;
import br.com.proway.senior.model.externo.interfaces.IPontoFolha;

/**
 * Classe que instancia os valores da folha, do ponto, do colaborador, 
 * da bonificação e do ponto.
 * 
 * @author Sabrina
 * @author Samuel
 * @author Jhonata
 * @author Guilherme
 * @author David
 *
 */
public class FolhaDto {

	/**
	 * Valores da folha
	 */
	private double valorHorasTrabalhadas;
	private double valorHorasExtras;
	private double valorInss;
	private double valorImpostoDeRenda;
	private double valorPlanoSaude;
	private double valorValeTransporte;
	private double salarioBruto = 0;
	private double salarioLiquido;
	private double valorFGTS;
	private double bonificacaoColaborador;
	private double plr;
	
	
	/**
	 * Valores do ponto
	 */
	private double horasTrabalhadas;
	private double horasExtra;
	private double horasFaltas;
	
	
	/**
	 * Valores Colaborador
	 */
	private String nome;
	private String email;
	private boolean isValeTransporte;
	private double planoSaudeMensalidade;
	
	/**
	 * Construtor Folha DTO construida a partir da folha, do colaborador, da bonificação,
	 * do PLR e do ponto
	 */
	public FolhaDto(Folha folha,IPontoFolha ponto,Bonificacao bonificacao, 
			Plr plr, ColaboradorFolha colaborador) {
		//Folha Ponto
		this.horasTrabalhadas = ponto.getHorasTrabalhadas();
		this.horasExtra = ponto.getHorasExtra();
		this.horasFaltas = ponto.getHorasFaltas();
		
		//Folha
		this.valorHorasTrabalhadas = folha.getValorHorasTrabalhadas();
		this.valorHorasExtras = folha.getValorHorasExtras();
		this.valorInss = folha.getValorInss();
		this.valorImpostoDeRenda = folha.getValorImpostoDeRenda();
		this.valorPlanoSaude = folha.getValorPlanoSaude();
		this.valorValeTransporte = folha.getValorValeTransporte();
		this.salarioBruto = folha.getSalarioBruto();
		this.salarioLiquido = folha.getSalarioLiquido();
		this.valorFGTS = folha.getValorFGTS();
		
		//Bonificacao
		this.bonificacaoColaborador = bonificacao.getPorcentagemBonificacaoColaborador();
		
		//Plr
		this.plr = plr.getValorPlr();
		
		//Colaborador 
		this.nome = colaborador.getNome();
		this.email = colaborador.getEmail();
		this.isValeTransporte = colaborador.getValeTransporte();
		this.planoSaudeMensalidade = colaborador.getPlanoSaudeMensalidade();
		
	}

	public double getValorHorasTrabalhadas() {
		return valorHorasTrabalhadas;
	}

	public double getValorHorasExtras() {
		return valorHorasExtras;
	}

	public double getValorInss() {
		return valorInss;
	}

	public double getValorImpostoDeRenda() {
		return valorImpostoDeRenda;
	}

	public double getValorPlanoSaude() {
		return valorPlanoSaude;
	}

	public double getValorValeTransporte() {
		return valorValeTransporte;
	}

	public double getSalarioBruto() {
		return salarioBruto;
	}

	public double getSalarioLiquido() {
		return salarioLiquido;
	}

	public double getValorFGTS() {
		return valorFGTS;
	}

	public double getBonificacaoColaborador() {
		return bonificacaoColaborador;
	}

	public double getPlr() {
		return plr;
	}

	public double getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public double getHorasExtra() {
		return horasExtra;
	}

	public double getHorasFaltas() {
		return horasFaltas;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public boolean isValeTransporte() {
		return isValeTransporte;
	}

	public double getPlanoSaudeMensalidade() {
		return planoSaudeMensalidade;
	}
	
}
