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
import br.com.marlene.joias.modelo.Cliente;

@Controller
@Path("clientes")
public class ClienteController extends GenericController<Cliente>{

	@Get("")
	@Override
	public void listarTodos() {
		result.use(Results.json()).withoutRoot().from(dao.lista()).include("documentos", "telefones", "enderecos").serialize();
	}

	@Post("")
	@Consumes(value = "application/json", options = WithoutRoot.class)
	@Override
	public void salvar(Cliente cliente) {
		try {
			System.out.println(cliente);
			result.use(Results.json()).withoutRoot().from(dao.salva(cliente)).serialize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Get("{id}")
	@Override
	public void encontrar(Integer id) {
		result.use(Results.json()).withoutRoot().from(dao.carrega(BigInteger.valueOf(id.longValue()))).include("documentos", "telefones", "enderecos", "enderecos.estado", "enderecos.cidade").serialize();
	}

	@Delete("{id}")
	@Override
	public void excluir(Integer id) {
		System.out.println("Deletou " + id);
		result.use(Results.json()).withoutRoot().from(true).serialize();
	}
}