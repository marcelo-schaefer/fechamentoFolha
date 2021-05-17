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
	public double porcentagemBonificacaoCargo;
	public double porcentagemBonificacaoSetor;
	public double porcentagemBonificacaoEmpresa;
	
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
	 * @return the porcentagemBonificacaoCargo
	 */
	public double getPorcentagemBonificacaoCargo() {
		return porcentagemBonificacaoCargo;
	}
	
	public Bonificacao(double porcentagemBonificacaoColaborador, double porcentagemBonificacaoSetor,
			double porcentagemBonificacaoEmpresa, double porcentagemBonificacaoCargo) {
		super();
		this.porcentagemBonificacaoColaborador = porcentagemBonificacaoColaborador;
		this.porcentagemBonificacaoSetor = porcentagemBonificacaoSetor;
		this.porcentagemBonificacaoEmpresa = porcentagemBonificacaoEmpresa;
	}	
	
	@Override
	public String toString() {
		return super.toString();
	}

}
