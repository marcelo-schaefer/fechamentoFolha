package br.com.proway.senior.dao;

import br.com.proway.senior.model.Bonificacao;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class BonificacaoDAOTest {

    static BonificacaoDAO dao =
            BonificacaoDAO.getInstance(PostgresConnector.getSession());

    @Test
    public void testInsert() {
        // Cenário
        final Bonificacao bonificacaoASerInserida = new Bonificacao();
        bonificacaoASerInserida.setPorcentagemBonificacaoColaborador(5.0);
        bonificacaoASerInserida.setId(0);

        // Execução do Teste
        final boolean result = dao.insert(bonificacaoASerInserida);

        // Resultado
        assertTrue(result);
    }

    @Test
    public void testUpdate() {
        // Cenário

        final Bonificacao bonificacaoASerAlterada = new Bonificacao();
        bonificacaoASerAlterada.setPorcentagemBonificacaoColaborador(10.0);
        bonificacaoASerAlterada.setId(0);

        // Execução do Teste
        final boolean result = dao.update(bonificacaoASerAlterada);

        // Resultado
        assertTrue(result);
    }

    @Test
    public void testDelete() {
        // Cenário
        final Bonificacao bonificacaoASerDeletada = new Bonificacao();
        bonificacaoASerDeletada.setPorcentagemBonificacaoColaborador(9.0);
        bonificacaoASerDeletada.setId(0);

        // Execução do Teste
        final boolean result = dao.delete(bonificacaoASerDeletada);

        // Resultado
        assertTrue(result);
    }

    @Test
    public void testGetAll() {
        // Cenário

        // Execução do Teste
        final List<Bonificacao> result = dao.getAll();

        // Resultado
    }

    @Test
    public void testGetById() {
        // Cenário

        // Execução do Teste
        final Bonificacao result = dao.getById(0);

        // Resultado
    }

    @Test
    public void testGetAllById() {
        // Cenário

        // Execução do Teste
        final List<Bonificacao> result = dao.getAllById(0);

        // Resultado
    }

    @Test
    public void testGetInstance() {
        // Cenário
        final Session session = null;

        // Execução do Teste
        final BonificacaoDAO result = BonificacaoDAO.getInstance(session);

        // Resultado
    }
}
