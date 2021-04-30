package br.com.proway.senior.controller;

import br.com.proway.senior.model.CargoFolha;
import br.com.proway.senior.model.Folha;
import br.com.proway.senior.model.PontoFolha;

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
			CargoFolha cargoFolha,
			PontoFolha pontoFolha,			
			AbstractCalcularHoras calculoHoras, 
			AbstractCalculosDeExtras calculosDeProventos,
			AbstractCalculosDesconto calculosDesconto){
		
		double salarioBrutoAcumulado = 0; // mudar nome salarioIncremental ou adicionar direto no salario bruto
		
		
		// Calculo de Horas
		double valorHorasTrabalhadas = calculoHoras.calcularValorDasHorasTrabalhadas(cargoFolha, pontoFolha);
		folha.setValorHorasTrabalhadas(valorHorasTrabalhadas);
		salarioBrutoAcumulado += valorHorasTrabalhadas;
		
		folha.setValorHorasFaltas(calculoHoras.calcularValorHorasFaltas(pontoFolha));
		salarioBrutoAcumulado -= folha.getValorHorasFaltas();
		
		salarioBrutoAcumulado += calculoHoras.calcularValorHorasExtras(pontoFolha, valorHorasTrabalhadas);
		
		// Calculo de Proventos
		incremento = calculosDeProventos.calcularDSR(folha);
		folha.setSalarioBruto(folha.getSalarioBruto() + incremento);
		incremento = calculosDeProventos.calcularBonificacao(folha);
		
		//Calculo Descontos		
		folha.setSalarioBruto(folha.getSalarioBruto() + incremento);
		incremento = calculosDesconto.calcularDescontoInss(folha);
		folha.setSalarioBruto(folha.getSalarioBruto() - incremento);
		incremento = calculosDesconto.calcularDescontoImpostoRenda(folha);
		folha.setSalarioBruto(folha.getSalarioBruto() - incremento);
		incremento = calculosDesconto.calcularDescontoPlanoSaude(folha);
		folha.setSalarioBruto(folha.getSalarioBruto() - incremento);
		incremento = calculosDesconto.calcularDescontoValeTransporte(folha);
		folha.setSalarioBruto(folha.getSalarioBruto() - incremento);
		
		folha.setSalarioLiquido(folha.getSalarioBruto());
		
		return folha.getSalarioLiquido();
	}

}
