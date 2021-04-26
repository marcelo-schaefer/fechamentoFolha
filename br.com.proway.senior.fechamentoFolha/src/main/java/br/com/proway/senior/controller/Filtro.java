package br.com.proway.senior.controller;

import br.com.proway.senior.model.ColaboradorFolha;
import br.com.proway.senior.model.Folha;

public class Filtro {	
	

	/**
	 * Filtra as Folhas de determinado Colaborador por ID
	 * 
	 * Recebe os parâmetros para verficar se a Folha de determinado Colaborador existe e a retorma 
	 * 
	 * @param c Colaborador dono da folha
	 * @param idFolha ID da Folha desejada
	 * 
	 * @return Folha/null Folha desejado/Folha não existe
	 */		
	static public Folha filtro(ColaboradorFolha c, int idFolha) {
		for(Folha folha : c.getTotalFolhas()) {
			if(folha.getId() == idFolha) {
				return folha;
			}
		}
		return null;  
	}
	
	/**
	 * Filtra as Folhas de determinado Colaborador por data
	 * 
	 * Recebe os parâmetros para verficar se a Folha de determinado Colaborador existe e a retorma 
	 * 
	 * @param c Colaborador Dono da folha
	 * @param data Data da Folha desejada
	 * 
	 * @return Folha/null Folha desejado/Folha não existe
	 */	
	static public Folha filtro(ColaboradorFolha c, String data) {
		for(Folha folha : c.getTotalFolhas()) {
			if(data == folha.getDataEmissao()) {			
				return folha;
			}
		}
		return null;
	}
	
}