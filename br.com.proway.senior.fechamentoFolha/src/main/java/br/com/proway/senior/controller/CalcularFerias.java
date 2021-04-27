package br.com.proway.senior.controller;

import br.com.proway.senior.model.Folha;

public class CalcularFerias implements InterfaceCalculoFerias{

	public double calcularFerias(Folha folha) {
		int dias = folha.getDias();
		int abono = folha.getAbono();
		CalculosDesconto desconto = new CalculosDesconto();
		double valorHorasDias = (double) 220 / 30; // 7,333333333
		double valorDia = folha.getValorHoras() * valorHorasDias;
		double valorFerias = dias * valorDia;
		double valorFeriasUmTerco = valorFerias / 3;
		double valorTotalFerias = 0;
		if (abono <= 0) {
			valorTotalFerias = valorFerias + valorFeriasUmTerco;
			valorTotalFerias -= desconto.calcularDescontoInss(valorTotalFerias, folha);
			valorTotalFerias -= desconto.calcularDescontoImpostoRenda(valorTotalFerias, folha);
		} else {
			double valorAbono = abono * valorDia;
			double valorAbonoUmTerco = valorAbono / 3;
			valorTotalFerias = (valorFerias + valorFeriasUmTerco) + (valorAbono + valorAbonoUmTerco);
			valorTotalFerias -= desconto.calcularDescontoInss(valorTotalFerias, folha);
			valorTotalFerias -= desconto.calcularDescontoImpostoRenda(valorTotalFerias, folha);
		}
		return valorTotalFerias;	
	}	
	
}
