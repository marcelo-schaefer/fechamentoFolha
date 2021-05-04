package br.com.proway.senior.model;

import java.time.LocalDate;

import br.com.proway.senior.controller.CalculoDesconto;
import br.com.proway.senior.controller.CalculoHoras;
import br.com.proway.senior.controller.ICalculoDesconto;
import br.com.proway.senior.controller.ICalculoHoras;

public class FolhaBuilder implements IFolhaBuilder {

	private int id; //
	private Integer idColaborador; 
	private LocalDate dataEmissao; 
	
	// Folha Normal
	private double valorHorasTrabalhadas;
	private double valorHorasFaltas; 
	private double valorHorasExtras; 
	private double valorReflexoDSR;
	private double valorInss;
	private double valorImpostoDeRenda;	
	private double valorPlanoSaude; 
	private double valorValeTransporte;
	private double salarioBruto = 0;
	private double salarioLiquido;
	
	// Folha F�rias
	private double valorFerias; // f�rias bruto.
	private double valorInssFerias;
	private double valorImpostoDeRendaFerias;
	private double feriasLiquido;
	
	// Dados Externos
	private IColaboradorFolha colaboradorFolha;
	private IPontoFolha ponto;
	private IFeriasFolha ferias;
	private ICargoFolha cargo;

	
	// Dados de Cria��o
	private ICalculoHoras calculoHoras;
	private ICalculoDesconto calculoDesconto;
	private double valorHora;

	public Folha build() {
		dataEmissao = LocalDate.now();
		return new Folha(id, idColaborador, dataEmissao, valorHorasTrabalhadas,
				valorHorasFaltas, valorHorasExtras, valorReflexoDSR, valorInss,
				valorImpostoDeRenda, valorPlanoSaude, valorValeTransporte, salarioBruto,
				salarioLiquido, valorFerias, valorInssFerias, valorImpostoDeRendaFerias,
				feriasLiquido);
	}
	
	public void iniciarCalculos(IColaboradorFolha colaborador, ICargoFolha cargo) {
		idColaborador = colaborador.getId();
		this.calculoHoras = new CalculoHoras();
		this.calculoDesconto = new CalculoDesconto();
		valorHora = (calculoHoras.calculaValorHora(cargo));
		
	}

	// FOLHA NORMAL
	
	public void calcularHorasNormais(IPontoFolha ponto, ICargoFolha cargo){	
		valorHorasTrabalhadas = (calculoHoras.calcularValorDasHorasTrabalhadas(ponto, valorHora));
		valorHorasFaltas = (calculoHoras.calcularValorHorasFaltas(ponto, valorHora));
		valorHorasExtras = (calculoHoras.calcularValorHorasExtras(ponto, valorHorasTrabalhadas, valorHora));
		valorReflexoDSR = (calculoHoras.calcularDSR());
		salarioBruto = (valorHorasTrabalhadas - valorHorasFaltas + valorHorasExtras + valorReflexoDSR);
	}
	
	public void calcularDescontoNormal(IColaboradorFolha colaborador, ICargoFolha cargo){
		valorInss = (calculoDesconto.calcularDescontoInss(salarioBruto));
		salarioLiquido = (salarioBruto - valorInss);
		valorImpostoDeRenda = (calculoDesconto.calcularDescontoImpostoRenda(colaborador, salarioLiquido));
		valorPlanoSaude = (calculoDesconto.calcularDescontoPlanoSaude(colaborador));
		valorValeTransporte = (calculoDesconto.calcularDescontoValeTransporte(colaborador, cargo));
		salarioLiquido = (salarioLiquido - valorValeTransporte - valorImpostoDeRenda - valorPlanoSaude);
	}
	
	// FOLHA FERIAS
	
	public void calcularHorasFerias(IFeriasFolha feriasFolha) {
		valorFerias = (calculoHoras.calcularFerias(feriasFolha.getDias(), feriasFolha.getAbono(), valorHora));
	}
	
	public void calcularDescontoFerias(IColaboradorFolha colaborador) {
		valorInssFerias = (calculoDesconto.calcularDescontoInss(valorFerias));
		feriasLiquido = (valorFerias - valorInssFerias);
		valorImpostoDeRendaFerias = (calculoDesconto.calcularDescontoImpostoRenda(colaborador, feriasLiquido));
		feriasLiquido = (feriasLiquido - valorImpostoDeRendaFerias);
	}
	

}
