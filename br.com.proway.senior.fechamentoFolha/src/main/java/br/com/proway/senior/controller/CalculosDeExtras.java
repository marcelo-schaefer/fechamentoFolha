package br.com.proway.senior.controller;

import br.com.proway.senior.model.Folha;

public class CalculosDeExtras
		extends AbstractCalculosDeExtras{

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
