package br.com.livrariaRTM.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.livrariaRTM.pojo.Livro;

public class LivroDAO extends BaseDAO {

	public LivroDAO() {
		super(Livro.class);
	}
	
	public List<String> getCategorias(){
		Query query = getEntityManager().createQuery("select distinct livro.categoria from Livro livro order by livro.categoria");
		return query.getResultList();
	}
	
	public List<Livro> getPorCategoria(String categoria){
		Query query = getEntityManager().createQuery("select livro from Livro livro where livro.categoria=:categoria order by livro.titulo");
		query.setParameter("categoria", categoria);
		
		return query.getResultList();
	}
	
	public List<Livro> getEmPromocao(){
		Query query = getEntityManager().createQuery("select livro from Livro livro where livro.promocao = true");
		
		return query.getResultList();
	}
	
	public List<Livro> getLancamentos(){
		Query query = getEntityManager().createQuery("select livro from Livro livro order by livro.dataLancamento desc");
		query.setMaxResults(5);
		
		return query.getResultList();
	}

}
