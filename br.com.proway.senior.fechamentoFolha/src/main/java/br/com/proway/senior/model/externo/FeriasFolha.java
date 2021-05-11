package br.com.proway.senior.model.externo;

import br.com.proway.senior.model.externo.interfaces.IFeriasFolha;

/**
 * FeriasFolha
 * 
 * Objeto conténdo os dados necessários de férias para utilização interna na
 * criação de uma folha.
 * 
 * @author sprint3
 */
public class FeriasFolha implements IFeriasFolha {

	int dias;
	int abono;

	public FeriasFolha(int dias, int abono) {
		this.dias = dias;
		this.abono = abono;
	}

	public int getDias() {
		return dias;
	}

	public int getAbono() {
		return abono;
	}

}
