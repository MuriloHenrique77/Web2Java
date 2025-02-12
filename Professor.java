public class Professor extends Pessoa{
    private int idProfessor;

    public Professor(){
        this("",0,0l,0);
    }

    public Professor(String nome, int idade){
        this(nome,idade, 0l, 0);
        
    }

    public Professor(String nome, int idade, long cpf, int idProfessor){
        super(nome, idade, cpf);
        this.idProfessor = idProfessor;
    }

    public void setIdProfessor(int idProfessor){
        this.idProfessor = idProfessor;
    }

    public int getIdProfessor(){
        return this.idProfessor;
    }

    @Override
    public String toString(){
        return "\nProfessor{" + super.toString() +
                ", idProfessor=" + getIdProfessor() + "}";
    }
}