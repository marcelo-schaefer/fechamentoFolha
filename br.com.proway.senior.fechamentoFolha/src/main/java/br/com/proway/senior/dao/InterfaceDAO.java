package br.com.proway.senior.dao;

import java.util.List;

/**
 * <h1>Interface do CRUD</h1>
 *
 * <p>
 * Metodos implementados pela classe {@link FolhaDAO}{@link BonificacaoDAO}{@link PlrDAO}.
 * </p>
 *
 * @author Sprint 6: David Willian <dwillian676@gmail.com>;
 * @author Sprint 6: Guilherme Ezequiel <guilhermeezequieldasilva@gmail.com>;
 * @author Sprint 6: Jonata Caetano <jonatacaetano88@gmail.com>
 * @author Sprint 6: Sabrina Schmidt <sabrinaschmidt335@gmail.com>;
 * @author Sprint 6: Samuel Levi <samuel.levi@senior.com.br>
 * @see FolhaDAO
 */
public interface InterfaceDAO<T> {

    public List<T> getAll();

    public boolean insert(T t);

    public boolean update(T t);

    public boolean delete(T t);

    public T getById(int id);

    public List<T> getAllById(int id);

}