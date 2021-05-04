package br.com.proway.senior.model;

import java.time.LocalDate;

import br.com.proway.senior.controller.calculos.CalculoDesconto;
import br.com.proway.senior.controller.calculos.CalculoHoras;
import br.com.proway.senior.controller.calculos.ICalculoDesconto;
import br.com.proway.senior.controller.calculos.ICalculoHoras;
import br.com.proway.senior.model.externo.ICargoFolha;
import br.com.proway.senior.model.externo.IColaboradorFolha;
import br.com.proway.senior.model.externo.IFeriasFolha;
import br.com.proway.senior.model.externo.IPontoFolha;

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
	
	// Folha Férias
	private double valorFerias; // férias bruto.
	private double valorInssFerias;
	private double valorImpostoDeRendaFerias;
	private double feriasLiquido;
		
	// Dados de Criação
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
		valorHora = (calculoHoras.calcularValorHora(cargo));
		
	}

	// FOLHA NORMAL
	
	public void calcularHorasNormais(IPontoFolha ponto, ICargoFolha cargo){	
		valorHorasTrabalhadas = (calculoHoras.calcularValorDasHorasTrabalhadas(ponto, valorHora));
		valorHorasFaltas = (calculoHoras.calcularValorHorasFaltas(ponto, valorHora));
		valorHorasExtras = (calculoHoras.calcularValorHorasExtras(ponto, valorHorasTrabalhadas, valorHora));
		valorReflexoDSR = (calculoHoras.calcularDSR(valorHorasExtras));
		salarioBruto = (valorHorasTrabalhadas - valorHorasFaltas + valorHorasExtras + valorReflexoDSR);
	}
	
	public void calcularDescontoNormal(IColaboradorFolha colaborador, ICargoFolha cargo){
		valorInss = (calculoDesconto.calcularDescontoInss(salarioBruto));
		salarioLiquido = (salarioBruto - valorInss);
		valorImpostoDeRenda = (calculoDesconto.calcularDescontoImpostoRenda(colaborador, salarioLiquido));
		valorPlanoSaude = (calculoDesconto.calcularDescontoPlanoSaude(colaborador));
		valorValeTransporte = (calculoDesconto.calcularDescontoValeTransporte(colaborador, cargo));
		salarioLiquido = (salarioBruto - valorValeTransporte - valorImpostoDeRenda - valorPlanoSaude);
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
