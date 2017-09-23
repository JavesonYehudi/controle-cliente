package br.com.marlene.joias.controle;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.marlene.joias.dao.GenericDao;

@Controller
public abstract class GenericController<T> {
	@Inject
	protected Result result;
	@Inject
	protected GenericDao<T> dao;

	public abstract void listarTodos();
	public abstract void salvar(T entity);
	public abstract void encontrar(Integer id);
	public abstract void excluir(Integer id);
}
