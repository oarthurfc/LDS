package code.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Curso implements Serializable {
    private String nome;
    private int numCreditos;
    private List<Disciplina> disciplinas;

    public Curso(String nome, int numCreditos) {
        this.nome = nome;
        this.numCreditos = numCreditos;
        this.disciplinas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
        System.out.println("Disciplina " + disciplina.getNome() + " adicionada com sucesso.");
    }

    public void removerDisciplina(String nomeDisciplina) {
        // Usa um booleano para verificar se alguma disciplina foi removida
        boolean removida = disciplinas.removeIf(disciplina -> disciplina.getNome().equalsIgnoreCase(nomeDisciplina));
        
        if (removida) {
            System.out.println("Disciplina " + nomeDisciplina + " removida com sucesso.");
        } else {
            System.out.println("Disciplina " + nomeDisciplina + " não encontrada.");
        }
    }
    

}
