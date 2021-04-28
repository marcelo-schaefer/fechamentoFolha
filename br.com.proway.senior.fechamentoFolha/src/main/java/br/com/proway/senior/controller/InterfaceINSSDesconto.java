package br.com.proway.senior.controller;

import br.com.proway.senior.model.Folha;

public interface InterfaceINSSDesconto {

	public double calcularDescontoInss(Folha folha);

	public double calcularDescontoInss(double valorFerias, Folha folha);
}
