package br.com.proway.senior.model;

public class FolhaDirector {
	
	public InterfaceFolhaBuilder builder;
	
	public FolhaDirector(InterfaceFolhaBuilder builder){
		this.builder = builder;
	};
		
	public void createFolha(InterfaceColaboradorFolha colaborador, InterfacePontoFolha ponto, InterfaceFeriasFolha ferias, InterfaceCargoFolha cargo) {
		builder.setColaboradorFolha(colaborador);
		builder.setPonto(ponto);
		builder.setFerias(ferias);
		builder.setCargo(cargo);
		
		builder.setHorasTrabalhadas(ponto);
		builder.setHorasExtra(ponto);
		builder.setHorasFalta(ponto);
		builder.setValorBonificacao(cargo);
		builder.setPercentualInsalubridade(cargo);
		builder.setMensalidadePlanoSaude(colaborador);
		builder.setValorCooparticipacaoPlanoSaude(colaborador);
		builder.setSalarioBase(cargo);
		builder.setValeTransporte(colaborador);
		builder.setNumeroDependentes(colaborador);
		builder.setDias(ferias);
		builder.setAbono(ferias);
		//return (Folha) builder.build();
	}
}
