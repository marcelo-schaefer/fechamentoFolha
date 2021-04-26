package br.com.proway.senior.model;

public class CalcularHoras implements InterfaceHorasExtras, InterfaceHorasTrabalhadas, InterfaceHorasFaltando {

	public double calcularValorHorasFaltas() {
		Folha folha = new Folha();
		folha.setHorasTrabalhadas(folha.getHorasFalta() * folha.getValorHoras()); 
		return folha.getHorasTrabalhadas();
	}

	public double calcularValorDasHorasTrabalhadas() {
		Folha folha = new Folha();
		double valorHoras = this.calculaValorHora();
		double valor = folha.getHorasTrabalhadas() * valorHoras;

		return valor;
	}
	
	public double calculaValorHora() { 
		CalculosDeExtras calculo = new CalculosDeExtras();
		Folha folha = new Folha();		
		double valorHoraInsalubridade = (calculo.calculaInsalubridade() / 220);
		if (valorHoraInsalubridade < 0) {
			folha.setValorHoras(folha.getSalarioBase() / 220);
			return folha.getValorHoras();
		} else {
			folha.setValorHoras(folha.getSalarioBase() / 220);
			return folha.getValorHoras();
		}
	}
	
	public double calcularValorHorasExtras() {
		Folha folha = new Folha();
		double valorHora50Porcento;
		valorHora50Porcento = get.ValorHoras + (this.valorHoras * this.fator);
		return this.valorHoraExtra = this.horasExtra * valorHora50Porcento;
	}

}
