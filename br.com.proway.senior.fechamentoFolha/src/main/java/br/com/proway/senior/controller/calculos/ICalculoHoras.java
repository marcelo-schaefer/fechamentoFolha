package br.com.proway.senior.controller.calculos;

import br.com.proway.senior.model.externo.interfaces.ICargoFolha;
import br.com.proway.senior.model.externo.interfaces.IPontoFolha;

/**
 * <h1>Interface para Calcular Horas.</h1>
 * 
 * <p>Metodos implementados pela classe {@link CalculoHoras}.</p>
 * 
 * @author Sprint 5: Leonardo Felipe Silva <felipeleao217@gmail.com>;
 * @author Sprint 5: Bruna Carvalho <sh4323202@gmail.com>;
 * @author Sprint 5: Leonardo Pereira <leonardopereirajr@gmail.com>;
 * @author Sprint 5: Sabrina Schmidt <sabrinaschmidt335@gmail.com>;
 * @author Sprint 5: Lucas Nunes <lucasnunes.ln365@gmail.com>.
 */
public interface ICalculoHoras {
	public double calcularValorHora(ICargoFolha cargoFolha);

	public double calcularValorDasHorasTrabalhadas(IPontoFolha pontoFolha, double valorHora);

	public double calcularValorHorasFaltas(IPontoFolha pontoFolha, double valorHora);

	public double calcularValorHorasExtras(IPontoFolha pontoFolha, double valorHora);

	public double calcularDSR(double valorHorasExtras);

	public double calcularFerias(int dias, int abono, double valorHora);
}
