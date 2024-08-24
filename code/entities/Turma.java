package code.entities;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private int numero;
    private Disciplina disciplina;
    private List<Aluno> alunos = new ArrayList<>();

    public Turma(int numero, Disciplina disciplina) {
        this.numero = numero;
        this.disciplina = disciplina;
    }

    public void matricularAluno(Aluno aluno) {
        // Lógica para matricular alunos
    }

    public void cancelarMatricula(Aluno aluno) {
        // Lógica para cancelar matricula dos alunos
    }

    public boolean verificarVagas() {
        // Lógica para verificar se existem vagas disponíveis para mais alunos
        return true;
    }

    public void verificarAtivacao() {
        // Lógica para verificar se existem alunos suficientes para iniciarem a turma

    }

    private void cancelarDisciplina() {
        // Método para cancelar a disciplina
    }
    
    // Getters e Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}
