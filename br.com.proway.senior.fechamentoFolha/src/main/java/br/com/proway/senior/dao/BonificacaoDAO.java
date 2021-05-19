package br.com.proway.senior.dao;

import org.hibernate.Session;

import br.com.proway.senior.model.Bonificacao;

/**
 * <h1>Bonificacao DAO.</h1>
 * 
 * <p>Classe responsavel por implementar os metodos
 * de DML da classe {@link Bonificacao}.</p>
 * 
 * @author Sprint 5: Bruna Carvalho <sh4323202@gmail.com>;
 * @author Sprint 5: Leonardo Pereira <leonardopereirajr@gmail.com>;
 * @author Sprint 5: Sabrina Schmidt <sabrinaschmidt335@gmail.com>;
 * @author Sprint 5: Lucas Nunes <lucasnunes.ln365@gmail.com>.
 * 
 * @see Bonificacao
 */
public class BonificacaoDAO {
	
	private Session session;
	private static BonificacaoDAO instance;
	
	public static BonificacaoDAO getInstance(Session session) {
		if (instance == null) {
			instance = new BonificacaoDAO(session);
		}
		return instance;
	}
	
	public static BonificacaoDAO newInstance(Session session) {
		instance = new BonificacaoDAO(session);
		return instance;
	}

	private BonificacaoDAO(Session session) {
		this.session = session;
	}
	
	/***
	 * <h1>Inserir {@link Bonificacao} na
	 * tabela bonificacao.</h1>
	 * 
	 * <p>Recebe um objeto {@link Bonificacao} e
	 * insere ele na tabela de bonificacoes
	 * do banco de dados.</p>
	 * 
	 * @param objectToInsert {@link Bonificacao}, referente a {@link Bonificacao}
	 * informada.
	 * 
	 * @author Sprint 5: Bruna Carvalho <sh4323202@gmail.com>;
	 * @author Sprint 5: Leonardo Pereira <leonardopereirajr@gmail.com>;
	 * @author Sprint 5: Sabrina Schmidt <sabrinaschmidt335@gmail.com>;
	 * @author Sprint 5: Lucas Nunes <lucasnunes.ln365@gmail.com>. 
	 * 
	 * @see Bonificacao
	 */
	public void insert(Bonificacao objectToInsert) {
		if (!session.getTransaction().isActive())
			session.beginTransaction();
		session.save(objectToInsert);
		session.getTransaction().commit();
	}
}
