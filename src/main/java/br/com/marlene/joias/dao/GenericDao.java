package br.com.marlene.joias.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class GenericDao<T> {

	@Inject
	private EntityManager manager;
	private Class<T> entity;

	public GenericDao(Class<T> entity) {
		this.entity = entity;
	}

	public EntityManager getManager() {
		return manager;
	}

	public T carrega(Object id) {
		return this.getManager().find(entity, id);
	}

	public T salva(T t) {
		return this.getManager().merge(t);
	}
	
	public List<T> lista(){
		CriteriaBuilder builder = this.getManager().getCriteriaBuilder();
	    CriteriaQuery<T> criteria = builder.createQuery(entity);
	    criteria.from(entity);
	    return this.getManager().createQuery(criteria).getResultList();
	}
}
