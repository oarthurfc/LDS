package code;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import code.entities.Universidade;
import code.entities.Aluno;
import code.entities.Curso;
import code.entities.Disciplina;
import code.entities.Professor;
import code.entities.Turma;

public class App {

    public static final String caminhoDoArquivo = "./code/file/universidade.dat";
    

    public static void main(String[] args) throws IOException, ClassNotFoundException  {
         Scanner scanner = new Scanner(System.in);
        Universidade universidade = new Universidade("Universidade X", "Endereço Y", "123456789");

        Curso curso1 = new Curso("Engenharia de Software", 40);
        Curso curso2 = new Curso("Direito", 30);
        universidade.adicionarCurso(curso1);
        universidade.adicionarCurso(curso2);

        Disciplina disciplina1 = new Disciplina("Programação Desorientada a Objetos");
        Disciplina disciplina2 = new Disciplina("Incalculável I");
        curso1.adicionarDisciplina(disciplina1);
        curso2.adicionarDisciplina(disciplina2);

        Professor professor1 = new Professor("123", "Agnaldo", "111.111.111-11");
        Professor professor2 = new Professor("456", "Hugo", "222.222.222-22");

        Turma turma1 = new Turma(1, "2024", disciplina1, professor1);
        Turma turma2 = new Turma(2, "2024", disciplina2, professor2);

        Aluno aluno1 = new Aluno("001", "Felipe", "333.333.333-33");
        Aluno aluno2 = new Aluno("002", "Arthur", "444.444.444-44");

        turma1.matricularAluno(aluno1);
        turma2.matricularAluno(aluno2);

        universidade.adicionarAluno(aluno1); 
        universidade.adicionarAluno(aluno2);

        while (true) {
            System.out.println("Qual o seu acesso?");
            System.out.println("1- Secretaria");
            System.out.println("2- Aluno");
            System.out.println("3- Professor");
            System.out.println("0- Sair do Sistema");

            int acesso = scanner.nextInt();

            if (acesso == 0) {
                System.out.println("Saindo do sistema...");
                break;
            }

            switch (acesso) {
                case 1: // Secretaria
                    while (true) {
                        System.out.println("1- Gerar Curriculo");
                        System.out.println("2- Visualizar Cursos");
                        System.out.println("3- Visualizar Disciplinas");
                        System.out.println("0- Voltar");

                        int opcaoSecretaria = scanner.nextInt();

                        if (opcaoSecretaria == 0) {
                            System.out.println("Saindo do sistema...");
                            break;
                        }

                        switch (opcaoSecretaria) {
                            case 1:
                                System.out.println(universidade.gerarCurriculo());
                                break;

                            case 2: // Visualizar Cursos
                                universidade.visualizarCursos();
                                while (true) {
                                    System.out.println("1- Adicionar Curso");
                                    System.out.println("2- Remover Curso");
                                    System.out.println("0- Voltar");

                                    int opcaoCurso = scanner.nextInt();

                                    if (opcaoCurso == 0) {
                                        System.out.println("Saindo do sistema...");
                                        break;
                                    }

                                    switch (opcaoCurso) {
                                        case 1:
                                            System.out.print("Digite o nome do curso: ");
                                            scanner.nextLine(); // Consome a linha
                                            String nomeCurso = scanner.nextLine();
                                            System.out.print("Digite o número de créditos: ");
                                            int numCreditos = scanner.nextInt();
                                            Curso novoCurso = new Curso(nomeCurso, numCreditos);
                                            universidade.adicionarCurso(novoCurso);
                                            break;

                                        case 2:
                                            System.out.print("Digite o nome do curso a ser removido: ");
                                            scanner.nextLine(); // Consome a linha
                                            String cursoRemover = scanner.nextLine();
                                            universidade.removerCurso(cursoRemover);
                                            break;
                                    }
                                }
                                break;

                            case 3: // Visualizar Disciplinas
                                System.out.print("Digite o nome do curso para ver as disciplinas: ");
                                scanner.nextLine(); // Consome a linha
                                String nomeCursoDisciplinas = scanner.nextLine();
                                Curso curso = universidade.getCursos().stream()
                                        .filter(c -> c.getNome().equals(nomeCursoDisciplinas))
                                        .findFirst()
                                        .orElse(null);

                                if (curso != null) {
                                    System.out.println("Disciplinas do curso " + curso.getNome() + ":");
                                    for (Disciplina disciplina : curso.getDisciplinas()) {
                                        System.out.println("- " + disciplina.getNome());
                                    }

                                    while (true) {
                                        System.out.println("1- Adicionar Disciplina");
                                        System.out.println("2- Remover Disciplina");
                                        System.out.println("3- Ativar/Desativar Disciplina");
                                        System.out.println("0- Voltar");

                                        int opcaoDisciplina = scanner.nextInt();

                                        if (opcaoDisciplina == 0) {
                                            System.out.println("Saindo do sistema...");
                                            break;
                                        }

                                        switch (opcaoDisciplina) {
                                            case 1:
                                                System.out.print("Digite o nome da disciplina: ");
                                                scanner.nextLine(); // Consome a linha
                                                String nomeDisciplina = scanner.nextLine();
                                                Disciplina novaDisciplina = new Disciplina(nomeDisciplina);
                                                curso.adicionarDisciplina(novaDisciplina);
                                                break;

                                            case 2:
                                                System.out.print("Digite o nome da disciplina a ser removida: ");
                                                scanner.nextLine(); // Consome a linha
                                                String disciplinaRemover = scanner.nextLine();
                                                curso.removerDisciplina(disciplinaRemover);
                                                break;

                                            case 3:
                                                System.out.print("Digite o nome da disciplina para ativar/desativar: ");
                                                scanner.nextLine(); // Consome a linha
                                                String disciplinaNome = scanner.nextLine();
                                                Disciplina disciplina = curso.getDisciplinas().stream()
                                                        .filter(d -> d.getNome().equals(disciplinaNome))
                                                        .findFirst()
                                                        .orElse(null);
                                                if (disciplina != null) {
                                                    if (disciplina.verificarQntdAlunos() > 0) {
                                                        disciplina.desativarDisciplina();
                                                    } else {
                                                        disciplina.ativarDisciplina();
                                                    }
                                                }
                                                break;
                                        }
                                    }
                                } else {
                                    System.out.println("Curso não encontrado.");
                                }
                                break;
                        }
                    }
                    break;

                case 2: // Aluno
                System.out.print("Digite o nome do aluno: ");
                scanner.nextLine().trim();
                String nomeAluno = scanner.nextLine().trim(); // Normaliza o nome do aluno

                Aluno aluno = universidade.buscarAlunoPorNome(nomeAluno);

                    if (aluno == null) {
                        System.out.println("Aluno não encontrado.");
                    } else {
                        while (true) {
                            System.out.println("1- Visualizar Disciplinas do Curso");
                            System.out.println("0- Voltar");

                            int opcaoAluno = scanner.nextInt();
                            scanner.nextLine(); // Consome a linha restante após a leitura do inteiro

                            if (opcaoAluno == 0) {
                                System.out.println("Saindo do sistema...");
                                break;
                            }

                            else if (opcaoAluno == 1) {
                                List<Turma> turmasDoAluno = aluno.getTurmas();
                                System.out.println("Turmas do aluno:");
                                turmasDoAluno.forEach((turma)-> System.out.println("    -" + turma.getDisciplina().getNome()));
                                break;
                            }

                            switch (opcaoAluno) {
                                case 1:
                                    System.out.println("1- Gerenciar Disciplinas");
                                    System.out.println("0- Voltar");

                                    int opcaoGerenciar = scanner.nextInt();
                                    scanner.nextLine(); // Consome a linha restante após a leitura do inteiro

                                    if (opcaoGerenciar == 0) {
                                        System.out.println("Saindo do sistema...");
                                        break;
                                    }

                                    switch (opcaoGerenciar) {
                                        case 1: // Gerenciar Disciplinas
                                            while (true) {
                                                System.out.println("1- Matricular em Disciplina");
                                                System.out.println("2- Visualizar Disciplinas Matriculadas");
                                                System.out.println("0- Voltar");

                                                int opcaoMatricular = scanner.nextInt();
                                                scanner.nextLine(); // Consome a linha restante após a leitura do inteiro

                                                if (opcaoMatricular == 0) {
                                                    System.out.println("Saindo do sistema...");
                                                    break;
                                                }

                                                switch (opcaoMatricular) {
                                                    case 1: // Matricular em Disciplina
                                                        System.out.print("Digite o nome da disciplina para matricular: ");
                                                        String nomeDisciplinaMatricula = scanner.nextLine().trim();
                                                        List<Turma> turmaMatricula = universidade.getCursos().stream()
                                                                .flatMap(c -> c.getDisciplinas().stream())
                                                                .filter(d -> d.getNome().equalsIgnoreCase(nomeDisciplinaMatricula))
                                                                .map(d -> d.getTurmas())
                                                                .findFirst()
                                                                .orElse(null);
                                                        if (turmaMatricula != null) {
                                                            ((Turma) turmaMatricula).matricularAluno(aluno);
                                                            System.out.println("Matrícula realizada com sucesso.");
                                                        } else {
                                                            System.out.println("Disciplina não encontrada.");
                                                        }
                                                        break;

                                                    case 2: // Visualizar Disciplinas Matriculadas
                                                        System.out.println("Disciplinas matriculadas:");
                                                        for (Turma turma : aluno.getTurmas()) {
                                                            System.out.println("- " + turma.getDisciplina().getNome());
                                                        }
                                                        while (true) {
                                                            System.out.println("1- Desmatricular em Disciplina");
                                                            System.out.println("0- Voltar");

                                                            int opcaoDesmatricular = scanner.nextInt();
                                                            scanner.nextLine(); // Consome a linha restante após a leitura do inteiro

                                                            if (opcaoDesmatricular == 0) {
                                                                System.out.println("Saindo do sistema...");
                                                                break;
                                                            }

                                                            switch (opcaoDesmatricular) {
                                                                case 1:
                                                                    System.out.print("Digite o nome da disciplina para desmatricular: ");
                                                                    String nomeDisciplinaDesmatricula = scanner.nextLine().trim();
                                                                    Turma turmaDesmatricula = aluno.getTurmas().stream()
                                                                            .filter(t -> t.getDisciplina().getNome().equalsIgnoreCase(nomeDisciplinaDesmatricula))
                                                                            .findFirst()
                                                                            .orElse(null);
                                                                    if (turmaDesmatricula != null) {
                                                                        turmaDesmatricula.cancelarMatricula(aluno);
                                                                        System.out.println("Desmatrícula realizada com sucesso.");
                                                                    } else {
                                                                        System.out.println("Disciplina não encontrada.");
                                                                    }
                                                                    break;
                                                            }
                                                        }
                                                        break;
                                                }
                                            }
                                            break;
                                    }
                                    break;
                            }
                        }
                    }
                    break;

                

                case 3: // Professor
                    System.out.print("Digite seu nome: ");
                    scanner.nextLine(); // Consome a linha
                    String nomeProfessor = scanner.nextLine();
                    Professor professor = null;

                    // Simulação de busca pelo professor (em um caso real, os dados viriam de um banco de dados)
                    if (nomeProfessor.equals(professor1.getNome())) {
                        professor = professor1;
                    } else if (nomeProfessor.equals(professor2.getNome())) {
                        professor = professor2;
                    }

                    if (professor != null) {
                        System.out.println("Bem-vindo, Professor " + professor.getNome() + "!");
                        List<Aluno> alunosProfessor = professor.visualizarAlunos();
                        System.out.println("Alunos nas suas turmas:");
                        for (Aluno alunoP : alunosProfessor) {
                            System.out.println("- " + alunoP.getNome());
                        }
                    } else {
                        System.out.println("Professor não encontrado.");
                    }
                    break;
            }
        }

        scanner.close();
    }


    

   
}
