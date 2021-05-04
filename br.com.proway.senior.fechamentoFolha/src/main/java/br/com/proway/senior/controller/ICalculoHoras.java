package br.com.proway.senior.controller;

import br.com.proway.senior.model.ICargoFolha;
import br.com.proway.senior.model.IPontoFolha;

public interface ICalculoHoras {
	public double calculaValorHora(ICargoFolha cargoFolha);
	public double calcularValorDasHorasTrabalhadas(IPontoFolha pontoFolha, double valorHora);
	public double calcularValorHorasFaltas(IPontoFolha pontoFolha, double valorHora);
	public double calcularValorHorasExtras(IPontoFolha pontoFolha, double valorHorasTrabalhadas, double valorHora);
	public double calcularDSR(double valorHorasExtras);
	public double calcularFerias(int dias, int abono, double valorHora);
}
