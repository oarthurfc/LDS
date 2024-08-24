package code.entities;

import java.util.List;

public class Professor {
    private String matricula;
    private String nome;
    private String CPF;
    private List<Turma> turmas;

    public Professor(String matricula, String nome, String CPF) {
        this.matricula = matricula;
        this.nome = nome;
        this.CPF = CPF;
    }

    public void visualizarAlunos() {
        for (Turma turma : turmas) {
            System.out.println("Alunos na turma " + turma.getNumero() + ":");
            for (Aluno aluno : turma.getAlunos()) {
                System.out.println(aluno.getNome());
            }
        }
    }

    // Getters e Setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cPF) {
        CPF = cPF;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

}

