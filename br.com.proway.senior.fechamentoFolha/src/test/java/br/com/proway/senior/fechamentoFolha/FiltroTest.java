package br.com.proway.senior.fechamentoFolha;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FiltroTest {	

	FolhaProvisoria folha0 = new FolhaProvisoria(0, "data1");
	FolhaProvisoria folha1 = new FolhaProvisoria(1, "data2");
	FolhaProvisoria folha2 = new FolhaProvisoria(2, "data3");
	Colaborador colaborador0 = new Colaborador("Jorge", 0, "email1", 500.0); 
	Colaborador colaborador1 = new Colaborador("Jorge2", 1, "email2", 500.0); 
	CadastroColaborador cadastro = new CadastroColaborador(); 
	    
	@Test
	public void testFiltroUsuarioId() { 
		cadastro.addColaboradores(colaborador0);
		cadastro.addColaboradores(colaborador1);
		Colaborador c = Filtro.filtro(0, cadastro);
		assertEquals(0, c.getId());
		
	}
	
	@Test
	public void testFiltroUsuarioInexistenteId() {
		cadastro.addColaboradores(colaborador0);
		cadastro.addColaboradores(colaborador1);
		Colaborador c = Filtro.filtro(5, cadastro);
		assertEquals(null, c);
	}
	
	@Test
	public void testFiltroFolhaId() {
		colaborador0.addTotalFolhas(folha0);
		colaborador0.addTotalFolhas(folha1);
		colaborador0.addTotalFolhas(folha2);
		FolhaProvisoria f = Filtro.filtro(colaborador0, 1);
		assertEquals(1, f.getId());		
	}
	
	@Test
	public void testFiltroFolhaInexistenteId() {
		colaborador0.addTotalFolhas(folha0);
		colaborador0.addTotalFolhas(folha1);
		colaborador0.addTotalFolhas(folha2);
		FolhaProvisoria f = Filtro.filtro(colaborador0, 6);
		assertEquals(null, f);		
	}
	
	@Test
	public void testUsuarioFolhaTrue() {
		CadastroColaborador cadastroteste = new CadastroColaborador();
		Colaborador colaboradorteste0 = new Colaborador("Jorge", 0, "email1", 500.0); 
		Colaborador colaboradorteste1 = new Colaborador("Jorge2", 1, "email2", 500.0);
		cadastroteste.addColaboradores(colaboradorteste0);
		cadastroteste.addColaboradores(colaboradorteste1);		
		FolhaProvisoria folhateste0 = new FolhaProvisoria(0, "data");
		FolhaProvisoria folhateste1 = new FolhaProvisoria(1, "data");
		colaboradorteste0.addTotalFolhas(folhateste0);
		colaboradorteste0.addTotalFolhas(folhateste1);
		Colaborador c = Filtro.filtro(0, cadastroteste);	
		FolhaProvisoria f = Filtro.filtro(c, 0);
		assertEquals(folhateste0, f);
	}
	
	@Test
	public void testUsuarioFolhaFalse() {
		CadastroColaborador cadastroteste = new CadastroColaborador();
		Colaborador colaboradorteste0 = new Colaborador("Jorge", 0, "email1", 500.0); 
		Colaborador colaboradorteste1 = new Colaborador("Jorge2", 1, "email2", 500.0);
		cadastroteste.addColaboradores(colaboradorteste0);
		cadastroteste.addColaboradores(colaboradorteste1);		
		FolhaProvisoria folhateste0 = new FolhaProvisoria(0, "data");
		FolhaProvisoria folhateste1 = new FolhaProvisoria(1, "data");
		colaboradorteste0.addTotalFolhas(folhateste0);
		colaboradorteste0.addTotalFolhas(folhateste1);
		Colaborador c = Filtro.filtro(0, cadastroteste);	
		FolhaProvisoria f = Filtro.filtro(c, 6);
		assertEquals(null, f);
	}
	
	@Test
	public void testFiltroUsuarioEmail() {
		cadastro.addColaboradores(colaborador0);
		cadastro.addColaboradores(colaborador1);
		Colaborador c = Filtro.filtro("email1", cadastro);
		assertEquals("email1", c.getEmail());
		
	}
	
	@Test
	public void testFiltroUsuarioInexistenteEmail() {
		cadastro.addColaboradores(colaborador0);
		cadastro.addColaboradores(colaborador1);
		Colaborador c = Filtro.filtro("email3", cadastro);
		assertEquals(null, c);
	}
	
	@Test
	public void testFiltroFolhaData() {
		colaborador0.addTotalFolhas(folha0);
		colaborador0.addTotalFolhas(folha1);
		colaborador0.addTotalFolhas(folha2);
		FolhaProvisoria f = Filtro.filtro(colaborador0, "data2");
		assertEquals("data2", f.getData());		
	}
	
	@Test
	public void testFiltroFolhaInexistenteData() {
		colaborador0.addTotalFolhas(folha0);
		colaborador0.addTotalFolhas(folha1);
		colaborador0.addTotalFolhas(folha2);
		FolhaProvisoria f = Filtro.filtro(colaborador0, "data4");
		assertEquals(null, f);		
	}
	
}
