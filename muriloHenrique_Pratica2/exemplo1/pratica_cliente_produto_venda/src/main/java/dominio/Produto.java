package dominio;

import java.util.List;
import javax.persistence.*;
import javax.persistence.CascadeType;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String nome;
    private double preco;

    // Relacionamento Many-to-Many com Venda
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "produto_venda", 
        joinColumns = @JoinColumn(name = "produto_id"), 
        inverseJoinColumns = @JoinColumn(name = "venda_id") 
    )
    private List<Venda> vendas;

    public Produto() {
        this("", 0);
    }

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public Long getId() {
        return this.Id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    public List<Venda> getVendas() {
        return this.vendas;
    }

    @Override
    public String toString() {
        return "Produto[nome=" + nome + ", preço=" + preco + "]";
    }
}
