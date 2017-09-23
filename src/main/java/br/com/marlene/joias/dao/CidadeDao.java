package br.com.marlene.joias.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.marlene.joias.modelo.Cidade;
import br.com.marlene.joias.modelo.Estado;

public class CidadeDao extends GenericDao<Cidade> {

	public CidadeDao() {
		super(Cidade.class);
	}

	public List<Cidade> lista(Estado estado){
		CriteriaBuilder builder = this.getManager().getCriteriaBuilder();
	    CriteriaQuery<Cidade> criteria = builder.createQuery(Cidade.class);
	    Root<Cidade> root = criteria.from(Cidade.class);

		criteria.where(builder.equal(root.get("estado"), estado));
	    return this.getManager().createQuery(criteria).getResultList();
	}
}
