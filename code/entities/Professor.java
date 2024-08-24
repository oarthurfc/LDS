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
        //Lógica para visualizar os alunos de cada turma
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

