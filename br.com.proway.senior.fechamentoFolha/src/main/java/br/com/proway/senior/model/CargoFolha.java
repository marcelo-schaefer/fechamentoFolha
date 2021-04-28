package br.com.proway.senior.model;

public class CargoFolha implements InterfaceCargoFolha {

	private double salario;
	private double valorBonificacao;
	private double percentualInsalubridade;
	
	public CargoFolha () {}

	
	/**
	 * 
	 * @param salario
	 * @param valorBonificacao
	 * @param percentualInsalubridade
	 */
	public CargoFolha(double salario, double valorBonificacao, double percentualInsalubridade) {
		this.salario = salario;
		this.valorBonificacao = valorBonificacao;
		this.percentualInsalubridade = percentualInsalubridade;
	}
	
	public double getSalario() {
		return salario;
	}

	public double getPercentualInsalubridade() {
		return percentualInsalubridade;
	}


	public double getValorBonificacao() {
		return valorBonificacao;
	}

}
