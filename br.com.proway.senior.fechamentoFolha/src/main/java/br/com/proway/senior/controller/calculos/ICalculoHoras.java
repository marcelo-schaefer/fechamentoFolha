package br.com.proway.senior.controller.calculos;

import br.com.proway.senior.model.externo.interfaces.ICargoFolha;
import br.com.proway.senior.model.externo.interfaces.IPontoFolha;

/**
 * Interface para Calcular Horas.
 * Metodos implementados pela classe {@link CalculoHoras}.
 * 
 * @author Leonardo Felipe Silva <felipeleao217@gmail.com>;
 * @author Bruna Carvalho <sh4323202@gmail.com>;
 * @author Leonardo Pereira <leonardopereirajr@gmail.com>;
 * @author Sabrina Schmidt <sabrinaschmidt335@gmail.com>;
 * @author Lucas Nunes <lucasnunes.ln365@gmail.com>.
 * 
 */
public interface ICalculoHoras {
	public double calcularValorHora(ICargoFolha cargoFolha);

	public double calcularValorDasHorasTrabalhadas(IPontoFolha pontoFolha, double valorHora);

	public double calcularValorHorasFaltas(IPontoFolha pontoFolha, double valorHora);

	public double calcularValorHorasExtras(IPontoFolha pontoFolha, double valorHora);

	public double calcularDSR(double valorHorasExtras);

	public double calcularFerias(int dias, int abono, double valorHora);
}
