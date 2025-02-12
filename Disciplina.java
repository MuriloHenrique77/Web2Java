import java.util.List;
import java.util.ArrayList;

public class Disciplina{
    private String nomeDisciplina;
    private int cargaHoraria;
    private List<Aluno> alunos;
    private List<Professor> professores;

    public Disciplina(){
        this("", 0, new ArrayList<Aluno>(), new ArrayList<Professor>());
    }

    public Disciplina(String nomeDisciplina, int cargaHoraria){
        this(nomeDisciplina, cargaHoraria, new ArrayList<Aluno>(), new ArrayList<Professor>());
    }

    public Disciplina(String nomeDisciplina, int cargaHoraria, List<Aluno> alunos, List<Professor> professores){
        this.nomeDisciplina = nomeDisciplina;
        this.cargaHoraria = cargaHoraria;
        this.alunos = alunos;
        this.professores = professores;
        
    }

    public void setCargaHoraria(int cargaHoraria){
        this.cargaHoraria = cargaHoraria;
    }

    public int getCargahoraria(){
        return this.cargaHoraria;
    }

    public void setNomeDisciplina(String nomeDisciplina){
        this.nomeDisciplina = nomeDisciplina;
    }

    public String getNomeDisciplina(){
        return this.nomeDisciplina;
    }

    public void setAlunos(List<Aluno> alunos){
        this.alunos = alunos;
    }

    public List<Aluno> getAlunos(){
        return this.alunos;
    }

    public void setProfessores(List<Professor> professores){
        this.professores = professores;
    }

    public List<Professor> getProfessores(){
        return this.professores;
    }

    public void addAluno(Aluno aluno){
        this.alunos.add(aluno);
    }

    public void addProfessor(Professor professor){
        this.professores.add(professor);
    }

    @Override
    public String toString(){
        return "Disciplina{" +
                getNomeDisciplina() +
                ", cargaHoraria=" + getCargahoraria() +
                ", \n*** Alunos ***" + getAlunos() +
                ", \n*** Professores ***" + getProfessores() +
                "}";
    }
}