package br.com.proway.senior.fechamentoFolha;


public class Filtro {

	public Folha getFolhaPorColaborador(Integer userId, Integer folhaId, CadastroColaborador cadastro) {
		for(Colaborador c : cadastro.getColaboradores()) {
			if(c.getId() == userId) {
				for(Folha folha : c.getTotalFolhas()) {
					if(folha.getId() == folhaId) {
						return folha;
					}
				}
			}
		}
		return null;
	}
	
}		
	


