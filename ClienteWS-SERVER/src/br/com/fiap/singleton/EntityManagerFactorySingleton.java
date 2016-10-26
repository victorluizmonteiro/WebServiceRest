package br.com.fiap.singleton;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {
	
	private static EntityManager factory;
	
	private EntityManagerFactorySingleton() {}	
	
	public static EntityManager getInstance(){
		
		if(factory == null){
			factory = Persistence.createEntityManagerFactory("CLIENTE_MYSQL").createEntityManager();
		}
		return factory;
	}

}
