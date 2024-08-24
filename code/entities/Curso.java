package code.entities;

import java.util.List;

public class Curso {
    private String nome;
    private int numCreditos;
    private List<Disciplina> disciplinas;
    private List<Professor> professores;
    private List<Aluno> alunos;

    public Curso(String nome, int numCreditos) {
        this.nome = nome;
        this.numCreditos = numCreditos;
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        // Lógica para adicionar disciplina ao curso
    }

    public void removerDisciplina(Disciplina disciplina) {
        // Lógica para remover disciplina do curso
    }

    //Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumCreditos() {
        return numCreditos;
    }

    public void setNumCreditos(int numCreditos) {
        this.numCreditos = numCreditos;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

}
