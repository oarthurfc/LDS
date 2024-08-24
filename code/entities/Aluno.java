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
        turma.matricularAluno(this);
    }

    public void cancelarMatriculaEmTurma(Turma turma) {
        turma.cancelarMatricula(this);
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
