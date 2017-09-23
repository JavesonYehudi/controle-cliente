package br.com.marlene.joias.controle;

import java.math.BigInteger;
import java.util.Calendar;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.serialization.gson.WithoutRoot;
import br.com.caelum.vraptor.view.Results;
import br.com.marlene.joias.modelo.venda.Compra;
import br.com.marlene.joias.modelo.venda.Parcela;

@Path("compras")
@Controller
public class CompraController extends GenericController<Compra> {

	@Get("")
	@Override
	public void listarTodos() {
		result.use(Results.json()).withoutRoot().from(dao.lista()).include("cliente", "parcelas", "itens").serialize();
	}

	@Post("")
	@Consumes(value = "application/json", options = WithoutRoot.class)
	@Override
	public void salvar(Compra compra) {
		try {
			System.out.println(compra);
			criarParcelas(compra);
			result.use(Results.json()).withoutRoot().from(dao.salva(compra)).serialize();
		} catch (Exception e) {
			e.printStackTrace();
			result.use(Results.http()).body(e.toString()).setStatusCode(400); //.badRequest(e.toString());
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

	/**
	 * Cria as parcelas da compra
	 * de acordo com a quantidade de parcelas 
	 * e o valor da parcela passados na compra
	 * @param compra
	 */
	private void criarParcelas(Compra compra){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(compra.getDataPrimeiraParcela());

		for(int i = 0; i < compra.getQuantidadeDeParcelas(); i++){
			Parcela parcela = new Parcela();
			parcela.setValorVencimento(compra.getValorDaParcela());
			parcela.setDataVencimento(calendar.getTime());
			calendar.add(Calendar.MONTH, 1);
			compra.getParcelas().add(parcela);
		}
	}
}
