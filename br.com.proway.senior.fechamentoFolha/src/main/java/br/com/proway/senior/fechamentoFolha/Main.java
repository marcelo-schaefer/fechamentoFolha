package br.com.proway.senior.fechamentoFolha;

public class Main {
	public static void main(String[] args) {
		CadastroColaborador cadastro = new CadastroColaborador();
		ColaboradorFolha jorge = new ColaboradorFolha("jorge", 0, "jorge@gmail.com", 1500.0);
		cadastro.addColaboradores(jorge);
		Ponto pontoJorge = new Ponto(220, 0, 0, 250, 0, true, 100, 25);
		jorge.setPonto(pontoJorge);
		
		Folha folha = new Folha(jorge);
	}
}
