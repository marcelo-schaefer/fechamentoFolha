package br.com.proway.senior.controller;

import br.com.proway.senior.model.Folha;

public class CalculosDeExtras
		implements InterfaceBonificacaoExtra, InterfaceInsalubridadeExtra, InterfaceReflexoDsrExtra {

	/**
	 * Calcula o DSR
	 * 
	 * Define o valor do Reflexo DSR por meio de alguns parâmetros passados
	 */
	public double calcularDSR(Folha folha) {
		double diasUteis = 25.0;
		double domigosFeriados = 5.0;
		folha.setReflexoDSR((folha.getValorHoraExtra() / diasUteis) * domigosFeriados);
		return folha.getReflexoDSR();
	}

	/**
	 * Calcula o valor da insalubridade
	 * 
	 * Realiza o cálculo do valor a ser implementado no salário mínimo, vai pegar a
	 * variável salarioMinimo e multiplicar pela sua faixa de insalubridade.
	 * 
	 * @return valorInsalubridade = Retorna o valor a ser somado ao salário mínimo.
	 */
	public double calculaInsalubridade(Folha folha) {
		if (folha.getPercentualInsalubridade() == 10) {
			folha.setValorInsalubridade(folha.getSalarioMinimo() * 0.10);
			return folha.getValorInsalubridade();
		} else if (folha.getPercentualInsalubridade() == 20) {
			folha.setValorInsalubridade(folha.getSalarioMinimo() * 0.20);
			return folha.getValorInsalubridade();
		} else if (folha.getPercentualInsalubridade() == 40) {
			folha.setValorInsalubridade(folha.getSalarioMinimo() * 0.40);
			return folha.getValorInsalubridade();
		} else {
			folha.setValorInsalubridade(0);
			return folha.getValorInsalubridade();
		}
	}

	/**
	 * Recebe o valor de bonificação a ser acrescido na folha do colaborador
	 * 
	 * Recebe o valor da bonificação que será aplicado posteriormente nos proventos
	 * do colaborador.
	 * 
	 * @return valorBonificacao = Retorna o valor de bonificação que será somado aos
	 *         demais proventos na folha do colaborador
	 */
	public double calcularBonificacao(Folha folha) {
		if (folha.getValorBonificacao() > 0) {
			return folha.getValorBonificacao();
		} else {
			folha.setValorBonificacao(0);
			return folha.getValorBonificacao();
		}
	}

}
