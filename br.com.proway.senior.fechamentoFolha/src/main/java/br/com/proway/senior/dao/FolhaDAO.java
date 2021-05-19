package br.com.proway.senior.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.com.proway.senior.model.Folha;

/**
 *<h1>Reponsavel pelos comandos de DML.</h1>
 *
 * <p>Possue os metodos CRUD da {@link Folha}.</p>
 * 
 * @author Sprint 5: Leonardo Felipe Silva <felipeleao217@gmail.com>;
 * @author Sprint 5: Bruna Carvalho <sh4323202@gmail.com>;
 * @author Sprint 5: Leonardo Pereira <leonardopereirajr@gmail.com>;
 * @author Sprint 5: Sabrina Schmidt <sabrinaschmidt335@gmail.com>;
 * @author Sprint 5: Lucas Nunes <lucasnunes.ln365@gmail.com>.
 */
public final class FolhaDAO implements InterfaceFolhaDAO {
	/**
	 * <h1>Instancia da classe FolhaDAO em Singleton</h1>
	 */
	private static FolhaDAO instance;
	/**
	 * <h1>Session para as transacoes</h1>
	 */
	private Session session;

	/**
	 * <h1>Cria uma instancia caso não exista
	 *  ou usa a existente.</h1>
	 * 
	 * <p>Recebe uma session. Verifica a existencia de uma instancia,
	 * caso já exista ele atribui a instancia uma sessao da {@link FolhaDAO}
	 * caso não exista ele cria uma nova instancia.</p>
	 * 
	 * @param session Session, referente a session informada.
	 * 
	 * @return instance {@link FolhaDAO#instance}, referente a sessao da {@link FolhaDAO}
	 * 
	 * @author Sprint 5: Leonardo Felipe Silva <felipeleao217@gmail.com>;
	 * @author Sprint 5: Bruna Carvalho <sh4323202@gmail.com>;
	 * @author Sprint 5: Leonardo Pereira <leonardopereirajr@gmail.com>;
	 * @author Sprint 5: Sabrina Schmidt <sabrinaschmidt335@gmail.com>;
	 * @author Sprint 5: Lucas Nunes <lucasnunes.ln365@gmail.com>.
	 * 
	 * @see FolhaDAO
	 * @see FolhaDAO#instance
	 */
	public static FolhaDAO getInstance(Session session) {
		if (instance == null) {
			instance = new FolhaDAO(session);
		}
		return instance;
	}

	/**
	 * <h1>Cria e retorna uma nova instancia.</h1>
	 * 
	 * <p>Recebe uma session e cria uma nova
	 * instance da {@link FolhaDAO}</p>
	 * 
	 * @param session Session, referente a sessao informada
	 * 
	 * @return instance
	 * 
	 * @author Sprint 5: Leonardo Felipe Silva <felipeleao217@gmail.com>;
	 * @author Sprint 5: Bruna Carvalho <sh4323202@gmail.com>;
	 * @author Sprint 5: Leonardo Pereira <leonardopereirajr@gmail.com>;
	 * @author Sprint 5: Sabrina Schmidt <sabrinaschmidt335@gmail.com>;
	 * @author Sprint 5: Lucas Nunes <lucasnunes.ln365@gmail.com>.
	 * 
	 * @see FolhaDAO
	 */
	public static FolhaDAO newInstance(Session session) {
		instance = new FolhaDAO(session);
		return instance;
	}
	
	/***
	 * <h1>Construtor privado para
	 * setar a sessao</h1>
	 * 
	 * <p>Recebe uma session e atrubiu essa sessao
	 * a session da classe</p>
	 * 
	 * @param session Session, referente a session informada.
	 * 
	 * @author Sprint 5: Leonardo Felipe Silva <felipeleao217@gmail.com>;
	 * @author Sprint 5: Bruna Carvalho <sh4323202@gmail.com>;
	 * @author Sprint 5: Leonardo Pereira <leonardopereirajr@gmail.com>;
	 * @author Sprint 5: Sabrina Schmidt <sabrinaschmidt335@gmail.com>;
	 * @author Sprint 5: Lucas Nunes <lucasnunes.ln365@gmail.com>.
	 */
	private FolhaDAO(Session session) {
		this.session = session;
	}

	/**
	 * <h1>Insere uma {@link Folha} no banco de dados.</h1>
	 * 
	 * <p>Recebe um objeto {@link Folha}, abre uma session e insere o
	 * objeto no banco de dados.</p>
	 * 
	 * @param objectToInsert {@link Folha}, referente a {@link Folha}
	 * 
	 * @author Sprint 5: Leonardo Felipe Silva <felipeleao217@gmail.com>;
	 * @author Sprint 5: Bruna Carvalho <sh4323202@gmail.com>;
	 * @author Sprint 5: Leonardo Pereira <leonardopereirajr@gmail.com>;
	 * @author Sprint 5: Sabrina Schmidt <sabrinaschmidt335@gmail.com>;
	 * @author Sprint 5: Lucas Nunes <lucasnunes.ln365@gmail.com>.
	 * 
	 * @see Folha
	 */
	public void insert(Folha objectToInsert) {
		if (!session.getTransaction().isActive())
			session.beginTransaction();
		session.save(objectToInsert);
		session.getTransaction().commit();
	}

	/**
	 * <h1>Deleta um objeto {@link Folha} do banco de dados.</h1>
	 * 
	 * <p>Recebe um objeto do {@link Folha}, abre uma session com o banco
	 * e deleta o objeto no mesmo.</p>
	 * 
	 * @param objectToDelete {@link Folha}, referente a {@link Folha} informada
	 * 
	 * @author Sprint 5: Leonardo Felipe Silva <felipeleao217@gmail.com>;
	 * @author Sprint 5: Bruna Carvalho <sh4323202@gmail.com>;
	 * @author Sprint 5: Leonardo Pereira <leonardopereirajr@gmail.com>;
	 * @author Sprint 5: Sabrina Schmidt <sabrinaschmidt335@gmail.com>;
	 * @author Sprint 5: Lucas Nunes <lucasnunes.ln365@gmail.com>.
	 * 
	 * @see Folha
	 */
	public void delete(int id) {
		if (!session.getTransaction().isActive())
			session.beginTransaction();
		session.delete(session.get(Folha.class, id));
		session.getTransaction().commit();
	}

	/**
	 * <h1>Atualiza um objeto {@link Folha} no banco.</h1>
	 * 
	 * <p>Faz a ligacao com o banco de dados, 
	 * recebe um objeto {@link Folha}, busca o
	 * mesmo no banco de dados atraves da id,
	 * e atualiza os novos valores que foram
	 * alterados.</p>
	 * 
	 * @param objectToUpdate {@link Folha}, referente a {@link Folha}.
	 * 
	 * @author Sprint 5: Leonardo Felipe Silva <felipeleao217@gmail.com>;
	 * @author Sprint 5: Bruna Carvalho <sh4323202@gmail.com>;
	 * @author Sprint 5: Leonardo Pereira <leonardopereirajr@gmail.com>;
	 * @author Sprint 5: Sabrina Schmidt <sabrinaschmidt335@gmail.com>;
	 * @author Sprint 5: Lucas Nunes <lucasnunes.ln365@gmail.com>.
	 * 
	 * @see Folha
	 */
	public void update(Folha objectToUpdate) {
		if (!session.getTransaction().isActive())
			session.beginTransaction();
		session.update(objectToUpdate);
		session.getTransaction().commit();
	}

	/**
	 * <h1>Retorna todos os objetos do banco de dados</h1>.
	 * 
	 * <p>Faz a conexao com o banco, tras todos os bancos
	 * e os lista em um List.</p>
	 * 
	 * @return List<{@link Folha}> referente aos todos os dados do banco
	 * 
	 * @author Sprint 5: Leonardo Felipe Silva <felipeleao217@gmail.com>;
	 * @author Sprint 5: Bruna Carvalho <sh4323202@gmail.com>;
	 * @author Sprint 5: Leonardo Pereira <leonardopereirajr@gmail.com>;
	 * @author Sprint 5: Sabrina Schmidt <sabrinaschmidt335@gmail.com>;
	 * @author Sprint 5: Lucas Nunes <lucasnunes.ln365@gmail.com>.
	 * 
	 * @see Folha
	 */
	public List<Folha> getAll() {
		if (!session.getTransaction().isActive())
			session.beginTransaction();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Folha> criteria = builder.createQuery(Folha.class);
		criteria.from(Folha.class);
		List<Folha> selectedFolhas = session.createQuery(criteria).getResultList();
		return selectedFolhas;
	}

	/**
	 * <h1>Pega uma {@link Folha} do banco atraves do Id.</h1>
	 * 
	 * <p>Faz a conexao com o banco, recebe um paramentro 
	 * do tipo inteiro e retorna a {@link Folha} com o 
	 * id correspondente.</p>
	 * 
	 * @param id int, referente ao id informado
	 * 
	 * @author Sprint 5: Leonardo Felipe Silva <felipeleao217@gmail.com>;
	 * @author Sprint 5: Bruna Carvalho <sh4323202@gmail.com>;
	 * @author Sprint 5: Leonardo Pereira <leonardopereirajr@gmail.com>;
	 * @author Sprint 5: Sabrina Schmidt <sabrinaschmidt335@gmail.com>;
	 * @author Sprint 5: Lucas Nunes <lucasnunes.ln365@gmail.com>.
	 * 
	 * @return {@link Folha}
	 * 
	 * @see Folha
	 */
	public Folha getById(int id) {
		return session.get(Folha.class, id);
	}

	/**
	 * <h1>Pega objetos do banco atraves da data de emissao.</h1>
	 * 
	 * <p>Faz a conexao com o banco, recebe um paramentro do tipo LocalDate e
	 * retorna uma lista com as {@link Folha}s que possuem a data de emissao 
	 * correspondente.</p>
	 * 
	 * @param data LocalDate, referente a data informada.
	 * 
	 * @return List<{@link Folha}>, referente a todas as folhas com
	 * a data correspondente
	 * 
	 * @author Sprint 5: Leonardo Felipe Silva <felipeleao217@gmail.com>;
	 * @author Sprint 5: Bruna Carvalho <sh4323202@gmail.com>;
	 * @author Sprint 5: Leonardo Pereira <leonardopereirajr@gmail.com>;
	 * @author Sprint 5: Sabrina Schmidt <sabrinaschmidt335@gmail.com>;
	 * @author Sprint 5: Lucas Nunes <lucasnunes.ln365@gmail.com>.
	 * 
	 * @see Folha
	 */
	public List<Folha> getByDate(LocalDate data) {
		if (!session.getTransaction().isActive())
			session.beginTransaction();

		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Folha> criteria = builder.createQuery(Folha.class);

		Root<Folha> root = criteria.from(Folha.class);

		criteria.where(builder.equal(root.get("dataEmissao"), data));

		List<Folha> folha = session.createQuery(criteria).getResultList();

		return folha;
	}
	
	/***
	 * <h1>Pega {@link Folha}s por valores em uma coluna</h1>
	 * 
	 * <p>Recebe uma column e um value. Procura no banco
	 * todas as {@link Folha}s que tenham esse valor
	 * nessa coluna. Retorna uma lista com todas as
	 * {@link Folha}s correspondentes.</p>
	 * 
	 * @param column String, referente a coluna informada
	 * @param value Double, referente ao valor inforamado
	 * 
	 * @return List<{@link Folha}>, referente as folhas que tem
	 * o valor na coluna informada.
	 * 
	 * @author Sprint 5: Leonardo Felipe Silva <felipeleao217@gmail.com>;
	 * @author Sprint 5: Bruna Carvalho <sh4323202@gmail.com>;
	 * @author Sprint 5: Leonardo Pereira <leonardopereirajr@gmail.com>;
	 * @author Sprint 5: Sabrina Schmidt <sabrinaschmidt335@gmail.com>;
	 * @author Sprint 5: Lucas Nunes <lucasnunes.ln365@gmail.com>.
	 * 
	 * @see Folha
	 */
	public List<Folha> getDoubleByColumn(String column, Double value) {
		if (!session.getTransaction().isActive())
			session.beginTransaction();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Folha> criteria = builder.createQuery(Folha.class);

		Root<Folha> root = criteria.from(Folha.class);
		
		//CriteriaQuery<Folha> rootQuery = criteria.select(root);
		
		Expression<?> columnExpression = (Expression<?>) root.get(column);

		criteria.select(root).where(builder.equal(columnExpression, value));

		List<Folha> folha = session.createQuery(criteria).getResultList();

		return folha;
	}
	
	/***
	 * <h1>Pega {@link Folha}s por um intervalo de valores em uma coluna</h1>
	 * 
	 * <p>Recebe uma column, valueInicial e valueFinal. Procura no banco
	 * todas as {@link Folha}s que tenham esse intervalo de valor
	 * nessa coluna. Retorna uma lista com todas as
	 * {@link Folha}s correspondentes.</p>
	 * 
	 * @param column String, referente a coluna informada
	 * @param valueInicial Double, referente ao valor inicial informado
	 * @param valueFinal Double, referente ao valor final inforamado
	 * 
	 * @return List<{@link Folha}>, referente as folhas que tem
	 * o interalo de valor na coluna informada.
	 * 
	 * @author Sprint 5: Leonardo Felipe Silva <felipeleao217@gmail.com>;
	 * @author Sprint 5: Bruna Carvalho <sh4323202@gmail.com>;
	 * @author Sprint 5: Leonardo Pereira <leonardopereirajr@gmail.com>;
	 * @author Sprint 5: Sabrina Schmidt <sabrinaschmidt335@gmail.com>;
	 * @author Sprint 5: Lucas Nunes <lucasnunes.ln365@gmail.com>.
	 * 
	 * @see Folha
	 */
	public List<Folha> getValuesBetween(String column, Double valueInicial, Double valueFinal) {
		if (!session.getTransaction().isActive())
			session.beginTransaction();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Folha> criteria = builder.createQuery(Folha.class);

		Root<Folha> root = criteria.from(Folha.class);
		
		//CriteriaQuery<Folha> rootQuery = criteria.select(root);
		
		Expression<Double> columnExpression = root.get(column);
		
		criteria.select(root).where(builder.between(columnExpression, valueInicial, valueFinal));

		List<Folha> folha = session.createQuery(criteria).getResultList();

		return folha;
	}

	/**
	 * <h1>Não implementado</h1>
	 * 
	 * <p>Metodo nao implementado</p>
	 * 
	 * @param folha Folha, referente a folha informada
	 */
	public void delete(Folha folha) {		
	}
}