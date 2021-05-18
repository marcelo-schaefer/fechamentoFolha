package br.com.proway.senior.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.com.proway.senior.model.Folha;

/**
 *Faz ligacao com o banco de dados.
 *
 *Possue os metodos CRUD.
 * 
 * @author Leonardo Felipe Silva <felipeleao217@gmail.com>;
 * @author Bruna Carvalho <sh4323202@gmail.com>;
 * @author Leonardo Pereira <leonardopereirajr@gmail.com>;
 * @author Sabrina Schmidt <sabrinaschmidt335@gmail.com>;
 * @author Lucas Nunes <lucasnunes.ln365@gmail.com>.
 */
public final class FolhaDAO implements InterfaceFolhaDAO {
	/**
	 * Instancia da classe FolhaDAO em Singleton
	 */
	private static FolhaDAO instance;
	/**
	 * Sessao
	 */
	private Session session;

	/**
	 * Metodo getInstance que retorna uma instancia {@link FolhaDAO}. O método
	 * recebe uma {@link Session} Verifica se existe uma instancia. Se existir,
	 * retorna esta instancia. Se nao existir, cria e retorna uma nova instancia.
	 * 
	 * @param session of type {@link Session}
	 * @return instance {@link FolhaDAO}
	 */
	public static FolhaDAO getInstance(Session session) {
		if (instance == null) {
			instance = new FolhaDAO(session);
		}
		return instance;
	}

	/**
	 * Cria e retorna uma nova instancia.
	 * 
	 * @param session {@link Session}
	 * @return instance {@link FolhaDAO}
	 */
	public static FolhaDAO newInstance(Session session) {
		instance = new FolhaDAO(session);
		return instance;
	}

	private FolhaDAO(Session session) {
		this.session = session;
	}

	/**
	 * Insere uma folha no banco de dados.
	 * 
	 * Recebe um objeto tipo {@link Folha}, abre uma {@link Session} e insere o
	 * objeto no banco de dados.
	 * 
	 * @param objectToInsert do tipo {@link Folha}
	 */
	public void insert(Folha objectToInsert) {
		if (!session.getTransaction().isActive())
			session.beginTransaction();
		session.save(objectToInsert);
		session.getTransaction().commit();
	}

	/**
	 * Deleta um objeto Folha do banco de dados.
	 * 
	 * Recebe um objeto do tipo {@link Folha}, abre uma {@link Session} com o banco
	 * e deleta o objeto no mesmo.
	 * 
	 * @param objectToDelete do tipo {@link Folha}
	 */
	public void delete(Folha folha) {
		if (!session.getTransaction().isActive())
			session.beginTransaction();
		session.delete(session.get(Folha.class, folha.getId()));
		session.getTransaction().commit();
	}

	/**
	 * Atualiza um objeto {@link Folha} no banco.
	 * 
	 * Faz a ligação com o banco de dados, recebe um objeto {@link Folha}, busca o
	 * mesmo no banco de dados atraves da id, e atualiza os novos valores que foram
	 * alterados.
	 * 
	 * @param objectToUpdate do tipo {@link Folha}.
	 */
	public void update(Folha objectToUpdate) {
		if (!session.getTransaction().isActive())
			session.beginTransaction();
		session.update(objectToUpdate);
		session.getTransaction().commit();
	}

	/**
	 * Retorna todos os objetos do banco de dados.
	 * 
	 * Faz a conexao com o banco, seta o tipo que deseja e o lista.
	 * 
	 * @return List<Folhas>
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
	 * Pega um objeto do banco atraves do Id.
	 * 
	 * Faz a conexao com o banco, recebe um paramentro do tipo inteiro e retorna o
	 * objeto com o id correspondente.
	 * 
	 * @param id
	 * @return {@link Folha}
	 */
	public Folha getById(int id) {
		return session.get(Folha.class, id);
	}

	/**
	 * Pega objetos do banco atraves da data de emissao.
	 * 
	 * Faz a conexao com o banco, recebe um paramentro do tipo LocalDate e
	 * retorna uma lista com os objetos que possuem a data de emissao 
	 * correspondente.
	 * 
	 * @param data
	 * @return List<Folha>
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


	public void limparTabela() {
		if(!session.getTransaction().isActive()) {
			session.beginTransaction();
		}
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaDelete<Folha> criteriaDelete = builder.createCriteriaDelete(Folha.class);
		criteriaDelete.from(Folha.class);
		session.createQuery(criteriaDelete).executeUpdate();
	}
}