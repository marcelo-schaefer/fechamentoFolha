package br.com.proway.senior.fechamentoFolha;

public interface InterfaceFiltro {

	
	public Colaborador filtro(String email, CadastroColaborador cadastro);
	public Colaborador filtro(int userId, CadastroColaborador cadastro);
	public Folha filtro(Colaborador c, int idFolha);
	public Folha filtro(Colaborador c, String data);
	
}
