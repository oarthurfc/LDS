package code.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Turma implements Serializable {
    private int numero;
    private String ano;
    public Disciplina disciplina;
    private Professor professor;
    private List<Aluno> alunos;

    public Turma(int numero, String ano, Disciplina disciplina, Professor professor) {
        this.numero = numero;
        this.ano = ano;
        this.disciplina = disciplina;
        this.professor = professor;
        this.alunos = new ArrayList<>();
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void matricularAluno(Aluno aluno) {
        if (disciplina.isAtiva()) {            
            alunos.add(aluno);
            aluno.getTurmas().add(this);
            System.out.println("Aluno " + aluno.getNome() + " matriculado na turma " + numero + ".");
            System.out.println("Sistema financeiro notificado.");
        } else {
            System.out.println("Não foi possível realizar a matrícula nessa disciplina, pois ela se encontra desativada");
        }
    }

    public void cancelarMatricula(Aluno aluno) {
        alunos.remove(aluno);
        aluno.getTurmas().remove(this);
        System.out.println("Aluno " + aluno.getNome() + " desmatriculado com successo da turma " + numero + " de " + disciplina.getNome() + ".");
        System.out.println("Sistema financeiro notificado.");
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

    public Professor getProfessor() {
        return professor;
    }

    public String getAno() {
        return ano;
    }


}
