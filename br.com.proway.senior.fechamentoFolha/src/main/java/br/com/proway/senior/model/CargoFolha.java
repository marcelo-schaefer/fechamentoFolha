package br.com.proway.senior.model;

public class CargoFolha implements ICargoFolha {

	private double salarioBase;
	private double valorBonificacao;
	private double percentualInsalubridade;

	/**
	 * 
	 * @param salarioBase
	 * @param valorBonificacao
	 * @param percentualInsalubridade
	 */
	public CargoFolha(double salarioBase, double valorBonificacao, double percentualInsalubridade) {
		this.salarioBase = salarioBase;
		this.valorBonificacao = valorBonificacao;
		this.percentualInsalubridade = percentualInsalubridade;
	}
	
	public double getSalarioBase() {
		return salarioBase;
	}

	public double getPercentualInsalubridade() {
		return percentualInsalubridade;
	}


	public double getValorBonificacao() {
		return valorBonificacao;
	}

}
