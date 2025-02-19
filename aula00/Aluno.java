public class Aluno extends Pessoa{
    private int matriculaAluno;

    public Aluno(){
        this("",0,0l,0);
    }

    public Aluno(String nome, int idade){
        this(nome,idade, 0l, 0);
    }

    public Aluno(String nome, int idade, long cpf, int matriculaAluno){
        super(nome, idade, cpf);
        this.matriculaAluno = matriculaAluno;
    }

    public void setMatriculaAluno(int matriculaAluno){
        this.matriculaAluno = matriculaAluno;
    }

    public int getMatriculaAluno(){
        return this.matriculaAluno;
    }

    @Override
    public String toString(){
        return "\nAluno{" + super.toString() +
                ", matricula=" + getMatriculaAluno() + "}";
    }

}