/**
 * 
 */
package br.com.proway.senior.dto;

import br.com.proway.senior.model.Folha;
import br.com.proway.senior.model.externo.FeriasFolha;

/**
 * Classe que cria o DTO das ferias
 * 
 * @author Sabrina
 * @author Samuel
 * @author Jhonata
 * @author Guilherme
 * @author David
 *
 */
public class FolhaFeriasDto {

	private double valorFerias;
	private double valorInssFerias;
	private double valorImpostoDeRendaFerias;
	private double feriasLiquido;

	// Ferias
	int dias;
	int abono;

	/**
	 * Contrutor das ferias que implementa ferias e folha.
	 */
	public FolhaFeriasDto(FeriasFolha ferias, Folha folha) {
		// Folha
		this.valorFerias = folha.getValorFerias();
		this.valorInssFerias = folha.getValorInssFerias();
		this.valorImpostoDeRendaFerias = folha.getValorImpostoDeRendaFerias();
		this.feriasLiquido = folha.getFeriasLiquido();

		// Ferias(Externo)
		this.dias = ferias.getDias();
		this.abono = ferias.getAbono();
	}

	public double getValorFerias() {
		return valorFerias;
	}

	public double getValorInssFerias() {
		return valorInssFerias;
	}

	public double getValorImpostoDeRendaFerias() {
		return valorImpostoDeRendaFerias;
	}

	public double getFeriasLiquido() {
		return feriasLiquido;
	}

	public int getDias() {
		return dias;
	}

	public int getAbono() {
		return abono;
	}
}
