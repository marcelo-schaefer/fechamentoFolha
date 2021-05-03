package br.com.proway.senior.controller;

import br.com.proway.senior.model.CargoFolha;
import br.com.proway.senior.model.ColaboradorFolha;
import br.com.proway.senior.model.FeriasFolha;
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
	public void calculoFolha(
			Folha folha, 
			CargoFolha cargoFolha,
			PontoFolha pontoFolha,	
			ColaboradorFolha colaboradorFolha,
			FeriasFolha feriasFolha,
			CalculoHoras calculoHoras,
			AbstractCalculosDesconto calculosDesconto){
		
		double salarioBrutoAcumulado = 0;
		double feriasBrutoAcumulado = 0;
		
		// Calculo de Horas
		double valorHorasTrabalhadas = calculoHoras.calcularValorDasHorasTrabalhadas(cargoFolha, pontoFolha);
		folha.setValorHorasTrabalhadas(valorHorasTrabalhadas);
		salarioBrutoAcumulado += valorHorasTrabalhadas;
		
		folha.setValorHorasFaltas(calculoHoras.calcularValorHorasFaltas(pontoFolha));
		salarioBrutoAcumulado -= folha.getValorHorasFaltas();
		
		folha.setValorHorasExtras(calculoHoras.calcularValorHorasExtras(pontoFolha, valorHorasTrabalhadas));
		salarioBrutoAcumulado += folha.getValorHorasExtras();
		
		salarioBrutoAcumulado += calculoHoras.calcularDSR();
		
		//Calculo Descontos	
		folha.setValorInss(calculosDesconto.calcularDescontoInss(salarioBrutoAcumulado));
		salarioBrutoAcumulado -= folha.getValorInss();
		
		folha.setValorImpostoDeRenda(calculosDesconto.calcularDescontoImpostoRenda(colaboradorFolha, salarioBrutoAcumulado));
		salarioBrutoAcumulado -= folha.getValorImpostoDeRenda();
		
		folha.setValorPlanoSaude(calculosDesconto.calcularDescontoPlanoSaude(colaboradorFolha));
		salarioBrutoAcumulado -= folha.getValorPlanoSaude();
		
		folha.setValorValeTransporte(calculosDesconto.calcularDescontoValeTransporte(colaboradorFolha, cargoFolha));
		salarioBrutoAcumulado -= folha.getValorValeTransporte();
		
		// Calculo de Férias Horas
		// cValorDasHorasFerias()
		folha.setValorFerias(calculoHoras.calcularFerias(feriasFolha.getDias(), feriasFolha.getAbono()));
		feriasBrutoAcumulado += folha.getValorFerias();
		
		folha.setValorInssFerias(calculosDesconto.calcularDescontoInss(feriasBrutoAcumulado));
		feriasBrutoAcumulado -= folha.getValorInssFerias();
		
		folha.setValorImpostoDeRendaFerias(calculosDesconto.calcularDescontoImpostoRenda(colaboradorFolha, feriasBrutoAcumulado));
		feriasBrutoAcumulado -= folha.getValorImpostoDeRendaFerias();
		
		// Passo Final 
		// SetData EMissão
		folha.setSalarioLiquido(salarioBrutoAcumulado);
		folha.setFeriasLiquido(feriasBrutoAcumulado);		
	}

}
