package dominio;

import javax.annotation.processing.Generated;

@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "valorTotal")
    private double valorTotal;

    // Representa um relacionamento Many-to-Many
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "venda_produto",
        joinColumns = @JoinColumn(name = "venda_id"),
        inverseJoinColumns = @JoinColumn(name = "produto_id"))

    private List<Produto> produtos;
    //private Cliente;

    public Venda(){
        this();
    }

    public Venda(double valorTotal){
        this.valorTotal = valorTotal;
    }

    public void setId(Long Id){
        this.Id = Id;
    }

    public Long getId(){
        return this.id;
    }

    public void setValorTotal(double valorTotal){
        this.valorTotal = valorTotal;
    }

    public double getValorTotal(){
        return this.valorTotal;
    }

    public void setProdutos(List<Produto> produtos){
        this.produtos = produtos;
    }

    public List<Produto> getProdutos(){
        return this.produtos;
    } 

    @Override
    public String toString(){
        return "Venda[id=" + Id + ", valor total =" + valorTotal + "]";
    }
    
}