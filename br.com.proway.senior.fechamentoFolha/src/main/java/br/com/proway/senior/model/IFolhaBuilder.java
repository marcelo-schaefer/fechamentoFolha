package br.com.proway.senior.model;

import br.com.proway.senior.model.externo.interfaces.ICargoFolha;
import br.com.proway.senior.model.externo.interfaces.IColaboradorFolha;
import br.com.proway.senior.model.externo.interfaces.IFeriasFolha;
import br.com.proway.senior.model.externo.interfaces.IPlr;
import br.com.proway.senior.model.externo.interfaces.IPontoFolha;

/**
 * IFolhaBuilder
 * 
 * Especifica um builder de folhas para ser utilizada pelo director.
 * 
 * @author Lucas Grij�
 * @author Lucas Walim
 * @author Marcelo Schaefer
 */	
public interface IFolhaBuilder {
	
	public void iniciarCalculos(IColaboradorFolha colaborador, ICargoFolha cargo);
	public void calcularHorasNormais(IPontoFolha ponto, ICargoFolha cargo, IPlr plr);
	public void calcularDescontoNormal(IColaboradorFolha colaborador, ICargoFolha cargo, IPlr plr);
	public void calcularHorasFerias(IFeriasFolha feriasFolha);
	public void calcularDescontoFerias(IColaboradorFolha colaborador);
	public Folha build();
}
