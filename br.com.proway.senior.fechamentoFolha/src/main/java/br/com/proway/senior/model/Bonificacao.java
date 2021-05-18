/**
 * 
 */
package br.com.proway.senior.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe que implementa o valor da bonificação por Setor/Colaborador/Empresa
 * 
 * @author Sabrina sabrinaschmidt335@gmail.com
 * @author Leo P leonardo.pereira@senior.com.br
 * @author Lucas N. lucas.nunes@Senior.com.br
 * 
 * 
 */
@Entity
@Table(name = "bonificacao")
public class Bonificacao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	public double porcentagemBonificacaoColaborador;
	public double porcentagemBonificacaoCargo;

	/**
	 * @return the porcentagemBonificacaoColaborador
	 */
	public double getPorcentagemBonificacaoColaborador() {
		return porcentagemBonificacaoColaborador;
	}

	/**
	 * @return the porcentagemBonificacaoCargo
	 */
	public double getPorcentagemBonificacaoCargo() {
		return porcentagemBonificacaoCargo;
	}

	/**
	 * 
	 * @param porcentagemBonificacaoColaborador
	 */
	public void setPorcentagemBonificacaoColaborador(double porcentagemBonificacaoColaborador) {
		try {
			this.porcentagemBonificacaoColaborador = porcentagemBonificacaoColaborador / 100;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public Bonificacao() {
	}

//	public Bonificacao(double porcentagemBonificacaoColaborador, double porcentagemBonificacaoSetor,
//			double porcentagemBonificacaoEmpresa, double porcentagemBonificacaoCargo) {
//		this.porcentagemBonificacaoColaborador = porcentagemBonificacaoColaborador;
//	}

	@Override
	public String toString() {
		return super.toString();
	}

}
