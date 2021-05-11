package br.com.proway.senior.controller.calculos;

import br.com.proway.senior.model.externo.interfaces.ICargoFolha;
import br.com.proway.senior.model.externo.interfaces.IColaboradorFolha;

public interface ICalculoDesconto {
	public double calcularDescontoInss(double salarioBrutoAcumulado);
	public double calcularDescontoImpostoRenda(IColaboradorFolha colaboradorFolha, double salarioBrutoAcumulado);
	public double calcularDescontoPlanoSaude(IColaboradorFolha colaboradorFolha);	
	public double calcularDescontoValeTransporte(IColaboradorFolha colaboradorFolha, ICargoFolha cargoFolha);
	public double calcularFGTS(double salarioBrutoAcumulado);
}
