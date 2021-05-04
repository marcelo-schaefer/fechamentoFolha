package br.com.proway.senior.controller.calculos;

import br.com.proway.senior.model.externo.ICargoFolha;
import br.com.proway.senior.model.externo.IPontoFolha;

public interface ICalculoHoras {
	public double calcularValorHora(ICargoFolha cargoFolha);
	public double calcularValorDasHorasTrabalhadas(IPontoFolha pontoFolha, double valorHora);
	public double calcularValorHorasFaltas(IPontoFolha pontoFolha, double valorHora);
	public double calcularValorHorasExtras(IPontoFolha pontoFolha, double valorHorasTrabalhadas, double valorHora);
	public double calcularDSR(double valorHorasExtras);
	public double calcularFerias(int dias, int abono, double valorHora);
}
