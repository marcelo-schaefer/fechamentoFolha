package br.com.proway.senior.controller;

import br.com.proway.senior.model.ICargoFolha;
import br.com.proway.senior.model.IPontoFolha;

public class CalculoHoras implements ICalculoHoras{

	private double salarioMinimo = 1100; // Regra de Neg�cio
	private double valorHorasExtras;
	private double fator = 0.5; // 50% adicional hora extra
	
	final double valorHorasDias = (double) 220 / 30;
	
	/**
	 * Calcula hora normal somando insalubridade.
	 * 
	 * Corre��o a m�todos redundantes de calculo de hora insalubre
	 * 
	 * Pega o valor do m�todo calculaInsalubridade e divide pela vari�vel
	 * horasTrabalhadas
	 *
	 * @return valorHoras = vai retornar o valor ganho de insalubridade por hora
	 */
	public double calculaValorHora(ICargoFolha cargoFolha) {
		double valorHoraInsalubridade = calculaInsalubridade(cargoFolha) / 220;
		if (valorHoraInsalubridade <= 0) {	
			return cargoFolha.getSalarioBase() / 220;
		} else {
			return ((cargoFolha.getSalarioBase() / 220) + valorHoraInsalubridade);
		}
	}	
	
	/**
	 * Calcula o valor inicial do sal�rio
	 * 
	 * Pega o valor do m�todo calculaValorHora passa para a vari�vel valorHoras,
	 * ap�s isso a vari�vel valor recebe a multipli��o de horasTrabalhas e
	 * valorHoras
	 * 
	 * @return valorDasHorasTrabalhadas = Retorna o valor do sal�rio inicial, considerando apenas a
	 *         quantidade horas trabalhadas e o valor da hora com insalubridade.
	 */
	public double calcularValorDasHorasTrabalhadas(IPontoFolha pontoFolha, double valorHora) {
		return valorHora * pontoFolha.getHorasTrabalhadas();
	}

	

	
	/**
	 * Calcula o valor da insalubridade
	 * 
	 * Realiza o c�lculo do valor a ser implementado no sal�rio m�nimo, vai pegar a
	 * vari�vel salarioMinimo e multiplicar pela sua faixa de insalubridade.
	 * 
	 * @return valorInsalubridade = Retorna o valor a ser somado ao sal�rio m�nimo.
	 */
	private double calculaInsalubridade(ICargoFolha cargoFolha) {
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
	 * Realiza o c�lculo das horas faltas a serem descontadas na folha do
	 * colaborador, recebe o valor de horasFalta e multiplica valorInsalubridade
	 * 
	 * @return valorFaltas = Retorna o valor a ser descontado na folha do
	 *         colaborador referente as horas faltas.
	 */
	public double calcularValorHorasFaltas(IPontoFolha pontoFolha, double valorHora) {
		return pontoFolha.getHorasFaltas() * valorHora;
	}
	
	/**
	 * Calcula o valor a ser pago em folha referente as horas extras
	 * 
	 * O valor retornado da multiplica��o de valorHoras e fator, vai somar com o
	 * valorHoras e depois multiplica pelas horasExtra
	 * 
	 * @return valor = Retorna o valor a ser pago de horas extras.
	 */
	public double calcularValorHorasExtras(IPontoFolha pontoFolha, double valorHorasTrabalhadas, double valorHora) {
		valorHorasExtras = pontoFolha.getHorasExtra() * (valorHora + (valorHora * fator));
		return valorHorasExtras;
	}
	
	/**
	 * Calcula o DSR
	 * 
	 * Define o valor do Reflexo DSR por meio de alguns par�metros passados
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
	public double calcularFerias(int dias, int abono, double valorHora) {
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
