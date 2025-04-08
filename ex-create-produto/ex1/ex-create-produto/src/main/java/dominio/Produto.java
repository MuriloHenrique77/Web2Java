package dominio;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private double preco;

    private List<Venda> vendas;

    @ManyToMany(mappedBy = "vendas")


    public Produto(){
        this("", 0);
    }

    public Produto(String nome, double preco){
        this.nome = nome;
        this.preco = preco;
    }
    
    public void setId(Long Id){
        this.Id = Id;
    }

    public Long getId(){
        return this.Id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

    public double getPreco(){
        return this.preco;
    }

    public void setVenda(List<Vendas> vendas){
        this.vendas = vendas;
    }

    public List<Venda> getVenda(){
        return this.venda;
    }

    @Override
    public String toString(){
        return "Produto[nome=" + nome + ", preço=" + preco + "]";
    }
}