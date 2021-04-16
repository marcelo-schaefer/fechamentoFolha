package br.com.proway.senior.fechamentoFolha;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FiltroTest {	

	Folha folha0 = new Folha(0, "data");
	Folha folha1 = new Folha(1, "data");
	Folha folha2 = new Folha(2, "data");
	Colaborador colaborador0 = new Colaborador("Jorge", 0, "email1", 500.0); // Criação do colaborador
	Colaborador colaborador1 = new Colaborador("Jorge2", 1, "email2", 500.0); // Criação do colaborador
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
	
	@Test
	public void test2Juntos() {
		CadastroColaborador cadastroteste = new CadastroColaborador();
		Colaborador colaboradorteste0 = new Colaborador("Jorge", 0, "email1", 500.0); 
		Colaborador colaboradorteste1 = new Colaborador("Jorge2", 1, "email2", 500.0);
		cadastroteste.addColaboradores(colaboradorteste0);
		cadastroteste.addColaboradores(colaboradorteste1);		
		Folha folhateste0 = new Folha(0, "data");
		Folha folhateste1 = new Folha(1, "data");
		colaboradorteste0.addTotalFolhas(folhateste0);
		colaboradorteste0.addTotalFolhas(folhateste1);
		Colaborador c = filtro.filtro(0, cadastroteste);	
		Folha f = filtro.filtro(c, 0);
		assertEquals(folhateste0, f);
	}
	
	@Test
	public void test2Juntos2() {
		CadastroColaborador cadastroteste = new CadastroColaborador();
		Colaborador colaboradorteste0 = new Colaborador("Jorge", 0, "email1", 500.0); 
		Colaborador colaboradorteste1 = new Colaborador("Jorge2", 1, "email2", 500.0);
		cadastroteste.addColaboradores(colaboradorteste0);
		cadastroteste.addColaboradores(colaboradorteste1);		
		Folha folhateste0 = new Folha(0, "data");
		Folha folhateste1 = new Folha(1, "data");
		colaboradorteste0.addTotalFolhas(folhateste0);
		colaboradorteste0.addTotalFolhas(folhateste1);
		Colaborador c = filtro.filtro(0, cadastroteste);	
		Folha f = filtro.filtro(c, 6);
		assertEquals(null, f);
	}
	
}
