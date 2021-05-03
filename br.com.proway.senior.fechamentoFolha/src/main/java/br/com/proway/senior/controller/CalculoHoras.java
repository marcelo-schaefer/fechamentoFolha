package br.com.proway.senior.controller;

import br.com.proway.senior.model.CargoFolha;
import br.com.proway.senior.model.Folha;
import br.com.proway.senior.model.PontoFolha;

public class CalculoHoras implements ICalculoHoras{

	private double salarioMinimo = 1100; // Regra de Negócio
	private double valorHora;
	private double fator = 0.5; // 50% adicional hora extra
	private double valorHorasExtras;
	final double valorHorasDias = (double) 220 / 30;
	
	/**
	 * Calcula o valor inicial do salário
	 * 
	 * Pega o valor do método calculaValorHora passa para a variável valorHoras,
	 * após isso a variável valor recebe a multiplição de horasTrabalhas e
	 * valorHoras
	 * 
	 * @return valorDasHorasTrabalhadas = Retorna o valor do salário inicial, considerando apenas a
	 *         quantidade horas trabalhadas e o valor da hora com insalubridade.
	 */
	public double calcularValorDasHorasTrabalhadas(CargoFolha cargoFolha, PontoFolha pontoFolha) {
		this.valorHora = calculaValorHora(cargoFolha);
		return valorHora * pontoFolha.getHorasTrabalhadas();
	}

	
	/**
	 * Calcula hora normal somando insalubridade.
	 * 
	 * Correção a métodos redundantes de calculo de hora insalubre
	 * 
	 * Pega o valor do método calculaInsalubridade e divide pela variável
	 * horasTrabalhadas
	 *
	 * @return valorHoras = vai retornar o valor ganho de insalubridade por hora
	 */
	private double calculaValorHora(CargoFolha cargoFolha) {
		double valorHoraInsalubridade = calculaInsalubridade(cargoFolha) / 220;
		if (valorHoraInsalubridade < 0) {	
			return cargoFolha.getSalarioBase() / 220;
		} else {
			return ((cargoFolha.getSalarioBase() / 220) + valorHoraInsalubridade);
		}
	}
	
	/**
	 * Calcula o valor da insalubridade
	 * 
	 * Realiza o cálculo do valor a ser implementado no salário mínimo, vai pegar a
	 * variável salarioMinimo e multiplicar pela sua faixa de insalubridade.
	 * 
	 * @return valorInsalubridade = Retorna o valor a ser somado ao salário mínimo.
	 */
	private double calculaInsalubridade(CargoFolha cargoFolha) {
		if (cargoFolha.getPercentualInsalubridade() == 10) {
			return salarioMinimo * 0.10;
		} else if (cargoFolha.getPercentualInsalubridade() == 20) {
			return salarioMinimo * 0.20;
		} else if (cargoFolha.getPercentualInsalubridade() == 40) {
			return salarioMinimo * 0.40;
		} else {
			return 0;
		}
	}

	/**
	 * Calcula o valor a ser descontado de horas faltas
	 * 
	 * Realiza o cálculo das horas faltas a serem descontadas na folha do
	 * colaborador, recebe o valor de horasFalta e multiplica valorInsalubridade
	 * 
	 * @return valorFaltas = Retorna o valor a ser descontado na folha do
	 *         colaborador referente as horas faltas.
	 */
	public double calcularValorHorasFaltas(PontoFolha pontoFolha) {
		return pontoFolha.getHorasFaltas() * this.valorHora;
	}
	
	/**
	 * Calcula o valor a ser pago em folha referente as horas extras
	 * 
	 * O valor retornado da multiplicação de valorHoras e fator, vai somar com o
	 * valorHoras e depois multiplica pelas horasExtra
	 * 
	 * @return valor = Retorna o valor a ser pago de horas extras.
	 */
	public double calcularValorHorasExtras(PontoFolha pontoFolha, double valorHorasTrabalhadas) {
		valorHorasExtras = pontoFolha.getHorasExtra() * (valorHora + (valorHora * fator));
		return valorHorasExtras;
	}
	
	/**
	 * Calcula o DSR
	 * 
	 * Define o valor do Reflexo DSR por meio de alguns parâmetros passados
	 */
	public double calcularDSR() {
		double diasUteis = 25.0;
		double domigosFeriados = 5.0;
		return (valorHorasExtras / diasUteis) * domigosFeriados;
	}
	
	/**
	 * 
	 * @param dias
	 * @param abono
	 * @param valorHoras
	 * @return
	 */
	public double calcularFerias(int dias, int abono) {
		double valorDia = valorHora * valorHorasDias;
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
}
