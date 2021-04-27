package br.com.proway.senior.controller;

import br.com.proway.senior.model.Folha;

public class CalculosDesconto implements InterfaceImpostoDeRendaDesconto, InterfaceValeTransporteDesconto,
		InterfaceINSSDesconto, InterfacePlanoDeSaudeDesconto {

	/**
	 * Desconto de Plano de Saude.
	 * 
	 * Realiza o desconto de plano de saúde, somando o valor da mensalidade com o
	 * valor de cooparticipação caso exista. A variável planoSaude retornará a soma
	 * das variáveis mensalidadePlanoSaude e valorCooparticipacaoPlanoSaude.
	 * 
	 * @return planoSaude = retorna valor a ser descontado em folha, referente ao
	 *         Plano de Saude.
	 */
	public double calcularDescontoPlanoSaude(Folha folha) {
		if (folha.getMensalidadePlanoSaude() >= 0) {
			if (folha.getValorCooparticipacaoPlanoSaude() >= 0) {
				folha.setPlanoSaude(folha.getMensalidadePlanoSaude() + folha.getValorCooparticipacaoPlanoSaude());
			} else {
				folha.setValorCooparticipacaoPlanoSaude(0);
				folha.setPlanoSaude(folha.getMensalidadePlanoSaude() + folha.getValorCooparticipacaoPlanoSaude());
			}
		} else {
			folha.setMensalidadePlanoSaude(0);
			folha.setValorCooparticipacaoPlanoSaude(0);
			folha.setPlanoSaude(folha.getMensalidadePlanoSaude() + folha.getValorCooparticipacaoPlanoSaude());
		}

		return folha.getPlanoSaude();
	}

	/**
	 * Calcula o valor de INSS a ser descontado
	 * 
	 * Realiza o cálculo do valor de INSS a ser descontado em folha a partir do
	 * salário informado. Pega a variável salarioBruto e multiplica pelo valor de
	 * desconto fixado em 11%. Retorna o valor a ser descontado.
	 * 
	 * @return inss = Retorna o valor a ser descontado em folha.
	 */
	public double calcularDescontoInss(Folha folha) {
		folha.setInss(folha.getSalarioBruto() * 0.11);
		return folha.getInss();
	}

	public double calcularDescontoInss(double valorFerias, Folha folha) {
		folha.setInss(valorFerias * 0.11);
		return folha.getInss();
	}

	/**
	 * Calcula o valor de Imposto de Renda a ser descontado em folha
	 * 
	 * Realiza o cálculo do valor a ser descontado referente ao Imposto de Renda na
	 * folha do colaborador, seleciona o salárioBruto e multiplica pela sua faixa
	 * salarial e subtrai o valor a deduzir(exe:142,80).
	 * 
	 * @return valorImpostoDeRenda = Retorna o valor que a ser descontado em folha
	 *         referente ao Imposto de Renda.
	 */
	public double calcularDescontoImpostoRenda(double valorFerias, Folha folha) {
		double baseCalculoimpostoRenda = valorFerias - this.calcularValorDeduzirDependente(folha);
		if (baseCalculoimpostoRenda <= 1903.98) {
			folha.setValorImpostoDeRenda(0);
		} else if (baseCalculoimpostoRenda >= 1903.99 && baseCalculoimpostoRenda <= 2826.65) {
			folha.setValorImpostoDeRenda((baseCalculoimpostoRenda * 0.075) - 142.80);
		} else if (baseCalculoimpostoRenda >= 2826.66 && baseCalculoimpostoRenda <= 3751.05) {
			folha.setValorImpostoDeRenda((baseCalculoimpostoRenda * 0.15) - 354.80);
		} else if (baseCalculoimpostoRenda >= 3751.06 && valorFerias <= 4664.68) {
			folha.setValorImpostoDeRenda((baseCalculoimpostoRenda * 0.225) - 636.13);
		} else {
			folha.setValorImpostoDeRenda((baseCalculoimpostoRenda * 0.275) - 869.36);
		}

		return folha.getValorImpostoDeRenda();
	}

	public double calcularDescontoImpostoRenda(Folha folha) {
		double baseCalculoimpostoRenda = folha.getSalarioBruto() - this.calcularValorDeduzirDependente(folha);
		if (baseCalculoimpostoRenda <= 1903.98) {
			folha.setValorImpostoDeRenda(0);
		} else if (baseCalculoimpostoRenda >= 1903.99 && baseCalculoimpostoRenda <= 2826.65) {
			folha.setValorImpostoDeRenda((baseCalculoimpostoRenda * 0.075) - 142.80);
		} else if (baseCalculoimpostoRenda >= 2826.66 && baseCalculoimpostoRenda <= 3751.05) {
			folha.setValorImpostoDeRenda((baseCalculoimpostoRenda * 0.15) - 354.80);
		} else if (baseCalculoimpostoRenda >= 3751.06 && baseCalculoimpostoRenda <= 4664.68) {
			folha.setValorImpostoDeRenda((baseCalculoimpostoRenda * 0.225) - 636.13);
		} else {
			folha.setValorImpostoDeRenda((baseCalculoimpostoRenda * 0.275) - 869.36);
		}

		return folha.getValorImpostoDeRenda();
	}

	private double calcularValorDeduzirDependente(Folha folha) {
		double valor = folha.getNumeroDependentes() * folha.getValorPorDependente();
		return valor;
	}

	/**
	 * Calcula o valor de vale transporte a ser descontado do colaborador
	 * 
	 * Chamada do metodo de Vale transporte que calcula o desconto, se o percentual
	 * aplicado de 6% (0,06) for maior ou igual que R$ 180,00 o desconto será este,
	 * se for menor retorna este valor calculado, e se for informado um valor igual
	 * ou menor que 0 retorna 0.
	 * 
	 * @return valeTransporte = valor do vale transporte a ser descontado do salário
	 *         base.
	 */
	public double calcularDescontoValeTransporte(Folha folha) {
		if (folha.isValeTransporte()) {
			folha.setValorValeTransporte(folha.getSalarioBase() * 0.06);
			if (folha.getValorValeTransporte() > 180) {
				folha.setValorValeTransporte(180);
			}
		} else {
			folha.setValorValeTransporte(0);
		}
		return folha.getValorValeTransporte();

	}

}
