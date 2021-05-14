package br.com.proway.senior.controller.calculos;

import br.com.proway.senior.model.externo.interfaces.ICargoFolha;
import br.com.proway.senior.model.externo.interfaces.IColaboradorFolha;

/**
 * Calcula descontos.
 * 
 * Implementa os metodos da {@link ICalculoDesconto} e faz os calculos 
 * de desconto relacionados ao salario bruto.
 * 
 * @author Lucas Grijo
 * @author Lucas walim
 * @author Marcelo Schaefer
 * 
 * Sprint 5:
 * @author Leonardo Felipe Silva <felipeleao217@gmail.com>;
 * @author Bruna Carvalho <sh4323202@gmail.com>;
 * @author Leonardo Pereira <leonardopereirajr@gmail.com>;
 * @author Sabrina Schmidt <sabrinaschmidt335@gmail.com>;
 * @author Lucas Nunes <lucasnunes.ln365@gmail.com>.
 *
 */
public class CalculoDesconto implements ICalculoDesconto {

	private double valorPorDependentes = 189.59;

	/**
	 * Calcula o valor de INSS a ser descontado.
	 * 
	 * Realiza o c�lculo do valor de INSS a ser descontado em folha a partir do
	 * valor acumulado. Pega a vari�vel e multiplica pelo valor de desconto fixado
	 * em 11%. Retorna o valor a ser descontado.
	 * 
	 * @param double valorAcumulado
	 * @return double
	 */
	public double calcularDescontoInss(double salarioBrutoAcumulado) {
		return (salarioBrutoAcumulado * 0.11);
	}
	
	/**
	 * Calcula o valor do FGTS depositado na conta do FGTS.
	 * 
	 * Realiza o calculo do valor do FGTS a ser depositado ao colaborador
	 * na conta do FGTS na CEF.
	 * 
	 * @param salarioBrutoAcumulado double
	 * @return double
	 * 
	 * @author Leo Pereira 
	 * @author Sabrina
	 */
	public double calcularFGTS(double salarioBrutoAcumulado) {
		return (salarioBrutoAcumulado * 0.08);	
	}

	/**
	 * Calcula o valor de Imposto de Renda.
	 * 
	 * O metodo subtrai o salario bruto pelo calculo de valor de dependente,
	 * verifica o valor e encaixa em valores possiveis para multiplicar a
	 * porcentagem.
	 * 
	 * @param colaboradorFolha {@link IColaboradorFolha}
	 * @param double
	 * @return double 
	 * 
	 * @author sprint2
	 * @author Lucas Grijo
	 * @author Lucas walim
	 * @author Marcelo Schaefer
	 * 
	 */
	public double calcularDescontoImpostoRenda(IColaboradorFolha colaboradorFolha, double salarioBrutoAcumulado) {
		double baseCalculoImpostoRenda = salarioBrutoAcumulado
				- calcularValorDependente(colaboradorFolha.getNumeroDeDependentes());
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
	 * Calcula o valor do dependente.
	 * 
	 * Multiplica o numero de dependentes 
	 * pelo valor de dependentes {@link CalculoDesconto#valorPorDependentes}.
	 * 
	 * @param numeroDependentes int
	 * @return numeroDependentes double. 
	 */
	private double calcularValorDependente(int numeroDependentes) {
		return numeroDependentes * valorPorDependentes;
	}

	/**
	 * Desconto de Plano de Saude.
	 * 
	 * Realiza o desconto de plano de saude, somando o valor da mensalidade com o
	 * valor de cooparticipacao.
	 * 
	 * @param  colaboradorFolha {@link IColaboradorFolha}. 
	 * @return double, soma da mensalidade com o valor cooparticipacao
	 */
	public double calcularDescontoPlanoSaude(IColaboradorFolha colaboradorFolha) {
		double mensalidadePlanoSaude = colaboradorFolha.getPlanoSaudeMensalidade();
		double valorCooparticipacao = colaboradorFolha.getPlanoSaudeCooparticipacao();
		return mensalidadePlanoSaude + valorCooparticipacao;
	}

	/**
	 * Calcula o valor de vale transporte do colaborador.
	 * 
	 * verifica se o colaborador possui vale transporte, se sim, pega 6 porcento do
	 * salario base, se for maior ou igual que R$ 180,00 o desconto sera este, se
	 * for menor retorna este valor calculado.
	 * 
	 * @param colaboradorFolha {@link IColaboradorFolha};
	 * @param cargoFolha {@link ICargoFolha};
	 * 
	 * @return valorValorValeTransporte double.
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
