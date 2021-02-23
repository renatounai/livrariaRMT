package br.com.livrariaRTM.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.livrariaRTM.pojo.ObjetoPadrao;


public class BaseDAO {
    private Class<?> classe;
    private EntityManager entityManager;

    public BaseDAO(Class<?> classe) {
        this.classe = classe;
        entityManager = Conexao.getInstance().getCurrentEntityManager();
    }

    public ObjetoPadrao selecionar(Object id) {
    	ObjetoPadrao objeto = (ObjetoPadrao)entityManager.find(classe, id);
        entityManager.flush();
        return objeto;
    }

    public void incluir(ObjetoPadrao objeto) {
        entityManager.persist(objeto);
        entityManager.flush();
        entityManager.refresh(objeto);
        entityManager.flush();
    }
    
    public void salvar(ObjetoPadrao objeto) {
    	entityManager.merge(objeto);
        entityManager.flush();
    }

    public void excluir(ObjetoPadrao objeto) {
        entityManager.remove(objeto);
        entityManager.flush();
    }

    public List<?> selecionarTodos(String ordenarPor) {
    	Query query = entityManager.createQuery("select objeto from " + classe.getSimpleName() + " objeto order by " + ordenarPor);
    	query.setHint("org.hibernate.cacheable", true);
        return query.getResultList();
    }

    public List<?> selecionarTodos() {
    	Query query = entityManager.createQuery("select objeto from " + classe.getSimpleName() + " objeto");
    	query.setHint("org.hibernate.cacheable", true);
        return query.getResultList();
    }
    
    public long getQuantidadeRegistros(){
    	Query query = entityManager.createQuery("select count(registro) from "+classe.getSimpleName()+" registro");
    	return (Long)query.getSingleResult();
    }
    
    protected EntityManager getEntityManager() {
		return entityManager;
	}
}
