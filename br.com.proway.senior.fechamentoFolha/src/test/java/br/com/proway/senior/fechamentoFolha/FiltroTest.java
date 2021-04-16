package br.com.proway.senior.fechamentoFolha;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FiltroTest {

	/*
	@Test
	public void testGetFolhaPorColaborador() {
		int idFolha = 0;
		int idColaborador = 0;
		Colaborador colaborador = new Colaborador(idColaborador); // Criação do colaborador
		CadastroColaborador cadastro = new CadastroColaborador(); // Criação do cadastro total de colaboradores

		Folha folha0 = new Folha(idFolha); // Criação da folha referente ao colaborador
		colaborador.setTotalFolhas(folha0); // Insiersão da folha no funcionário
		cadastro.setColaboradores(colaborador);	// Incersão do colaborador no cadastro total de coaboradores	
		Filtro filtro = new Filtro(); // Criação de um filtro (checar a existência de colaborador e folha)
		Folha folha = filtro.getFolhaPorColaborador(idColaborador, idFolha, cadastro); // procura folha
		assertEquals(idFolha,(int)folha.getId()); // 0, 0 (id da folha desejada, id da folha procurada)
	}
	
	@Test
	public void testGetFolhaPorColaboradorFalha() {
		int idFolha = 0;
		int idColaborador = 0;
		Colaborador colaborador = new Colaborador(idColaborador); // Criação do colaborador
		CadastroColaborador cadastro = new CadastroColaborador(); // Criação do cadastro total de colaboradores

		Folha folha0 = new Folha(idFolha); // Criação da folha referente ao colaborador
		colaborador.setTotalFolhas(folha0); // Insiersão da folha no funcionário
		cadastro.setColaboradores(colaborador);	// Incersão do colaborador no cadastro total de coaboradores	
		Filtro filtro = new Filtro(); // Criação de um filtro (checar a existência de colaborador e folha)
		Folha folha = filtro.getFolhaPorColaborador(idColaborador, 2, cadastro); // procura folha inexistente
		assertEquals(null, folha);
	}
	*/

	Folha folha0 = new Folha(0);
	Folha folha1 = new Folha(1);
	Folha folha2 = new Folha(2);
	Colaborador colaborador0 = new Colaborador("Jorge", 0, 500.0); // Criação do colaborador
	Colaborador colaborador1 = new Colaborador("Joao", 1, 500.0); // Criação do colaborador
	CadastroColaborador cadastro = new CadastroColaborador(); // Criação do cadastro total de colaboradores
	Filtro filtro = new Filtro();
	
	
	@Test
	public void testFiltroUsuario() {
		cadastro.addColaboradores(colaborador0);
		cadastro.addColaboradores(colaborador1);
		Colaborador c = filtro.filtro(0, cadastro);
		assertEquals(0, c.getId());
		
	}
	
	@Test
	public void testFiltroUsuarioInexistente() {
		cadastro.addColaboradores(colaborador0);
		cadastro.addColaboradores(colaborador1);
		Colaborador c = filtro.filtro(5, cadastro);
		assertEquals(null, c);
	}
	
	@Test
	public void testFiltroFolha() {
		colaborador0.addTotalFolhas(folha0);
		colaborador0.addTotalFolhas(folha1);
		colaborador0.addTotalFolhas(folha2);
		Folha f = filtro.filtro(colaborador0, 1);
		assertEquals(1, f.getId());		
	}
	
	@Test
	public void testFiltroFolhaInexistente() {
		colaborador0.addTotalFolhas(folha0);
		colaborador0.addTotalFolhas(folha1);
		colaborador0.addTotalFolhas(folha2);
		Folha f = filtro.filtro(colaborador0, 6);
		assertEquals(null, f);		
	}
	
}
