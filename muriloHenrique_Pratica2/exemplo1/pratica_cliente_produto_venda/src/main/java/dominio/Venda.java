package dominio;

import java.util.List;
import javax.persistence.*;

@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private double valorTotal;

    // Relacionamento Many-to-Many com Produto
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "venda_produto",
        joinColumns = @JoinColumn(name = "venda_id"),
        inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<Produto> produtos;

    // Relacionamento Many-to-One com Cliente
    @ManyToOne
    @JoinColumn(name = "cliente_id") 
    private Cliente cliente;

    public Venda() {
        this(0);
    }

    public Venda(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public Long getId() {
        return this.Id;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorTotal() {
        return this.valorTotal;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Produto> getProdutos() {
        return this.produtos;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    @Override
    public String toString() {
        return "Venda[id=" + Id + ", valor total=" + valorTotal + "]";
    }
}
