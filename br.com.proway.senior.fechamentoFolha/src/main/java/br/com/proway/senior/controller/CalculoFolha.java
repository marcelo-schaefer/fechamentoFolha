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
	public double calculoFolha(Folha folha){
		
		CalcularHoras calculoHoras = new CalcularHoras();
		//CalcularFerias calculoFerias = new CalcularFerias();
		CalculoData calculoData = new CalculoData();
		CalculosDeExtras calculosDeExtras = new CalculosDeExtras();
		CalculosDesconto calculosDesconto = new CalculosDesconto();
		
		//calculoFerias.calcularFerias(folha);
		calculoHoras.calcularValorDasHorasTrabalhadas(folha);
		calculoHoras.calcularValorHorasFaltas(folha);
		calculoHoras.calcularValorHorasExtras(folha);
		calculosDeExtras.calcularDSR(folha);
		calculosDeExtras.calcularBonificacao(folha);
		calculosDesconto.calcularDescontoInss(folha);
		calculosDesconto.calcularDescontoImpostoRenda(folha);
		calculosDesconto.calcularDescontoPlanoSaude(folha);
		calculosDesconto.calcularDescontoValeTransporte(folha);
		
		folha.setSalarioLiquido(folha.getSalarioBruto());
		calculoData.setDataEmissao(folha);
		
		return folha.getSalarioLiquido();
	}
	
	
	/*
	public double calcularFolha() {

		this.salarioBruto += this.calcularValorDasHorasTrabalhadas();
		this.salarioBruto -= this.calcularValorHorasFaltas();
		this.salarioBruto += this.calcularValorHorasExtras();
		this.salarioBruto += this.calcularDSR();
		this.salarioBruto += this.calcularBonificacao();
		this.salarioBruto -= this.calcularDescontoInss();
		this.salarioBruto -= this.calcularDescontoImpostoRenda();
		this.salarioBruto -= this.calcularDescontoPlanoSaude();
		this.salarioBruto -= this.calcularDescontoValeTransporte();
		this.salarioLiquido = this.salarioBruto;
		this.setDataEmissao();

		return this.salarioLiquido;
	}
*/
}
