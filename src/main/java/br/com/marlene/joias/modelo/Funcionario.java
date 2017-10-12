package br.com.marlene.joias.modelo;

import br.com.marlene.joias.modelo.venda.Compra;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "funcionario")
public class Funcionario implements Serializable{

    private int id;
    private String nome;

    public Funcionario() {}

    public Funcionario(String nome) {
        this.nome = nome;
    }

    @Id
    @SequenceGenerator(name = "funcionario_id_seq", sequenceName = "funcionario_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "funcionario_id_seq")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
