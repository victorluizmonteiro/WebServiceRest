package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.exceptions.DBCommitException;
import br.com.fiap.exceptions.IdNotFoundException;

public interface GenericDAO<T,K> {
	
	/**
	 * Inteface que define as funcionalidades 
	 * gen�ricas do DAO (CRUD)
	 * 
	 * @author Victor 
	 *
	 * @param <T> - Classe da Entidade
	 * @param <K> - Classe do Tipo da chave primaria
	 */
	

		void insert(T entity) throws DBCommitException;
		void update(T entity) throws DBCommitException;
		void delete(K id) throws DBCommitException, IdNotFoundException;
		T findById(K id);
		List<T> list();
		

		

}
