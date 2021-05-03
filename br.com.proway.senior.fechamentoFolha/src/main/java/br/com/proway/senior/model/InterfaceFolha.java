package br.com.proway.senior.model;

import java.time.LocalDate;

public interface InterfaceFolha {

	public int getId(); 
	
	public void setId(InterfaceColaboradorFolha colaborador); 
	
	public Integer getIdColaborador(); 
	

	public void setIdColaborador(Integer idColaborador); 
	

	public LocalDate getDataEmissao(); 
	

	public void setDataEmissao(LocalDate dataEmissao); 
	

	public double getSalarioLiquido(); 
	

	public void setSalarioLiquido(double salarioLiquido); 
	

	public double getSalarioBruto(); 
	

	public void setSalarioBruto(double salarioBruto); 
	

	public double getValorHoras(); 
	

	public void setValorHoras(double valorHoras); 
	

	public double getValorHoraComInsalubridade(); 
	

	public void setValorHoraComInsalubridade(double valorHoraComInsalubridade); 
	

	public double getHorasTrabalhadas(); 
	

	public void setHorasTrabalhadas(InterfacePontoFolha ponto); 
	

	public double getHorasExtra(); 
	

	public void setHorasExtra(InterfacePontoFolha ponto); 
	

	public double getValorHoraExtra(); 
	

	public void setValorHoraExtra(double valorHoraExtra); 
	

	public double getReflexoDSR(); 
	

	public void setReflexoDSR(double reflexoDSR); 
	

	public double getHorasFalta(); 
	

	public void setHorasFalta(double horasFalta); 
	

	public double getValorHorasFaltas(); 
	

	public void setValorHorasFaltas(InterfacePontoFolha ponto); 
	

	public double getValorBonificacao(); 
	

	public void setValorBonificacao(InterfaceCargoFolha cargo); 
	

	public double getPlanoSaude(); 
	

	public void setPlanoSaude(double planoSaude); 
	

	public double getPercentualInsalubridade(); 
	

	public void setPercentualInsalubridade(InterfaceCargoFolha cargo); 
	

	public double getValorInsalubridade(); 
	

	public void setValorInsalubridade(double valorInsalubridade); 
	

	public double getInss(); 
	

	public void setInss(double inss); 
	

	public double getValorImpostoDeRenda(); 
	

	public void setValorImpostoDeRenda(double valorImpostoDeRenda); 
	

	public double getMensalidadePlanoSaude(); 
	

	public void setMensalidadePlanoSaude(InterfaceColaboradorFolha colab); 
	

	public double getValorCooparticipacaoPlanoSaude(); 
	

	public void setValorCooparticipacaoPlanoSaude(InterfaceColaboradorFolha colab); 
	

	public double getValorValeTransporte(); 
	

	public void setValorValeTransporte(double valorValeTransporte); 
	

	public boolean isValeTransporte(); 

	public void setValeTransporte(InterfaceColaboradorFolha colab); 
	

	public double getFator(); 
	

	public void setFator(double fator); 
	

	public double getSalarioMinimo(); 
	

	public void setSalarioMinimo(double salarioMinimo); 
	

	public double getSalarioBase(); 
	

	public void setSalarioBase(InterfaceCargoFolha cargo); 
	

	public int getNumeroDependentes(); 
	

	public void setNumeroDependentes(InterfaceColaboradorFolha colab); 
	

	public double getValorPorDependente(); 
	

	public void setValorPorDependente(double valorPorDependente); 
	

	public int getDias(); 
	

	public void setDias(InterfaceFeriasFolha ferias); 
	

	public int getAbono(); 
	

	public void setAbono(InterfaceFeriasFolha ferias); 
	
}
