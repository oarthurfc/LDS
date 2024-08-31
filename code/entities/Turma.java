package code.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Turma implements Serializable {
    private int numero;
    private String ano;
    public Disciplina disciplina;
    private List<Professor> professor;
    private List<Aluno> alunos;

    public Turma(int numero, String ano, Disciplina disciplina, Professor professor) {
        this.numero = numero;
        this.ano = ano;
        this.disciplina = disciplina;
        this.professor = new ArrayList<>();
        this.alunos = new ArrayList<>();
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void matricularProfessor(Professor professor) {
        professor.add(professor);
        professor.getTurmas().add(this);
        System.out.println("Aluno " + professor.getNome() + " matriculado na turma " + numero + ".");
    }


    public void matricularAluno(Aluno aluno) {
        alunos.add(aluno);
        aluno.getTurmas().add(this);
        System.out.println("Aluno " + aluno.getNome() + " matriculado na turma " + numero + ".");
    }

    public void cancelarMatricula(Aluno aluno) {
        alunos.remove(aluno);
        aluno.getTurmas().remove(this);
        System.out.println("Aluno " + aluno.getNome() + " desmatriculado da turma " + numero + ".");
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
  
    public int getNumero() {
        return numero;
    }

    public List<Professor> getProfessor() {
        return professor;
    }

    public Object getAno() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAno'");
    }


}
