package code.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Disciplina implements Serializable {
    private String nome;
    private List<Turma> turmas;
    private boolean ativa;

    public Disciplina(String nome) {
        this.nome = nome;
        this.turmas = new ArrayList<>();
        this.ativa = false;
    }

    public String getNome() {
        return nome;
    }

    public void ativarDisciplina() {
        ativa = true;
        System.out.println("Disciplina " + nome + " ativada.");
    }

    public void desativarDisciplina() {
        ativa = false;
        System.out.println("Disciplina " + nome + " desativada.");
    }

    public boolean isAtiva() {
        return ativa;
    }

    public int verificarQntdAlunos() {
        int totalAlunos = 0;
        for (Turma turma : turmas) {
            totalAlunos += turma.getAlunos().size();
        }
        return totalAlunos;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void adicionarTurma(Turma turma) {
        turmas.add(turma);
    }
    

}
