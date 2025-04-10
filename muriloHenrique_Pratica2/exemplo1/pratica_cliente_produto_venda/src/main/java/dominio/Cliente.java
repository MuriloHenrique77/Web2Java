package dominio;

import java.util.List;
import javax.persistence.*;

@Entity
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String nome;

    // Relacionamento Many-to-Many com Venda
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "cliente_venda", 
        joinColumns = @JoinColumn(name = "cliente_id"), 
        inverseJoinColumns = @JoinColumn(name = "venda_id") 
    )
    private List<Venda> vendas;

    public Cliente() {
        this("");
    }

    public Cliente(String nome) {
        this.nome = nome;
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

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    public List<Venda> getVendas() {
        return this.vendas;
    }

    @Override
    public String toString() {
        return "cliente[nome=" + nome + "]";
    }
}
