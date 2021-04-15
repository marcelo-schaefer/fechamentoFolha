package br.com.proway.senior.fechamentoFolha;

public class Main {

	public static void main(String[] args) {
		CadastroColaborador listaColaboradores = new CadastroColaborador(); 
		cadastroFolha listaFolha = new cadastroFolha();	
		/**
		 * Foram criados dois colaboradores e uma folha só com id dentro 
		 * 
		 * e feito um filtro para bucar a folha de um colaborador
		 */
		Colaborador jorge = new Colaborador(0);
		listaColaboradores.setColaboradores(jorge);
		Colaborador joao = new Colaborador(1);
		listaColaboradores.setColaboradores(joao);
		Folha novaFolha = new Folha(0);
		listaFolha.setFolhas(novaFolha);
//		jorge.setFolhas(listaFolha);
		
		
		
			
		// TODO Auto-generated method stub
		for(Colaborador c : listaColaboradores.getColaboradores()) {
			System.out.println(c);
			if(c.getId() == 0) {
				
			}
		}
		
		
	}


