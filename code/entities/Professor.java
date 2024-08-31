package code.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Professor implements Serializable {
   private String matricula;
    private String nome;
    private String CPF;
    private List<Turma> turmas;

    public Professor(String matricula, String nome, String CPF) {
        this.matricula = matricula;
        this.nome = nome;
        this.CPF = CPF;
        this.turmas = new ArrayList<>();
    }

    public List<Aluno> visualizarAlunos() {
        List<Aluno> alunos = new ArrayList<>();
        for (Turma turma : turmas) {
            alunos.addAll(turma.getAlunos());
        }
        return alunos;
    }

    public String getNome() {
        return nome;
    }

	public Object getMatricula() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getMatricula'");
	}

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void adicionarTurma(Turma turma) {
        turmas.add(turma);
    }

    public void add(Professor professor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

}
