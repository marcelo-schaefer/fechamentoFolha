package br.com.proway.senior.model.externo;

import br.com.proway.senior.model.externo.interfaces.ICargoFolha;

/**
 * Dados do Cargo usado para a criacao interna da folha.
 * 
 * Objeto que possue dados especificos do Cargo para ser 
 * usado na criacao interna de uma folha {@link Folha}.
 * 
 * @author sprint3
 * 
 * Sprint 5:
 * @author Leonardo Felipe Silva <felipeleao217@gmail.com>;
 * @author Bruna Carvalho <sh4323202@gmail.com>;
 * @author Leonardo Pereira <leonardopereirajr@gmail.com>;
 * @author Sabrina Schmidt <sabrinaschmidt335@gmail.com>;
 * @author Lucas Nunes <lucasnunes.ln365@gmail.com>.
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
