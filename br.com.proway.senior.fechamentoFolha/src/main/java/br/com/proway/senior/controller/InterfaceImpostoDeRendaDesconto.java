package br.com.proway.senior.controller;

import br.com.proway.senior.model.Folha;

public interface InterfaceImpostoDeRendaDesconto {

	public double calcularDescontoImpostoRenda(Folha folha);
	
	public double calcularDescontoImpostoRenda(double valorFerias, Folha folha);
}
