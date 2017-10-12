package br.com.marlene.joias.controle;

import br.com.caelum.vraptor.*;
import br.com.caelum.vraptor.serialization.gson.WithoutRoot;
import br.com.caelum.vraptor.view.Results;
import br.com.marlene.joias.modelo.Funcionario;

import java.math.BigInteger;
import java.util.List;

@Controller
@Path("funcionarios")
public class FuncionarioController extends GenericController<Funcionario>{
    @Get("")
    @Override
    public void listarTodos() {
        List<Funcionario> lista = dao.lista();
        System.out.print(lista);
        result.use(Results.json()).withoutRoot().from(lista).serialize();
    }

    @Post("")
    @Consumes(value = "application/json", options = WithoutRoot.class)
    @Override
    public void salvar(Funcionario funcionario) {
        try {
            System.out.println(funcionario);
            dao.salva(funcionario);
            result.use(Results.json()).withoutRoot().from(funcionario).serialize();
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

}
