package code.entities;

public class Disciplina {
    private String nome;
    private Curso curso;

    public Disciplina(String nome, Curso curso) {
        this.nome = nome;
        this.curso = curso;
    }

    public void ativarDisciplina() {
        // Lógica para ativar a disciplina se houver alunos suficientes
    }

    public void cancelarDisciplina() {
        // Lógica para cancelar a disciplina se não houver alunos suficientes
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