package br.com.marlene.joias.controle;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.serialization.gson.WithoutRoot;
import br.com.caelum.vraptor.view.Results;
import br.com.marlene.joias.dao.CidadeDao;
import br.com.marlene.joias.modelo.Cidade;
import br.com.marlene.joias.modelo.Estado;

@Controller
@Path("cidades")
public class CidadeController extends GenericController<Cidade> {

	@Get("")
	@Override
	public void listarTodos() {
		result.use(Results.json()).withoutRoot().from(dao.lista()).serialize();
	}
	
	@Get("/por-estado/{id-estado}")
	@Consumes(value = "application/json", options = WithoutRoot.class)
	public void listarTodos(Integer id) {
		result.use(Results.json()).withoutRoot().from(((CidadeDao)dao).lista(new Estado(id))).serialize();
	}

	@Post("")
	@Consumes(value = "application/json", options = WithoutRoot.class)
	@Override
	public void salvar(Cidade entity) {
		result.use(Results.json()).withoutRoot().from("Metodo não implementado para cidades").serialize();
	}

	@Get("{id}")
	@Override
	public void encontrar(Integer id) {
		result.use(Results.json()).withoutRoot().from(((CidadeDao)dao).lista(new Estado(id))).serialize();
	}

	@Delete("{id}")
	@Override
	public void excluir(Integer id) {
		result.use(Results.json()).withoutRoot().from("Metodo não implementado para cidades").serialize();
	}
}
