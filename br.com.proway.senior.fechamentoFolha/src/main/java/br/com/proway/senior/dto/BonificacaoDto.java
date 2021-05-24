package br.com.proway.senior.dto;
/**
 * Cria Get e Contrutor.
 * Necesserario para a contrucao da bonificacaoDto.
 * 
 * @author Guilherme Ezequiel
 *
 */
public class BonificacaoDto {
	
	public double porcentagemBonificacaoColaborador;

	public double getPorcentagemBonificacaoColaborador() {
		return porcentagemBonificacaoColaborador;
	}
	/**
	 * Construtor Folha DTO.
	 * Construido a partir da classe Bonificação.
	 * 
	 * 
	 * @param porcentagemBonificacaoColaborador
	 */
	public BonificacaoDto(double porcentagemBonificacaoColaborador) {
		this.porcentagemBonificacaoColaborador = porcentagemBonificacaoColaborador;
	}	
}
