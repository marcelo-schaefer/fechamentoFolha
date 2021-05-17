package br.com.proway.senior.controller.calculos;

import br.com.proway.senior.model.externo.interfaces.ICargoFolha;
import br.com.proway.senior.model.externo.interfaces.IPontoFolha;

/**
 * calcular horas
 * 
 * classe que pussui todos os metodos de calculos relacionados a 
 * soma no salario bruto.
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
public class CalculoHoras implements ICalculoHoras {

	private double salarioMinimo = 1100; // Regra de Negï¿½cio
	private double fator = 0.5; // 50% adicional hora extra
	final double valorHorasDias = (double) 220 / 30;

	/**
	 * Calcula o valor das horas
	 *
<<<<<<< HEAD
	 * o metodo chama o metodo de calcular insalubridade dividido por 220, verifica
	 * se ï¿½ menor que 0, se sim, retorna salario base dividido por 220, se nao,
	 * retorna o mesmo mais o valor da issalubridade.
=======
	 * O metodo chama o metodo de calcular insalubridade dividido por 220, verifica
>>>>>>> c230790fca0271d59e8ea2990cbb609a22a0a150
	 * se é menor que 0, se sim, retorna salario base dividido por 220, se nao,
	 * retorna o mesmo mais o valor da insalubridade.
	 *
	 * @param cargoFolha {@link ICargoFolha}
	 * @return double
	 * 
	 * @author sprint2
	 * @author Lucas Grijo
	 * @author Lucas walim
	 * @author Marcelo Schaefer
	 * 
	 */
	public double calcularValorHora(ICargoFolha cargoFolha) {
		double valorHoraInsalubridade = calcularInsalubridade(cargoFolha) / 220;
		if (valorHoraInsalubridade <= 0) {
			return cargoFolha.getSalarioBase() / 220;
		} else {
			return ((cargoFolha.getSalarioBase() / 220) + valorHoraInsalubridade);
		}
	}

	/**
	 * Calcula o valor das horas que foram trabalhadas
	 * 
	 * o metodo multiplica e retorna o falor da multiplicaï¿½ï¿½o entre o valor das
	 * horas e quantas horas o funcionario trabalhou
	 * 
	 * @param pontoFolha {@link IPontoFolha}
	 * @param valorHoras double
	 * @return double
	 * 
	 * @author sprint2
	 * @author Lucas Grijo
	 * @author Lucas walim
	 * @author Marcelo Schaefer
	 * 
	 */
	public double calcularValorDasHorasTrabalhadas(IPontoFolha pontoFolha, double valorHora) {
		return valorHora * pontoFolha.getHorasTrabalhadas();
	}

	/**
	 * Calcula o valor da insalubridade
	 * 
	 * Realiza o calculo do valor a ser implementado no salario minimo, vai pegar a
	 * variavel salarioMinimo e multiplicar pela sua faixa de insalubridade,
	 * dependendode onde ela se encaixar.
	 * 
	 * @param cargoFolha {@link ICargoFolha}
	 * @return double
	 * 
	 * @author sprint2
	 * @author Lucas Grijo
	 * @author Lucas walim
	 * @author Marcelo Schaefer
	 */
	private double calcularInsalubridade(ICargoFolha cargoFolha) {
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
	 * colaborador, recebe o valor de horasFalta e multiplica pelo valor da hora
	 * 
	 * @param pontoFolha {@link IPontoFolha}
	 * @param double valorHora
	 * @return double
	 * 
	 * @author sprint2
	 * @author Lucas Grijo
	 * @author Lucas walim
	 * @author Marcelo Schaefer
	 */
	public double calcularValorHorasFaltas(IPontoFolha pontoFolha, double valorHora) {
		return pontoFolha.getHorasFaltas() * valorHora;
	}

	/**
	 * Calcula o valor horas extras
	 * 
	 * O valor retornado da multiplicao de valorHoras e fator, vai somar com o
	 * valorHoras e depois multiplica pelas horasExtra
	 * 
	 * @param pontoFolha {@link IPontoFolha}
	 * @param double valorHoras
	 * @return valor
	 * 
	 * @author sprint2
	 * @author Lucas Grijo
	 * @author Lucas walim
	 * @author Marcelo Schaefer
	 */
	public double calcularValorHorasExtras(IPontoFolha pontoFolha, double valorHora) {
		return pontoFolha.getHorasExtra() * (valorHora + (valorHora * fator));
	}

	/**
	 * calcula valor DSR
	 * 
	 * o metodo pega a data atual, adciona em uma listatodos os dias do mes atual
	 * que sao dias uteis, depois usa com variavel os dias uteis a partir do tamanho
	 * da lista, e os dias de domingo como a diferenca entre o tamanho da lista e a
	 * quantidade de dias no mes.
	 * 
	 * @param double valorHorasExtras, valor das horas extras do funcionario
	 * @return double, valor da divisao com a multiplicacao
	 * 
	 * @author sprint2
	 * @author Lucas Grijo
	 * @author Marcelo Schaefer
	 */
	public double calcularDSR(double valorHorasExtras) {
		double diasUteis = 25.0;
		double domigosFeriados = 5.0;
		return (valorHorasExtras / diasUteis) * domigosFeriados;
	}

	/**
	 * calcula as ferias
	 * 
	 * o metodo verifica se o abono eh menor que 0, se for, valor de ferias eh igual
	 * ou valor dela mais um terco, se nao, calcula o abono e pega um terco dele
	 * 
	 * @param int dias
	 * @param int abono
	 * @param double valorHoras
	 * @return double valorTotalFerias
	 * 
	 * @author sprint2
	 * @author Lucas Grijo
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