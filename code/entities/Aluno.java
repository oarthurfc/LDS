package code.entities;

public class Aluno {
    private String matricula;
    private String nome;
    private String CPF;

    public Aluno(String matricula, String nome, String CPF) {
        this.matricula = matricula;
        this.nome = nome;
        this.CPF = CPF;
    }

    public void matricularEmTurma(Turma turma) {
        // Lógica para matricular aluno à turma
    }

    public void cancelarMatriculaEmTurma(Turma turma) {
        // Lógica para cancelar matricula no aluno na turma
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
}
