package br.com.proway.senior.controller;

import br.com.proway.senior.model.Folha;

public class CalculoFolha { 
	
	/**
	 * Calcula a folha final
	 * 
	 * Método responsável por chamar todos os outros métodos que calculam o
	 * fechamento da folha do mes.
	 * 
	 * @return Salário liquido do coaborador
	 */
	public double calculoFolha(
			Folha folha, 
			AbstractCalcularHoras calculoHoras, 
			AbstractCalculosDeExtras calculosDeProventos,
			AbstractCalculosDesconto calculosDesconto){
		
		double salarioLiquido = 0;
		
		// Calculo de Horas
		salarioLiquido = calculoHoras.calcularValorDasHorasTrabalhadas(folha);
		folha.setSalarioBruto(folha.getSalarioBruto() + salarioLiquido);
		salarioLiquido = calculoHoras.calcularValorHorasFaltas(folha);
		folha.setSalarioBruto(folha.getSalarioBruto() - salarioLiquido);
		salarioLiquido = calculoHoras.calcularValorHorasExtras(folha);
		
		// Calculo de Extras
		folha.setSalarioBruto(folha.getSalarioBruto() + salarioLiquido);
		salarioLiquido = calculosDeProventos.calcularDSR(folha);
		folha.setSalarioBruto(folha.getSalarioBruto() + salarioLiquido);
		salarioLiquido = calculosDeProventos.calcularBonificacao(folha);
		
		//Calculo Descontos		
		folha.setSalarioBruto(folha.getSalarioBruto() + salarioLiquido);
		salarioLiquido = calculosDesconto.calcularDescontoInss(folha);
		folha.setSalarioBruto(folha.getSalarioBruto() - salarioLiquido);
		salarioLiquido = calculosDesconto.calcularDescontoImpostoRenda(folha);
		folha.setSalarioBruto(folha.getSalarioBruto() - salarioLiquido);
		salarioLiquido = calculosDesconto.calcularDescontoPlanoSaude(folha);
		folha.setSalarioBruto(folha.getSalarioBruto() - salarioLiquido);
		salarioLiquido = calculosDesconto.calcularDescontoValeTransporte(folha);
		folha.setSalarioBruto(folha.getSalarioBruto() - salarioLiquido);
		
		folha.setSalarioLiquido(folha.getSalarioBruto());
		
		return folha.getSalarioLiquido();
	}

}
