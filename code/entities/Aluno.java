package code.entities;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


public class Aluno implements Serializable{
    private String matricula;
    private String nome;
    private String CPF;
    private List<Turma> turmas;

    public Aluno(String matricula, String nome, String CPF) {
        this.matricula = matricula;
        this.nome = nome;
        this.CPF = CPF;
        this.turmas = new ArrayList<Turma>();
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
    
    public List<Turma> visualizarTurmas() {
        return turmas;
    }
}
