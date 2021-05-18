package br.com.proway.senior.dao;

import org.junit.Test;

import br.com.proway.senior.model.Bonificacao;

public class BonificacaoDAOTest {

	@Test
	public void testAdicionarBonificacao() {
		BonificacaoDAO bonificacaoDAO = BonificacaoDAO.getInstance(PostgresConnector.getSession());
		//Variaveis de teste

		Bonificacao bonificacao = new Bonificacao();
		bonificacao.setPorcentagemBonificacaoColaborador(6);
		bonificacaoDAO.insert(bonificacao);	
	}

}
