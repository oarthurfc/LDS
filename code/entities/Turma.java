package code.entities;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

public class Turma implements Serializable{
    private int numero;
    private Disciplina disciplina;
    private Professor professor;

    private List<Aluno> alunos = new ArrayList<>();

    public Turma(int numero, Disciplina disciplina, Professor professor) {
        this.numero = numero;
        this.disciplina = disciplina;
        this.professor = professor;
    }

    public void matricularAluno(Aluno aluno) {
        if (disciplina.verificarQntdAlunos() < 60) {
            alunos.add(aluno);
        } else {
            System.out.println("Turma cheia. Não é possível matricular mais alunos.");
        }    
    }

    public void cancelarMatricula(Aluno aluno) {
        alunos.remove(aluno);
    }

    // Getters e Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
