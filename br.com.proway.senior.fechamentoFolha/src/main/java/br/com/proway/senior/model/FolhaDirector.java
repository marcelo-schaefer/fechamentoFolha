package br.com.proway.senior.model;

public class FolhaDirector {
	
	public IFolhaBuilder builder;
	
	public FolhaDirector(IFolhaBuilder builder){
		this.builder = builder;
	};
			
	public void createFolhaNormal(IColaboradorFolha colaborador, IPontoFolha ponto, ICargoFolha cargo) {
		builder.iniciarCalculos(colaborador, cargo);
		builder.calcularHorasNormais(ponto, cargo);
		builder.calcularDescontoNormal(colaborador, cargo);
		builder.build();
	}
	
	public void createFolhaFerias(IColaboradorFolha colaborador, IFeriasFolha ferias, ICargoFolha cargo) {
		builder.iniciarCalculos(colaborador, cargo);			
		builder.calcularHorasFerias(ferias);
		builder.calcularDescontoFerias(colaborador);
		builder.build();
	}
		
	public void createFolhaHibrida(IColaboradorFolha colaborador, IPontoFolha ponto, ICargoFolha cargo, IFeriasFolha ferias) {
		builder.iniciarCalculos(colaborador, cargo);	
		builder.calcularHorasNormais(ponto, cargo);
		builder.calcularDescontoNormal(colaborador, cargo);
		builder.calcularHorasFerias(ferias);
		builder.calcularDescontoFerias(colaborador);
		builder.build();				
	}

}
