package br.com.livrariaRTM.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {
    private static Conexao instancia = null;
    private static final ThreadLocal<EntityManager> entityManager = new ThreadLocal<EntityManager>();
    private EntityManagerFactory factory;

    private Conexao() {
        factory = Persistence.createEntityManagerFactory(getPersistenceUnit());
    }
    
    public static synchronized Conexao getInstance(){
        if(instancia == null){
            instancia = new Conexao();
        }
        return instancia;
    }
    
    public void getConexao() {
        EntityManager em = entityManager.get();
        if(em == null){
            em = factory.createEntityManager();
            entityManager.set(em);
        }
    }

    public void fecharConexao() {
        EntityManager em = entityManager.get();
        if(em != null){
            em.close();
        }
        
        entityManager.set(null);
    }

    public void iniciarTransacao() {
        getConexao();
        EntityManager em = entityManager.get();
        em.getTransaction().begin();
    }

    public void commit() {
    	getCurrentEntityManager().getTransaction().commit();
    }

    public void rollback() {
    	getCurrentEntityManager().getTransaction().rollback();
    }
    
    public EntityManager getCurrentEntityManager(){
        getConexao();
        return entityManager.get();
    }
    
    private String getPersistenceUnit(){
    	Properties properties = new Properties();
    	try {
			properties.load(getClass().getClassLoader().getResourceAsStream("livrariaRTM.properties"));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	return properties.getProperty("persistenceUnit");
    }

}
