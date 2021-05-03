package br.com.proway.senior.model;

public class FeriasFolha implements IFeriasFolha {

	int dias;
	int abono;
	
	/**
	 * Construtor
	 * 
	 * @param dias
	 * @param abono Dias de abono
	 */
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
