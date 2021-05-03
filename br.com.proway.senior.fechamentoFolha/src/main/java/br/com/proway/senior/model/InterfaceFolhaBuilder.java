package br.com.proway.senior.model;

import java.time.LocalDate;

public interface InterfaceFolhaBuilder {

	
	public void setColaboradorFolha(InterfaceColaboradorFolha colaboradorFolha);

	public void setPonto(InterfacePontoFolha ponto);

	public void setFerias(InterfaceFeriasFolha ferias);

	public void setCargo(InterfaceCargoFolha cargo);
	
	public void setId(InterfaceColaboradorFolha colaborador);

	public void setIdColaborador(Integer idColaborador);
		
	public void setDataEmissao(LocalDate dataEmissao);

	public void setSalarioLiquido(double salarioLiquido) ;

	public void setSalarioBruto(double salarioBruto);
	
	public void setValorHoras(double valorHoras);
	
	public void setValorHoraComInsalubridade(double valorHoraComInsalubridade);
		
	public void setHorasTrabalhadas(InterfacePontoFolha ponto);
		
	public void setHorasExtra(InterfacePontoFolha ponto);
	
	public void setValorHoraExtra(double valorHoraExtra);

	public double getReflexoDSR();

	public void setReflexoDSR(double reflexoDSR);

	public void setHorasFalta(InterfacePontoFolha ponto);

	public void setValorHorasFaltas(double valor);

	public void setValorBonificacao(InterfaceCargoFolha cargo);
	
	public void setPlanoSaude(double planoSaude);

	public void setPercentualInsalubridade(InterfaceCargoFolha cargo);

	public void setValorInsalubridade(double valorInsalubridade);

	public void setInss(double inss);

	public void setValorImpostoDeRenda(double valorImpostoDeRenda);

	public void setMensalidadePlanoSaude(InterfaceColaboradorFolha colab);

	public void setValorCooparticipacaoPlanoSaude(InterfaceColaboradorFolha colab);

	public void setValorValeTransporte(double valorValeTransporte);

	public boolean isValeTransporte();

	public void setValeTransporte(InterfaceColaboradorFolha colab);

	public void setFator(double fator);

	public void setSalarioMinimo(double salarioMinimo);

	public void setSalarioBase(InterfaceCargoFolha cargo);

	public void setNumeroDependentes(InterfaceColaboradorFolha colab);

	public void setValorPorDependente(double valorPorDependente);

	public void setDias(InterfaceFeriasFolha ferias);

	public void setAbono(InterfaceFeriasFolha ferias);
	
	public InterfaceFolha build();
}
