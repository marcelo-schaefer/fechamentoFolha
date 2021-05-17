package br.com.proway.senior.model.externo;

import br.com.proway.senior.model.externo.interfaces.ICargoFolha;

/**
 * CargoFolha
 * 
 * Objeto conténdo os dados necessários de um cargo para utilização interna na
 * criação de uma folha.
 * 
 * @author sprint3
 * 
 */
public class CargoFolha implements ICargoFolha {

	private double salarioBase;
	private double percentualInsalubridade;

	public double getSalarioBase() {
		return salarioBase;
	}

	public CargoFolha(double salarioBase, double percentualInsalubridade) {
		super();
		this.salarioBase = salarioBase;
		this.percentualInsalubridade = percentualInsalubridade;
	}

	public double getPercentualInsalubridade() {
		return percentualInsalubridade;
	}

}
