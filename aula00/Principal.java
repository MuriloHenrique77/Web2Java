public class Principal{

    public static void main(String args[]){

        Aluno aluno1 = new Aluno("Rafael", 34, 12345678910l, 1001);
        System.out.println(aluno1.toString());

        Aluno aluno2 = new Aluno("Gabriel", 28, 12345678910l, 2001);
        System.out.println(aluno2.toString());

        Professor professor1 = new Professor("Cecilia", 2, 45612378910l, 2002);
        System.out.println(professor1.toString());

        Professor professor2 = new Professor("Clara", 1, 45612378910l, 3002);
        System.out.println(professor2.toString());

        Disciplina disciplina = new Disciplina("Web II", 80);
        System.out.println(disciplina.toString());

        Disciplina disciplina2 = new Disciplina("Web I", 120);
        System.out.println(disciplina2.toString());

        disciplina.addAluno(aluno1);
        disciplina.addAluno(aluno2);

        disciplina.addProfessor(professor1);
        disciplina.addProfessor(professor2);

        System.out.println(disciplina.toString());
    
        Curso curso = new Curso("Sistemas de Informação");
        curso.addDisciplina(disciplina);  
        curso.addDisciplina(disciplina2); 
        System.out.println(curso.toString());    
    }
}