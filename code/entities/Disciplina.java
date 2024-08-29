package code.entities;

import java.io.Serializable;

import java.util.List;
import java.util.ArrayList;

public class Disciplina implements Serializable {
    private String nome;
    private Curso curso;
    private List<Turma> turmas;
    private boolean ativa;

    public Disciplina(String nome, Curso curso) {
        this.nome = nome;
        this.curso = curso;
        this.ativa = false;
        this.turmas = new ArrayList<>();
    }

    public void ativarDisciplina() {
        this.ativa = true;
    }
    
    public int verificarQntdAlunos() {
        int qntAlunos = 0;
        for (Turma turma : this.turmas) {
            qntAlunos += turma.getAlunos().size();
        }
        return qntAlunos;
    }

    public void desativarDisciplina() {
        this.ativa = false;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}