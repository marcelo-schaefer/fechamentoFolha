package br.com.proway.senior.model.externo;

import br.com.proway.senior.model.externo.interfaces.IPontoFolha;

/**
 * Dados do Ponto usados para a criacao interna da folha.
 * 
 *Objeto que possue dados especificos do Ponto para ser 
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
public class PontoFolha implements IPontoFolha {

	private double horasTrabalhadas;
	private double horasExtra;
	private double horasFaltas;

	public PontoFolha(double horasTrabalhadas, double horasExtra, double horasFaltas) {
		this.horasTrabalhadas = horasTrabalhadas;
		this.horasExtra = horasExtra;
		this.horasFaltas = horasFaltas;
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

}
