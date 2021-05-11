package br.com.proway.senior.controller.calculos;

import br.com.proway.senior.model.externo.interfaces.ICargoFolha;
import br.com.proway.senior.model.externo.interfaces.IColaboradorFolha;

/**
 * calcular descontos
 * 
 * eh a classe que pussi todos os metodos relacionados ha algum calculo de
 * desconto ao salario bruto
 * 
 * @author Lucas Grijo
 * @author Lucas walim
 * @author Marcelo Schaefer
 *
 */
public class CalculoDesconto implements ICalculoDesconto {

	private double valorPorDependente = 189.59;

	/**
	 * Calcula o valor de INSS a ser descontado
	 * 
	 * Realiza o c�lculo do valor de INSS a ser descontado em folha a partir do
	 * valor acumulado. Pega a vari�vel e multiplica pelo valor de desconto fixado
	 * em 11%. Retorna o valor a ser descontado.
	 * 
	 * @param double valorAcumulado, valor a ser multiplicado pela porcentagem
	 * @return double inss = Retorna o valor a ser descontado em folha.
	 * @author sprint2
	 */
	public double calcularDescontoInss(double salarioBrutoAcumulado) {
		return (salarioBrutoAcumulado * 0.11);
	}
	
	/**
	 * Calcula o valor do FGTS depositado na conta do FGTS.
	 * 
	 * Realiza o calculo do valor do FGTS a ser depositado ao colaborador
	 * na conta do FGTS na CEF.
	 * @author Leo Pereira 
	 * @author Sabrina
	 * @param 
	 */
	
	public double calcularFGTS(double salarioBrutoAcumulado) {
		return (salarioBrutoAcumulado * 0.08);
		
	}

	/**
	 * Calcula o valor de Imposto de Renda a ser descontado em folha
	 * 
	 * o metodo subtrai o salario bruto pelo calculo de valor de dependente,
	 * verifica o valor e encaixa em valores possiveis para multiplicar a
	 * porcentagem.
	 * 
	 * @param IColaboradorFolha colaboradorFolha, busca o numero de dependende,
	 *                          idependente da claase
	 * @param double            salarioBrutoAcumulado, ultiliza no calculo para
	 *                          adcionar ao baseCalculoImpostoRenda
	 * 
	 * @return double valorImpostoDeRenda, retorna o valor que a ser descontado em
	 *         folha referente ao Imposto de Renda (baseCalculoImpostoRenda
	 *         multiplicado por porcentagem).
	 * 
	 * @author sprint2
	 * @author Lucas Grijo
	 * @author Lucas walim
	 * @author Marcelo Schaefer
	 * 
	 */
	public double calcularDescontoImpostoRenda(IColaboradorFolha colaboradorFolha, double salarioBrutoAcumulado) {
		double baseCalculoImpostoRenda = salarioBrutoAcumulado
				- calcularValorDeduzirDependente(colaboradorFolha.getNumeroDeDependentes());
		if (baseCalculoImpostoRenda <= 1903.98) {
			return 0;
		} else if (baseCalculoImpostoRenda >= 1903.99 && baseCalculoImpostoRenda <= 2826.65) {
			return (baseCalculoImpostoRenda * 0.075) - 142.80;
		} else if (baseCalculoImpostoRenda >= 2826.66 && baseCalculoImpostoRenda <= 3751.05) {
			return (baseCalculoImpostoRenda * 0.15) - 354.80;
		} else if (baseCalculoImpostoRenda >= 3751.06 && baseCalculoImpostoRenda <= 4664.68) {
			return (baseCalculoImpostoRenda * 0.225) - 636.13;
		} else {
			return (baseCalculoImpostoRenda * 0.275) - 869.36;
		}
	}

	/**
	 * calcula valor dependente
	 * 
	 * o metodo multiplca o numero de dependentes pelo valor de cada um
	 * 
	 * @param int numeroDependentes, quantidade de dependentes para calcular
	 * @return double, valor do calculo
	 * @author sprint2
	 */
	private double calcularValorDeduzirDependente(int numeroDependentes) {
		return numeroDependentes * valorPorDependente;
	}

	/**
	 * Desconto de Plano de Saude.
	 * 
	 * Realiza o desconto de plano de sa�de, somando o valor da mensalidade com o
	 * valor de cooparticipa��o.
	 * 
	 * @param IColaboradorFolha colaboradorFolha, interface de onde puxara os
	 *                          valores
	 * @return double, soma da mensalidade com o valor cooparticipacao
	 * 
	 * @author sprint2
	 * @author Lucas Grijo
	 * @author Lucas walim
	 * @author Marcelo Schaefer
	 */
	public double calcularDescontoPlanoSaude(IColaboradorFolha colaboradorFolha) {
		double mensalidadePlanoSaude = colaboradorFolha.getPlanoSaudeMensalidade();
		double valorCooparticipacao = colaboradorFolha.getPlanoSaudeCooparticipacao();
		return mensalidadePlanoSaude + valorCooparticipacao;
	}

	/**
	 * Calcula o valor de vale transporte a ser descontado do colaborador
	 * 
	 * verifica se o colaborador possui vale transporte, se sim, pega 6 porcento do
	 * salario base, se for maior ou igual que R$ 180,00 o desconto ser� este, se
	 * for menor retorna este valor calculado.
	 * 
	 * @param IColaboradorFolha colaboradorFolha, busca para verificar se possui o
	 *                          vale transporte
	 * @param ICargoFolha       cargoFolha, busca o salario base
	 * @return double, valor do vale.
	 * 
	 * @author sprint2
	 * @author Lucas Grijo
	 * @author Lucas walim
	 * @author Marcelo Schaefer
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
