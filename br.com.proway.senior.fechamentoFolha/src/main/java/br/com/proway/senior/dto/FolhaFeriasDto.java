/**
 * 
 */
package br.com.proway.senior.dto;

import br.com.proway.senior.model.Folha;
import br.com.proway.senior.model.externo.FeriasFolha;

/**
 * Classe que cria o DTO das Ferias do Colaborador.
 * 
 * @author Sprint 6: <a href="mailto:dwillian676@gmail.com?subject=FolhaDTO" title="">David Willian</a>
 * @author Sprint 6: <a href="mailto:guilhermeezequieldasilva@gmail.com?subject=FolhaDTO" title="">Guilherme Ezequiel</a>
 * @author Sprint 6: <a href="mailto:jonatacaetano88@gmail.com?subject=FolhaDTO" title="">Jônata Caetano</a>
 * @author Sprint 6: <a href="mailto:sabrinaschmidt335@gmail.com?subject=FolhaDTO" title="">Sabrina Schmidt</a>
 * @author Sprint 6: <a href="mailto:samuel.levi@senior.com.br?subject=FolhaDTO" title="">Samuel Levi</a>
 * 
 *
 */
public class FolhaFeriasDto {

	private double valorFerias;
	private double valorInssFerias;
	private double valorImpostoDeRendaFerias;
	private double feriasLiquido;

	// Atributos que serão recebidos do Modulo Ferias.
	int dias;
	int abono;

	/**
	 * Contrutor das ferias que implementa ferias e folha.
	 */
	public FolhaFeriasDto(FeriasFolha ferias, Folha folha) {
		// Atributos oriundos da Classe Folha
		this.valorFerias = folha.getValorFerias();
		this.valorInssFerias = folha.getValorInssFerias();
		this.valorImpostoDeRendaFerias = folha.getValorImpostoDeRendaFerias();
		this.feriasLiquido = folha.getFeriasLiquido();
		// Atributos oriundos da Classe Ferias (Modulo Externo).
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
