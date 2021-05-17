/**
 * 
 */
package br.com.proway.senior.model.externo;

import java.util.ArrayList;

/**
 * @author nois
 *
 */
public class SetorFolha {
	private ArrayList<ColaboradorFolha> colaboradores = new ArrayList<ColaboradorFolha>();
	private ArrayList<CargoFolha> cargos = new ArrayList<CargoFolha>();
	private Empresa empresa = new Empresa();
	/**
	 * @return the colaboradores
	 */
	public ArrayList<ColaboradorFolha> getColaboradores() {
		return colaboradores;
	}
	/**
	 * @param colaboradores the colaboradores to set
	 */
	public void setColaboradores(ArrayList<ColaboradorFolha> colaboradores) {
		this.colaboradores = colaboradores;
	}
	/**
	 * @return the cargos
	 */
	public ArrayList<CargoFolha> getCargos() {
		return cargos;
	}
	/**
	 * @param cargos the cargos to set
	 */
	public void setCargos(ArrayList<CargoFolha> cargos) {
		this.cargos = cargos;
	}
	/**
	 * @return the empresa
	 */
	public Empresa getEmpresa() {
		return empresa;
	}
	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	
	
}
