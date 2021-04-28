package br.com.proway.senior.controller;

import br.com.proway.senior.model.Folha;

public class CalcularFerias implements InterfaceCalculoFerias{

	final double VALORHORASDIAS = (double) 220 / 30;
	
	public double calcularFeriasBruto(int dias, int abono, double valorHoras) {
		double valorDia = valorHoras * VALORHORASDIAS;
		double valorFerias = dias * valorDia;
		double valorFeriasUmTerco = valorFerias / 3;
		double valorTotalFerias = 0;
		if (abono <= 0) {
			valorTotalFerias = valorFerias + valorFeriasUmTerco;
		} else {
			double valorAbono = abono * valorDia;
			double valorAbonoUmTerco = valorAbono / 3;
			valorTotalFerias = (valorFerias + valorFeriasUmTerco) + (valorAbono + valorAbonoUmTerco);
		}
		return valorTotalFerias;	
	}	
	
	public double calcularDescontos(double valorTotalFerias, Folha folha) {
		CalculosDesconto desconto = new CalculosDesconto();	
		double descontos = desconto.calcularDescontoInss(valorTotalFerias, folha);
		descontos -= desconto.calcularDescontoImpostoRenda(valorTotalFerias, folha);
		return descontos;
	}

	public double calcularFerias(Folha folha) {
		int dias = folha.getDias();
		int abono = folha.getAbono();
		double valorHoras = folha.getValorHoras();
		double feriasBruto = this.calcularFeriasBruto(dias, abono, valorHoras);
		double feriasLiquido = this.calcularDescontos(feriasBruto, folha);
		return feriasBruto - feriasLiquido;
	}

	
}
