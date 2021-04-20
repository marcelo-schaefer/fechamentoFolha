package br.com.proway.senior.fechamentoFolha;

public class Filtro {	
	
	/**
	 * Filtra os Colaboradores por e-mail
	 * 
	 * Recebe os parâmetros para verficar se o Colaborador existe e o retorna
	 * 
	 * @param email; referente ao Colaborador que o usuário deseja saber sobre 
	 * @param cadastro; lista de todos os colaboradores cadastrados
	 * 
	 * @return Colaborador/null Colaborador desejado/Colaborador não existe
	 */	
	static public ColaboradorFolha filtro(String email, CadastroColaborador cadastro) { 
		for(ColaboradorFolha c : cadastro.getColaboradores()) {
			if(c.getEmail() == email) {				
				return c; 
			}
		}
		return null;  
	}

	/**
	 * Filtra os Colaboradores por ID
	 * 
	 * Recebe os parâmetros para verficar se o Colaborador existe e o retorna 
	 * 
	 * @param userId; ID referente ao Colaborador que o usuário deseja saber sobre 
	 * @param cadastro; lista de todos os colaboradores cadastrados
	 * 
	 * @return Colaborador/null Colaborador desejado/Colaborador não existe
	 */	
	static public ColaboradorFolha filtro(int userId, CadastroColaborador cadastro) {
		for(ColaboradorFolha c : cadastro.getColaboradores()) {
			if(c.getId() == userId) {			
				return c;
			}
		}
		return null;
	}
	
	/**
	 * Filtra as Folhas de determinado Colaborador por ID
	 * 
	 * Recebe os parâmetros para verficar se a Folha de determinado Colaborador existe e a retorma 
	 * 
	 * @param c; Colaborador dono da folha
	 * @param idFolha; ID da Folha desejada
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
	 * @param c; Colaborador Dono da folha
	 * @param data; Data da Folha desejada
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