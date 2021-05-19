package br.com.proway.senior.controller.calculos;

import br.com.proway.senior.model.externo.CargoFolha;
import br.com.proway.senior.model.externo.ColaboradorFolha;
import br.com.proway.senior.model.externo.interfaces.ICargoFolha;
import br.com.proway.senior.model.externo.interfaces.IColaboradorFolha;

/**
 * <h1>Calcula descontos.</h1>
 * 
 * <p>Implementa os metodos da {@link ICalculoDesconto} e faz os calculos 
 * de desconto relacionados ao salario bruto.</p>
 * 
 * @author Lucas Grijo
 * @author Lucas walim
 * @author Marcelo Schaefer
 * 
 * @author Sprint 5: Leonardo Felipe Silva <felipeleao217@gmail.com>;
 * @author Sprint 5: Bruna Carvalho <sh4323202@gmail.com>;
 * @author Sprint 5: Leonardo Pereira <leonardopereirajr@gmail.com>;
 * @author Sprint 5: Sabrina Schmidt <sabrinaschmidt335@gmail.com>;
 * @author Sprint 5: Lucas Nunes <lucasnunes.ln365@gmail.com>.
 * 
 * @see ICalculoDesconto
 *
 */
public class CalculoDesconto implements ICalculoDesconto {

	/***
	 * <h1>Referente ao valor por dependente</h1>
	 * 
	 * <p>Referente ao valor unitario de 
	 * cada dependente</p>
	 */
	private double valorPorDependentes = 189.59;

	/**
	 * <h1>Calcula o valor de INSS a ser descontado.</h1>
	 * 
	 * <p>Realiza o calculo do valor de INSS a ser descontado em {@link Folha} a partir do
	 * valor acumulado. Pega a variavel e multiplica pelo valor de desconto fixado
	 * em 11%. Retorna o valor a ser descontado.</p>
	 * 
	 * @param double salarioBrutoAcumulado, referente ao salário bruto
	 * 
	 * @return double referente ao salario bruo com o desconto do INSS
	 * 
	 * @author Sprint 5: Leonardo Felipe Silva <felipeleao217@gmail.com>;
	 * @author Sprint 5: Bruna Carvalho <sh4323202@gmail.com>;
	 * @author Sprint 5: Leonardo Pereira <leonardopereirajr@gmail.com>;
	 * @author Sprint 5: Sabrina Schmidt <sabrinaschmidt335@gmail.com>;
	 * @author Sprint 5: Lucas Nunes <lucasnunes.ln365@gmail.com>.
	 * 
	 * @see Folha
	 */
	public double calcularDescontoInss(double salarioBrutoAcumulado) {
		return (salarioBrutoAcumulado * 0.11);
	}
	
	/**
	 * <h1>Calcula o valor do FGTS depositado na conta do FGTS.</h1>
	 * 
	 * <p>Realiza o calculo do valor do FGTS a ser depositado ao colaborador
	 * na conta do FGTS na CEF.</p>
	 * 
	 * @param salarioBrutoAcumulado double, referente ao salario bruto informado.
	 * 
	 * @return double, referente ao salario bruto com o desconto do FGTS,
	 * 
	 * @author Sprint 5: Leonardo Pereira <leonardopereirajr@gmail.com>;
	 * @author Sprint 5: Sabrina Schmidt <sabrinaschmidt335@gmail.com>.
	 */
	public double calcularFGTS(double salarioBrutoAcumulado) {
		return (salarioBrutoAcumulado * 0.08);	
	}

	/**
	 * <h1>Calcula o valor de Imposto de Renda.</h1>
	 * 
	 * <p>O metodo subtrai o salario bruto pelo calculo de valor de dependente,
	 * verifica o valor e encaixa em valores possiveis para multiplicar a
	 * porcentagem.</p>
	 * 
	 * @param colaboradorFolha {@link IColaboradorFolha}, referente ao {@link ColaboradorFolha}.
	 * @param salarioBrutoAcumulado double, referente ao salario bruto informado.
	 * 
	 * @return double, referente ao salario buto com o desconto do imposto de renda
	 * 
	 * @author Sprint 4: Lucas Grijo
	 * @author Sprint 4: Lucas walim
	 * @author Sprint 4: Marcelo Schaefer
	 * 
	 * @see IColaboradorFolha
	 * @see ColaboradorFolha
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
	 * <h1>Calcula o valor do dependente.</h1>
	 * 
	 * <p>Multiplica o numero de dependentes 
	 * pelo valor de dependentes {@link CalculoDesconto#valorPorDependentes}.</p>
	 * 
	 * @param numeroDependentes int, referente ao numero de dependentes informados.
	 * 
	 * @return double, referente ao valor dos dependentes. 
	 * 
	 * @author Sprint 4: Lucas Grijo
	 * @author Sprint 4: Lucas walim
	 * @author Sprint 4: Marcelo Schaefer
	 * 
	 * @see CalculoDesconto#valorPorDependentes
	 */
	private double calcularValorDependente(int numeroDependentes) {
		return numeroDependentes * valorPorDependentes;
	}

	/**
	 * <h1>Desconto de Plano de Saude.</h1>
	 * 
	 * <p>Realiza o desconto de plano de saude, somando o valor da mensalidade com o
	 * valor de cooparticipacao.<p>
	 * 
	 * @param  colaboradorFolha {@link IColaboradorFolha}, referente ao {@link ColaboradorFolha}. 
	 * 
	 * @return double, referente a soma da mensalidade com o valor cooparticipacao.
	 * 
	 * @author Sprint 4: Lucas Grijo
	 * @author Sprint 4: Lucas walim
	 * @author Sprint 4: Marcelo Schaefer
	 * 
	 * @see IColaboradorFolha
	 * @see ColaboradorFolha
	 */
	public double calcularDescontoPlanoSaude(IColaboradorFolha colaboradorFolha) {
		double mensalidadePlanoSaude = colaboradorFolha.getPlanoSaudeMensalidade();
		double valorCooparticipacao = colaboradorFolha.getPlanoSaudeCooparticipacao();
		return mensalidadePlanoSaude + valorCooparticipacao;
	}

	/**
	 * <h1>Calcula o valor de vale transporte do colaborador.</h1>
	 * 
	 * <p>Verifica se o {@link ColaboradorFolha} possui vale transporte, se sim, pega 6% do
	 * salario base, se for maior ou igual que R$ 180,00 o desconto sera este, se
	 * for menor retorna este valor calculado.</p>
	 * 
	 * @param colaboradorFolha {@link IColaboradorFolha}, referente ao {@link ColaboradorFolha} informado;
	 * @param cargoFolha {@link ICargoFolha}, referente ao {@link CargoFolha} informado.
	 * 
	 * @return valorValorValeTransporte double.
	 * 
	 * @author Sprint 4: Lucas Grijo
	 * @author Sprint 4: Lucas walim
	 * @author Sprint 4: Marcelo Schaefer
	 * 
	 * @see ColaboradorFolha
	 * @see IColaboradorFolha
	 * @see ICargoFolha
	 * @see CargoFolha
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