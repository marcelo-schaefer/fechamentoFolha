package br.com.proway.senior.dao;

import org.junit.Test;

import br.com.proway.senior.model.Bonificacao;

public class BonificacaoDAOTest2 {

	@Test
	public void testAdicionarBonificacao() {
		BonificacaoDAO bonificacaoDAO = BonificacaoDAO.getInstance(PostgresConnector.getSession());

		Bonificacao bonificacao = new Bonificacao();
		bonificacao.setPorcentagemBonificacaoColaborador(6);
		bonificacaoDAO.insert(bonificacao);	
	}
}
