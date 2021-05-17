package br.com.proway.senior.model.externo;

import br.com.proway.senior.model.externo.interfaces.IFeriasFolha;

/**
 * Pega os dados necessarios para criar folha de ferias.
 * 
 * Objeto que possue dados especificos de ferias para ser usado 
 * na criacao de uma folha do tipo ferias.
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
