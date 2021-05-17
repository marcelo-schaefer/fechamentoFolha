/**
 * 
 */
package br.com.proway.senior.model;

import br.com.proway.senior.model.externo.CargoFolha;

/**Classe que implementa o valor da bonificação por Setor/Colaborador/Empresa
 * 
 * @author Sabrina sabrinaschmidt335@gmail.com
 * @author Leo P leonardo.pereira@senior.com.br
 * @author Lucas N. lucas.nunes@Senior.com.br
 * 
 *  
 */
public class Bonificacao {
	
	public double porcentagemBonificacaoColaborador;
	public double porcentagemBonificacaoSetor;
	public double porcentagemBonificacaoEmpresa;
	//public double porcentagemBonificacaoCargo;
	CargoFolha c;
	private double porcentagemBonificacaoCargo;
	/**
	 * @return the porcentagemBonificacaoColaborador
	 */
	public double getPorcentagemBonificacaoColaborador() {
		return porcentagemBonificacaoColaborador;
	}
	/**
	 * @return the porcentagemBonificacaoSetor
	 */
	public double getPorcentagemBonificacaoSetor() {
		return porcentagemBonificacaoSetor;
	}
	/**
	 * @return the porcentagemBonificacaoEmpresa
	 */
	public double getPorcentagemBonificacaoEmpresa() {
		return porcentagemBonificacaoEmpresa;
	}
	/**
	 * Metodo Bonificacao que recebe 
	 * @param porcentagemBonificacaoColaborador, porcentagemBonificacaoSetor,
	 * porcentagemBonificacaoEmpresa, porcentagemBonificacaoCargo
	 *  
	 */
		
	public Bonificacao(double porcentagemBonificacaoColaborador, double porcentagemBonificacaoSetor,
			double porcentagemBonificacaoEmpresa, double porcentagemBonificacaoCargo) {
		super();
		this.porcentagemBonificacaoColaborador = porcentagemBonificacaoColaborador;
		this.porcentagemBonificacaoSetor = porcentagemBonificacaoSetor;
		this.porcentagemBonificacaoEmpresa = porcentagemBonificacaoEmpresa;
		this.porcentagemBonificacaoCargo = c.getPorcentagemBonificacaoCargo();
	}

	
	/**
	 * @param bonificacao the porcentagemBonificacaoColaborador to set
	 */
	public void setPorcentagemBonificacaoColaborador(double bonificacao) {
		this.porcentagemBonificacaoColaborador = (bonificacao/100);
	}
	
	/**
	 * @param bonificacao the porcentagemBonificacaoCargo to set
	
	public void setPorcentagemBonificacaoCargo(double bonificacao) {
		c.setPorcentagemBonificacaoCargo(bonificacao/100);
	}*/
	/**
	 * @param bonificacao the porcentagemBonificacaoSetor to set
	 
	public void setPorcentagemBonificacaoSetor(double bonificacao) {
		this.porcentagemBonificacaoSetor = (bonificacao/100);
	}
	
	 * @param bonificacao the porcentagemBonificacaoEmpresa to set
	 
	public void setPorcentagemBonificacaoEmpresa(double bonificacao) {
		this.porcentagemBonificacaoEmpresa = (bonificacao/100);
	}*/
	
	@Override
	public String toString() {
		return super.toString();
	}

}
