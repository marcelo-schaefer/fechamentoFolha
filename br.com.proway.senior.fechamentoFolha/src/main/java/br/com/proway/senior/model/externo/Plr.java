package br.com.proway.senior.model.externo;

import br.com.proway.senior.model.externo.interfaces.IPlr;

public class Plr implements IPlr {

	private double valorPlr = 0.0;
	
	public void setPlr(double valorPlr) {
		this.valorPlr = valorPlr;
	}

	public double getPlr() {
		return this.valorPlr;
	}
}