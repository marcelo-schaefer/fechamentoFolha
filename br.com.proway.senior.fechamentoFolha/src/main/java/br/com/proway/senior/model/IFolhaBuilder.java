package br.com.proway.senior.model;

public interface IFolhaBuilder {
	
	public void iniciarCalculos(IColaboradorFolha colaborador, ICargoFolha cargo);
	public void calcularHorasNormais(IPontoFolha ponto, ICargoFolha cargo);
	public void calcularDescontoNormal(IColaboradorFolha colaborador, ICargoFolha cargo);
	public void calcularHorasFerias(IFeriasFolha feriasFolha);
	public void calcularDescontoFerias(IColaboradorFolha colaborador);
	public Folha build();
}
