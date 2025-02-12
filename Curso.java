import java.util.List;
import java.util.ArrayList;

public class Curso{
    private String nomeCurso;
    private List<Disciplina> disciplinas; 


    public Curso(){
        this("");
    }

    public Curso(String nomeCurso){
        this.nomeCurso = nomeCurso;
        this.disciplinas = new ArrayList<Disciplina>();
    }

    public void setNomeCurso(String nomeCurso){
        this.nomeCurso = nomeCurso;
    }

    public String getNomeCurso(){
        return this.nomeCurso;
    }

    public void setDisciplinas(List<Disciplina> disciplinas){
        this.disciplinas = disciplinas;
    }

    public List<Disciplina> getDisciplinas(){
        return this.disciplinas;
    }

    public void addDisciplina(Disciplina disciplina){
        this.disciplinas.add(disciplina);
    }

    public int cargaHorariaTotal(){
        int cargaHoraria = 0;
        for(Disciplina n : disciplinas){
            cargaHoraria += n.getCargahoraria();
        }
        return cargaHoraria;
    }

    @Override
    public String toString(){
        return "Curso{" +
                "NomeCurso=" + getNomeCurso() +
                "CargaHoraria=" + cargaHorariaTotal() +
                "\n*** Disciplinas ***" + getDisciplinas() +
                "}";
    }
}