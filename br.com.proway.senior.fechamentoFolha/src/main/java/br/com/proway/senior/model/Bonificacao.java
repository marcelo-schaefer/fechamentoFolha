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
 * Classe que implementa o valor da bonifica��o por Setor/Colaborador/Empresa
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

	/**
	 * @return the porcentagemBonificacaoColaborador
	 */
	public double getPorcentagemBonificacaoColaborador() {
		return porcentagemBonificacaoColaborador;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
