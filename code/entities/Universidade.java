package code.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Universidade implements Serializable {
    private String nome;
    private String endereco;
    private String CNPJ;
    private List<Curso> cursos;
    private List<Aluno> alunos;
    private List<Professor> professor;

    public Universidade(String nome, String endereco, String CNPJ) {
        this.nome = nome;
        this.endereco = endereco;
        this.CNPJ = CNPJ;
        this.cursos = new ArrayList<>();
        this.alunos = new ArrayList<>();
        this.professor = new ArrayList<>();
    }

    public String gerarCurriculo() {
        StringBuilder curriculo = new StringBuilder();
    curriculo.append("Currículo da ").append(nome).append(":\n");

    for (Curso curso : cursos) {
        curriculo.append("- Curso: ").append(curso.getNome()).append("\n");

        for (Disciplina disciplina : curso.getDisciplinas()) {
            curriculo.append("  * Disciplina: ").append(disciplina.getNome()).append("\n");

            for (Turma turma : disciplina.getTurmas()) {
                curriculo.append("    * Turma: ").append(turma.getNumero()).append(" (Ano: ").append(turma.getAno()).append(")\n");

                if (turma.getAlunos() != null && !turma.getAlunos().isEmpty()) {
                    curriculo.append("      - Alunos:\n");
                    for (Aluno aluno : turma.getAlunos()) {
                        curriculo.append("        * ").append(aluno.getNome()).append(" (Matrícula: ").append(aluno.getMatricula()).append(")\n");
                    }
                } else {
                    curriculo.append("      - Nenhum aluno matriculado.\n");
                }

                Professor professor = (Professor) turma.getProfessor();
                if (professor != null) {
                    curriculo.append("      - Professor: ").append(professor.getNome()).append(" (Matrícula: ").append(professor.getMatricula()).append(")\n");
                } else {
                    curriculo.append("      - Nenhum professor atribuído.\n");
                }
            }
        }
    }

    return curriculo.toString();
    }

    

    public void visualizarCursos() {
        if (cursos.isEmpty()) {
            System.out.println("Nenhum curso cadastrado.");
        } else {
            for (Curso curso : cursos) {
                System.out.println("- Curso: " + curso.getNome());
            }
        }
    }

    public void adicionarCurso(Curso curso) {
        cursos.add(curso);
        System.out.println("Curso " + curso.getNome() + " adicionado com sucesso.");
    }

    public void removerCurso(String nomeCurso) {
        cursos.removeIf(curso -> curso.getNome().equals(nomeCurso));
        System.out.println("Curso " + nomeCurso + " removido com sucesso.");
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }


    public Aluno buscarAlunoPorNome(String nomeAluno) {
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nomeAluno.trim())) { // Comparação sem case sensitive
                return aluno;
            }
        }
        return null;
    }


}
