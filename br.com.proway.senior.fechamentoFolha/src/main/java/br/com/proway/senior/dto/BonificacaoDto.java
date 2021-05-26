package br.com.proway.senior.dto;

import br.com.proway.senior.dao.BonificacaoDAO;
import br.com.proway.senior.model.Bonificacao;

/**
 * <p>Classe DTO construida a partir da classe {@link BonificacaoDAO} </p>
 *
 * @author Sprint 6: David Willian dwillian676@gmail.com;
 * @author Sprint 6: Guilherme Ezequiel <guilhermeezequieldasilva@gmail.com>;
 * @author Sprint 6: Jonata Caetano <jonatacaetano88@gmail.com>
 * @author Sprint 6: Sabrina Schmidt <sabrinaschmidt335@gmail.com>;
 * @author Sprint 6: Samuel Levi <samuel.levi@senior.com.br>
 */
public class BonificacaoDto {
	
	
	public double porcentagemBonificacaoColaborador;

	public double getPorcentagemBonificacaoColaborador() {
		return porcentagemBonificacaoColaborador;
	}
	/**
	 * Construtor sera utilizado na classe {@link FolhaDto}.
	 * 
	 * @param porcentagemBonificacaoColaborador
	 */
	public BonificacaoDto(Bonificacao porcentagemBonificacaoColaborador) {
		this.porcentagemBonificacaoColaborador = porcentagemBonificacaoColaborador.getPorcentagemBonificacaoColaborador();
	}	
}
