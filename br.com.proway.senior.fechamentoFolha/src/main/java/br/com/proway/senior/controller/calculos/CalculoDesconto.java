package br.com.proway.senior.controller.calculos;

import br.com.proway.senior.model.externo.ICargoFolha;
import br.com.proway.senior.model.externo.IColaboradorFolha;

public class CalculoDesconto implements ICalculoDesconto {

	private double valorPorDependente = 189.59;
	
	/**
	 * Calcula o valor de INSS a ser descontado
	 * 
	 * Realiza o cálculo do valor de INSS a ser descontado em folha a partir do
	 * salário informado. Pega a variável salarioBruto e multiplica pelo valor de
	 * desconto fixado em 11%. Retorna o valor a ser descontado.
	 * 
	 * @return inss = Retorna o valor a ser descontado em folha.
	 */
	public double calcularDescontoInss(double valorAcumulado) {
		return (valorAcumulado * 0.11);
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
	public double calcularDescontoImpostoRenda(IColaboradorFolha colaboradorFolha, double salarioBrutoAcumulado) {
		double baseCalculoimpostoRenda = salarioBrutoAcumulado - calcularValorDeduzirDependente(colaboradorFolha.getNumeroDeDependentes());
		if (baseCalculoimpostoRenda <= 1903.98) {
			return 0;
		} else if (baseCalculoimpostoRenda >= 1903.99 && baseCalculoimpostoRenda <= 2826.65) {
			return (baseCalculoimpostoRenda * 0.075) - 142.80;
		} else if (baseCalculoimpostoRenda >= 2826.66 && baseCalculoimpostoRenda <= 3751.05) {
			return (baseCalculoimpostoRenda * 0.15) - 354.80;
		} else if (baseCalculoimpostoRenda >= 3751.06 && baseCalculoimpostoRenda <= 4664.68) {
			return (baseCalculoimpostoRenda * 0.225) - 636.13;
		} else {
			return (baseCalculoimpostoRenda * 0.275) - 869.36;
		}
	}
	
	private double calcularValorDeduzirDependente(int numeroDependentes) {
		return numeroDependentes * valorPorDependente;
	}
		
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
	public double calcularDescontoPlanoSaude(IColaboradorFolha colaboradorFolha) {
		double mensalidadePlanoSaude = colaboradorFolha.getPlanoSaudeMensalidade();
		double valorCooparticipacao = colaboradorFolha.getPlanoSaudeCooparticipacao();
		return mensalidadePlanoSaude + valorCooparticipacao;
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
	public double calcularDescontoValeTransporte(IColaboradorFolha colaboradorFolha, ICargoFolha cargoFolha) {
		if (colaboradorFolha.isValeTransporte()) {
			double valorValorValeTransporte = (cargoFolha.getSalarioBase() * 0.06);
			if (valorValorValeTransporte > 180) {
				return 180;
			} else {
				return valorValorValeTransporte;
			}
		} else {
			return 0;
		}
	}
	



}
