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
		
		double salarioLiquido = 0;
		
		
		CalcularHoras calculoHoras = new CalcularHoras();
		CalculoData calculoData = new CalculoData();
		CalculosDeExtras calculosDeExtras = new CalculosDeExtras();
		CalculosDesconto calculosDesconto = new CalculosDesconto();
		
		//CalcularFerias calculoFerias = new CalcularFerias();
		//calculoFerias.calcularFerias(folha);
//		calculoHoras.calcularValorDasHorasTrabalhadas(folha);
//		calculoHoras.calcularValorHorasFaltas(folha);
//		calculoHoras.calcularValorHorasExtras(folha);
//		calculosDeExtras.calcularDSR(folha);
//		calculosDeExtras.calcularBonificacao(folha);
//		calculosDesconto.calcularDescontoInss(folha);
//		calculosDesconto.calcularDescontoImpostoRenda(folha);
//		calculosDesconto.calcularDescontoPlanoSaude(folha);
//		calculosDesconto.calcularDescontoValeTransporte(folha);
		
		calculoData.setDataEmissao(folha);

		salarioLiquido = calculoHoras.calcularValorDasHorasTrabalhadas(folha);
		folha.setSalarioBruto(folha.getSalarioBruto() + salarioLiquido);
		salarioLiquido = calculoHoras.calcularValorHorasFaltas(folha);
		folha.setSalarioBruto(folha.getSalarioBruto() - salarioLiquido);
		salarioLiquido = calculoHoras.calcularValorHorasExtras(folha);
		folha.setSalarioBruto(folha.getSalarioBruto() + salarioLiquido);
		salarioLiquido = calculosDeExtras.calcularDSR(folha);
		folha.setSalarioBruto(folha.getSalarioBruto() + salarioLiquido);
		salarioLiquido = calculosDeExtras.calcularBonificacao(folha);
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
	
//	private addSalarioBruto() {
		
//	}
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
