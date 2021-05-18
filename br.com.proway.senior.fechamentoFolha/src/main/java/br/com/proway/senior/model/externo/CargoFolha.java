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

	public double getSalarioBase() {
		return salarioBase;
	}

	public CargoFolha(double salarioBase, double percentualInsalubridade) {
		this.salarioBase = salarioBase;
		this.percentualInsalubridade = percentualInsalubridade;
	}

	public double getPercentualInsalubridade() {
		return percentualInsalubridade;
	}	
}
