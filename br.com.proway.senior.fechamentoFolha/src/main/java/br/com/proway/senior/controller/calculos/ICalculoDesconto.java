package br.com.proway.senior.controller.calculos;

import br.com.proway.senior.model.externo.interfaces.ICargoFolha;
import br.com.proway.senior.model.externo.interfaces.IColaboradorFolha;

/**
 * <h1>Interface para Calcular Descontos.</h1>
 * 
 * <p>Metodos implementados pela classe {@link CalculoDesconto}.</p>
 * 
 * @author Sprint 5: Leonardo Felipe Silva <felipeleao217@gmail.com>;
 * @author Sprint 5: Bruna Carvalho <sh4323202@gmail.com>;
 * @author Sprint 5: Leonardo Pereira <leonardopereirajr@gmail.com>;
 * @author Sprint 5: Sabrina Schmidt <sabrinaschmidt335@gmail.com>;
 * @author Sprint 5: Lucas Nunes <lucasnunes.ln365@gmail.com>.
 */
public interface ICalculoDesconto {
	public double calcularDescontoInss(double salarioBrutoAcumulado);
	public double calcularDescontoImpostoRenda(IColaboradorFolha colaboradorFolha, double salarioBrutoAcumulado);
	public double calcularDescontoPlanoSaude(IColaboradorFolha colaboradorFolha);	
	public double calcularDescontoValeTransporte(IColaboradorFolha colaboradorFolha, ICargoFolha cargoFolha);
	public double calcularFGTS(double salarioBrutoAcumulado);
}
