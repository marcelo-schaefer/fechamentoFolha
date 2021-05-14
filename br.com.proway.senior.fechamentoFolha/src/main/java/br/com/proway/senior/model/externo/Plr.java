package br.com.proway.senior.model.externo;

import br.com.proway.senior.model.externo.interfaces.IPlr;

/**
 * Valor do Plr.
 * 
 * Objeto que implementa de {@link IPlr} e seta um valor fixo para o plr.
 * 
 * Sprint 5:
 * @author Leonardo Felipe Silva <felipeleao217@gmail.com>;
 * @author Bruna Carvalho <sh4323202@gmail.com>;
 * @author Leonardo Pereira <leonardopereirajr@gmail.com>;
 * @author Sabrina Schmidt <sabrinaschmidt335@gmail.com>;
 * @author Lucas Nunes <lucasnunes.ln365@gmail.com>.
 */
public class Plr implements IPlr {

	private double valorPlr = 0.0;
	
	public void setPlr(double valorPlr) {
		this.valorPlr = valorPlr;
	}

	public double getPlr() {
		return this.valorPlr;
	}
}