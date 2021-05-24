package br.com.proway.senior.dto;

import br.com.proway.senior.model.Folha;

/**
 * Classe que instancia os valores da folha, do ponto, do colaborador, 
 * da bonificação e do ponto.
 * 
 * @author Sabrina
 * @author Samuel
 * @author Jonata
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
	 * Construtor Folha DTO construida a partir da folha, do colaborador, da bonificação,
	 * do PLR e do ponto
	 */
	public FolhaDto(Folha folha) {
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
		
	}

	public FolhaDto() {
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
	
}
