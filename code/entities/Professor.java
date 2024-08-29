package code.entities;

import java.io.Serializable;

import java.util.List;

public class Professor implements Serializable{
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
            System.out.println("TURMA " + turma + "/n");
            System.out.println(turma.getAlunos());
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

