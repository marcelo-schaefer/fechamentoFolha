package br.com.proway.senior.dto;

import java.time.LocalDate;

import br.com.proway.senior.model.Plr;

/**
 * Classe que instancia os valores da PLR, do Colaborador.
 * 
 * @author Sprint 6: David Willian <dwillian676@gmail.com;
 * @author Sprint 6: Guilherme Ezequiel <guilhermeezequieldasilva@gmail.com>;
 * @author Sprint 6: Jonata Caetano <jonatacaetano88@gmail.com>
 * @author Sprint 6: Sabrina Schmidt <sabrinaschmidt335@gmail.com>;
 * @author Sprint 6: Samuel Levi <samuel.levi@senior.com.br>
 *
 */

public class PlrDto {

	/**
	 * Atributos da Classe PlrDto
	 */
	private double valorPlr;
	private LocalDate vencimento;

	/**
	 * Construtor Plr DTO construida a partir da PLR, do Colaborador
	 */
	public PlrDto(Plr plr) {

		// Plr
		this.valorPlr = plr.getValorPlr();
		this.vencimento = plr.getVencimento();

	}

	public double getValorPlr() {
		return valorPlr;
	}

	public LocalDate getVencimento() {
		return vencimento;
	}

}