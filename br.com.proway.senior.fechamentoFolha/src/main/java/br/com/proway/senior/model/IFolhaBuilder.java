package br.com.proway.senior.model;

import br.com.proway.senior.model.externo.interfaces.ICargoFolha;
import br.com.proway.senior.model.externo.interfaces.IColaboradorFolha;
import br.com.proway.senior.model.externo.interfaces.IFeriasFolha;
import br.com.proway.senior.model.externo.interfaces.IPontoFolha;

/**
 * Interface IFolhaBuilder.
 * 
 * Metodos implementados pela classe {@link FolhaBuilder}.
 * Especifica um builder de folhas para ser utilizada pelo director.
 * 
 * @author Lucas Grij�
 * @author Lucas Walim
 * @author Marcelo Schaefer
 * 
 * Sprint 5:
 * @author Leonardo Felipe Silva <felipeleao217@gmail.com>;
 * @author Bruna Carvalho <sh4323202@gmail.com>;
 * @author Leonardo Pereira <leonardopereirajr@gmail.com>;
 * @author Sabrina Schmidt <sabrinaschmidt335@gmail.com>;
 * @author Lucas Nunes <lucasnunes.ln365@gmail.com>.
 */	
public interface IFolhaBuilder {
	
	public void iniciarCalculos(IColaboradorFolha colaborador, ICargoFolha cargo);
	public void setDataEmissaoFolha();
	public double atribuiBonificacaoColaborador(ICargoFolha cargo, Bonificacao bonificacao);
	public void calcularHorasNormais(IPontoFolha ponto, ICargoFolha cargo);
	public void calcularDescontoNormal(IColaboradorFolha colaborador, ICargoFolha cargo);
	public void calcularHorasFerias(IFeriasFolha feriasFolha);
	public void calcularDescontoFerias(IColaboradorFolha colaborador);
	public void calcularPlr();
	public Folha build();
}
