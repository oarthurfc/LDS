package code.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Universidade implements Serializable {
    private String nome;
    private String endereco;
    private String CNPJ;
    private List<Curso> cursos;

    public Universidade(String nome, String endereco, String CNPJ) {
        this.nome = nome;
        this.endereco = endereco;
        this.CNPJ = CNPJ;
        this.cursos = new ArrayList<>();
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

                    Professor professor = turma.getProfessor();
                    if (professor != null) {
                        curriculo.append("      - Professor: ").append(professor.getNome())
                                .append(" (Matrícula: ").append(professor.getMatricula()).append(")\n");
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

    public Aluno buscarAlunoPorNome(String nomeAluno) {

        Aluno alunoP = null;

        for (Curso curso : cursos) {
            for (Disciplina disciplina : curso.getDisciplinas()) {
                for (Turma turma : disciplina.getTurmas()) {
                    // Corrigindo para encontrar o primeiro aluno com o nome desejado
                    alunoP = turma.getAlunos().stream()
                            .filter(a -> a.getNome().equals(nomeAluno))
                            .findFirst()
                            .orElse(null);
    
                    // Caso o aluno seja encontrado, podemos interromper a busca
                    if (alunoP != null) {
                        return alunoP;
                    }
                }
            }
        }

        return alunoP;
    }

    // Método para visualizar os alunos de um professor
    public List<Aluno> visualizarAlunosDoProfessor(Professor professor) {
        List<Aluno> alunosDoProfessor = new ArrayList<>();
        for (Curso curso : cursos) {
            for (Disciplina disciplina : curso.getDisciplinas()) {
                for (Turma turma : disciplina.getTurmas()) {
                    if (turma.getProfessor() != null && turma.getProfessor().equals(professor)) {
                        alunosDoProfessor.addAll(turma.getAlunos());
                    }
                }
            }
        }
        return alunosDoProfessor;
    }
}

