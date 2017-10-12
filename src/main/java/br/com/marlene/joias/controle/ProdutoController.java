package br.com.marlene.joias.controle;

import java.math.BigInteger;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.serialization.gson.WithoutRoot;
import br.com.caelum.vraptor.view.Results;
import br.com.marlene.joias.modelo.venda.Produto;

@Controller
@Path("produtos")
public class ProdutoController extends GenericController<Produto> {

	@Get("")
	@Override
	public void listarTodos() {
		result.use(Results.json()).withoutRoot().from(dao.lista()).serialize();
	}

	@Post("")
	@Consumes(value = "application/json", options = WithoutRoot.class)
	@Override
	public void salvar(Produto produto) {
		try {
			System.out.println(produto);
			dao.salva(produto);
			result.use(Results.json()).withoutRoot().from(produto).serialize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Get("{id}")
	@Override
	public void encontrar(Integer id) {
		result.use(Results.json()).withoutRoot().from(dao.carrega(BigInteger.valueOf(id.longValue()))).serialize();
	}

	@Delete("{id}")
	@Override
	public void excluir(Integer id) {
		System.out.println("Deletou " + id);
		result.use(Results.json()).withoutRoot().from(true).serialize();
	}

}
