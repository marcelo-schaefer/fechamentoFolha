package br.com.proway.senior.controller;

import br.com.proway.senior.model.ICargoFolha;
import br.com.proway.senior.model.IColaboradorFolha;

public interface ICalculoDesconto {
	public double calcularDescontoInss(double salarioBrutoAcumulado);
	public double calcularDescontoImpostoRenda(IColaboradorFolha colaboradorFolha, double salarioBrutoAcumulado);
	public double calcularDescontoPlanoSaude(IColaboradorFolha colaboradorFolha);	
	public double calcularDescontoValeTransporte(IColaboradorFolha colaboradorFolha, ICargoFolha cargoFolha);
}
