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
	public double porcentagemBonificacaoCargo;
	
	/**
	 * @return the porcentagemBonificacaoCargo
	 */
	public double getPorcentagemBonificacaoCargo() {
		return porcentagemBonificacaoCargo;
	}
	
	
	public double getSalarioBase() {
		return salarioBase;
	}

	public double getPercentualInsalubridade() {
		return percentualInsalubridade;
	}
	

	/**
	 * Metodo que identifica porcentagemBonificacaoCargo como a bonificacao dividida
	 * por 100 para trazer o valor decimal.
	 * @param porcentagemBonificacaoCargo the porcentagemBonificacaoCargo to set
	 */
	public void setPorcentagemBonificacaoCargo(double bonificacao) {
		this.porcentagemBonificacaoCargo = (bonificacao / 100);
	}

/**
 * Metodo CargoFolha
 * @param salarioBase
 * @param percentualInsalubridade
 * @param porcentagemBonificacaoCargo
 */
	public CargoFolha(double salarioBase, double percentualInsalubridade, double porcentagemBonificacaoCargo) {
		super();
		this.salarioBase = salarioBase;
		this.percentualInsalubridade = percentualInsalubridade;
		this.porcentagemBonificacaoCargo = porcentagemBonificacaoCargo;
	}

	
	
}
