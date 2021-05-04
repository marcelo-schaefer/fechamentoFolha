package br.com.proway.senior.model.externo;

/**
 * PontoFolha
 * 
 * Objeto conténdo os dados necessários de pontos para utilização interna na
 * criação de uma folha.
 * 
 * @author sprint3
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
