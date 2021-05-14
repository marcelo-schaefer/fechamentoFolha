package br.com.proway.senior.controller.calculos;

import br.com.proway.senior.model.externo.interfaces.ICargoFolha;
import br.com.proway.senior.model.externo.interfaces.IColaboradorFolha;

/**
 * Interface para Calcular Descontos.
 * Metodos implementados pela classe {@link CalculoDesconto}.
 * 
 * @author Leonardo Felipe Silva <felipeleao217@gmail.com>;
 * @author Bruna Carvalho <sh4323202@gmail.com>;
 * @author Leonardo Pereira <leonardopereirajr@gmail.com>;
 * @author Sabrina Schmidt <sabrinaschmidt335@gmail.com>;
 * @author Lucas Nunes <lucasnunes.ln365@gmail.com>.
 *
 */
public interface ICalculoDesconto {
	public double calcularDescontoInss(double salarioBrutoAcumulado);
	public double calcularDescontoImpostoRenda(IColaboradorFolha colaboradorFolha, double salarioBrutoAcumulado);
	public double calcularDescontoPlanoSaude(IColaboradorFolha colaboradorFolha);	
	public double calcularDescontoValeTransporte(IColaboradorFolha colaboradorFolha, ICargoFolha cargoFolha);
	public double calcularFGTS(double salarioBrutoAcumulado);
}
