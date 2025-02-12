public class Pessoa{
    private String nome;
    private int idade;
    private long cpf;

    public Pessoa(){
        this("", 0, 0);
    }

    public Pessoa(String nome, int idade){
        this(nome,idade,0);
    }

    public Pessoa (String nome, int idade, long cpf){
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public int getIdade(){
        return this.idade;
    }

    public void setCpf(long cpf){
        this.cpf = cpf;
    }
    
    public long getCpf(){
        return this.cpf;
    }

    @Override
    public String toString(){
        return "Pessoa{Nome=" + this.getNome() + 
                ", Idade=" + this.getIdade() +
                ", CPF=" + this.getCpf();
    }
}