package br.com.proway.senior.controller.calculos;

import br.com.proway.senior.model.externo.CargoFolha;
import br.com.proway.senior.model.externo.ColaboradorFolha;
import br.com.proway.senior.model.externo.FeriasFolha;
import br.com.proway.senior.model.externo.PontoFolha;
import br.com.proway.senior.model.externo.interfaces.ICargoFolha;
import br.com.proway.senior.model.externo.interfaces.IPontoFolha;

/**
 * <h1>Calcular horas</h1>
 * 
 * <p>Classe que pussui todos os metodos de calculos relacionados a 
 * soma no salario bruto.</p>
 * 
 * @author Sprint 4: Lucas Grijo
 * @author Sprint 4: Lucas walim
 * @author Sprint 4: Marcelo Schaefer
 *
 * @author Sprint 5: Leonardo Felipe Silva <felipeleao217@gmail.com>;
 * @author Sprint 5: Bruna Carvalho <sh4323202@gmail.com>;
 * @author Sprint 5: Leonardo Pereira <leonardopereirajr@gmail.com>;
 * @author Sprint 5: Sabrina Schmidt <sabrinaschmidt335@gmail.com>;
 * @author Sprint 5: Lucas Nunes <lucasnunes.ln365@gmail.com>.
 */
public class CalculoHoras implements ICalculoHoras {

	/***
	 * <h1>Referente ao salario minimo</h1>
	 * 
	 * <p>Valor de um salario minimo</p>
	 */
	private double salarioMinimo = 1100;
	
	/***
	 * <h1>Referente ao fator de hora extra</h1>
	 * 
	 * <p>Valor em porcentagem da hora extra</p>
	 */
	private double fator = 0.5;
	
	/***
	 * <h1>Valor da hora</h1>
	 * 
	 * <p>Valor da hora referente a 30 dias</p>
	 */
	final double valorHorasDias = (double) 220 / 30;

	/**
	 * <h1>Calcula o valor das horas</h1>
	 * 
	 * <p>Chama o metodo de calcular insalubridade {@link CalculoHoras#calcularInsalubridade(ICargoFolha)} 
	 * dividido por 220, verifica se é menor que 0. Se sim, retorna salario
	 * base dividido por 220, se nao, retorna o mesmo mais o valor da insalubridade.</p>
	 *
	 * @param cargoFolha {@link ICargoFolha}, referente ao {@link CargoFolha}.
	 * 
	 * @return double, referente ao salario base com mudancas.
	 * 
	 * @author Sprint 4: Lucas Grijo
	 * @author Sprint 4: Lucas walim
	 * @author Sprint 4: Marcelo Schaefer
	 * 
	 * @see CalculoHoras#calcularInsalubridade(ICargoFolha)
	 * @see ICargoFolha
	 * @see CargoFolha
	 */
	public double calcularValorHora(ICargoFolha cargoFolha) {
		double valorHoraInsalubridade = calcularInsalubridade(cargoFolha) / 220;
		if (valorHoraInsalubridade <= 0) {
			return cargoFolha.getSalarioBase() / 220;
		} else {
			return ((cargoFolha.getSalarioBase() / 220) + valorHoraInsalubridade);
		}
	}
	
	/***
	 * <h1>Calcula o valor das horas que foram trabalhadas.</h1>
	 * 
	 * <p>O metodo multiplica e retorna o falor da multiplicacao entre o valor das
	 * horas e quantas horas o {@link ColaboradorFolha} trabalhou.</p>
	 * 
	 * @param pontoFolha {@link IPontoFolha}, referente ao {@link PontoFolha};
	 * @param valorHora double, referente ao valor da hora.
	 * 
	 * @return double, referente ao valor de horas trabalhadas.
	 * 
	 * @author Sprint 4: Lucas Grijo
	 * @author Sprint 4: Lucas walim
	 * @author Sprint 4: Marcelo Schaefer
	 * 
	 * @see ColaboradorFolha
	 * @see IPontoFolha
	 * @see PontoFolha
	 */
	public double calcularValorDasHorasTrabalhadas(IPontoFolha pontoFolha, double valorHora) {
		return valorHora * pontoFolha.getHorasTrabalhadas();
	}

	/**
	 * <h1>Calcula o valor da insalubridade</h1>
	 * 
	 * <p>Realiza o calculo do valor a ser implementado no {@link CalculoHoras#salarioMinimo},
	 *  vai pegar a variavel {@link CalculoHoras#salarioMinimo} e multiplicar pela sua faixa
	 *  de insalubridade, dependendode onde ela se encaixar.</p>
	 * 
	 * @param cargoFolha {@link ICargoFolha}, referente ao {@link CargoFolha}.
	 * 
	 * @return double, referente ao salario minimo com mudancas.
	 * 
	 * @author Sprint 4: Lucas Grijo
	 * @author Sprint 4: Lucas walim
	 * @author Sprint 4: Marcelo Schaefer
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
	 * <h1>Calcula o valor a ser descontado de horas faltas.</h1>
	 * 
	 * <p>Realiza o cálculo das horas faltas a serem descontadas na folha do
	 * {@link ColaboradorFolha}, recebe o valor de horasFalta e 
	 * multiplica pelo valor da hora.</p>
	 * 
	 * @param pontoFolha {@link IPontoFolha}, referente ao {@link PontoFolha};
	 * @param double valorHora, referente ao valor da hora.
	 * 
	 * @return double, referente ao valor de horas faltas. 
	 * 
	 * @author Sprint 4: Lucas Grijo
	 * @author Sprint 4: Lucas walim
	 * @author Sprint 4: Marcelo Schaefer
	 * 
	 * @see ColaboradorFolha
	 * @see IPontoFolha
	 * @see PontoFolha
	 */
	public double calcularValorHorasFaltas(IPontoFolha pontoFolha, double valorHora) {
		return pontoFolha.getHorasFaltas() * valorHora;
	}

	/**
	 * <h1>Calcula o valor horas extras.</h1>
	 * 
	 * <p>O valor retornado da multiplicao com o valor de horas e {@link CalculoHoras#fator}, 
	 * vai somar com o valor de horas e depois multiplica pelas horas extras.</p>
	 * 
	 * @param pontoFolha {@link IPontoFolha}, referente ao {@link PontoFolha};
	 * @param double valorHora, referente ao valor de horas.
	 * 
	 * @return valor, referente ao valor de horas extras
	 * 
	 * @author Sprint 4: Lucas Grijo
	 * @author Sprint 4: Lucas walim
	 * @author Sprint 4: Marcelo Schaefer
	 * 
	 * @see CalculoHoras#fator
	 * @see IPontoFolha
	 * @see PontoFolha
	 */
	public double calcularValorHorasExtras(IPontoFolha pontoFolha, double valorHora) {
		return pontoFolha.getHorasExtra() * (valorHora + (valorHora * fator));
	}

	/**
	 * <h1>Calcula valor DSR.</h1>
	 * 
	 * <p>O metodo pega a data atual, adciona em uma lista todos os dias do mes atual
	 * que sao dias uteis, depois usa com variavel os dias uteis a partir do tamanho
	 * da lista, e os dias de domingo como a diferenca entre o tamanho da lista e a
	 * quantidade de dias no mes.</p>
	 * 
	 * @param valorHorasExtras double, valor das horas extras do {@link ColaboradorFolha}
	 * 
	 * @return double, valor da divisao com a multiplicacao.
	 * 
	 * @author Sprint 4: Lucas Grijo
	 * @author Sprint 4: Marcelo Schaefer
	 */
	public double calcularDSR(double valorHorasExtras) {
		double diasUteis = 25.0;
		double domigosFeriados = 5.0;
		return (valorHorasExtras / diasUteis) * domigosFeriados;
	}

	/**
	 * <h1>Calcula as ferias.</h1>
	 * 
	 * <p>O metodo verifica se o abono eh menor que 0, se for, valor de ferias eh igual
	 * ou valor dela mais um terco, se nao, calcula o abono e pega um terco dele.</p>
	 * 
	 * @param dias int, referente aos dias;
	 * @param abono int, referente ao abono;
	 * @param valorHoras double, referente ao valor da hora;
	 * 
	 * @return double, referente ao valor total de {@link FeriasFolha}.
	 * 
	 * @author Sprint 4: Lucas Grijo
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