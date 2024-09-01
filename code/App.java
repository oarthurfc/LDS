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

        Disciplina disciplina1 = new Disciplina("Cálculo 1");
        Disciplina disciplina2 = new Disciplina("Cálculo 2");
        Disciplina disciplina3 = new Disciplina("Filosofia");

        curso1.adicionarDisciplina(disciplina1);
        curso1.adicionarDisciplina(disciplina2);
        curso2.adicionarDisciplina(disciplina3);

        Professor professor1 = new Professor("123", "Agnaldo", "111.111.111-11");
        Professor professor2 = new Professor("456", "Hugo", "222.222.222-22");

        Turma turma1 = new Turma(1, "2024", disciplina1, professor1);
        Turma turma2 = new Turma(2, "2024", disciplina2, professor2);
        Turma turma3 = new Turma(3, "2024", disciplina3, professor2);

        Aluno aluno1 = new Aluno("001", "Felipe", "333.333.333-33");
        Aluno aluno2 = new Aluno("002", "Arthur", "444.444.444-44");

        disciplina1.adicionarTurma(turma1);
        disciplina2.adicionarTurma(turma2);
        
        turma1.matricularAluno(aluno1);
        turma2.matricularAluno(aluno2);
        turma3.matricularAluno(aluno1);


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
                        System.out.println("2- Gerenciar Cursos");
                        System.out.println("3- Gerenciar Disciplinas");
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
                                System.out.print("Digite o nome do curso para gerenciar as disciplinas: ");
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
                                        System.out.println("3- Ativar Disciplina");
                                        System.out.println("4- Desativar Disciplina");
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
                                                System.out.print("Digite o nome da disciplina para ativada: ");
                                                scanner.nextLine(); // Consome a linha
                                                String ativarDisciplinaNome = scanner.nextLine();
                                                Disciplina disciplinaA = curso.getDisciplinas().stream()
                                                        .filter(d -> d.getNome().equals(ativarDisciplinaNome))
                                                        .findFirst()
                                                        .orElse(null);
                                                disciplinaA.ativarDisciplina();
                                                break;
                                            case 4:
                                                System.out.print("Digite o nome da disciplina para ser desativada: ");
                                                scanner.nextLine(); // Consome a linha
                                                String desativarDisciplinaNome = scanner.nextLine();
                                                Disciplina disciplinaD = curso.getDisciplinas().stream()
                                                        .filter(d -> d.getNome().equals(desativarDisciplinaNome))
                                                        .findFirst()
                                                        .orElse(null);
                                                disciplinaD.desativarDisciplina();
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

                            System.out.println("1- Visualizar Disciplinas Matriculadas");
                            System.out.println("2- Matricular em Disciplina");
                            System.out.println("3- Desmatricular de Disciplina");
                            System.out.println("0- Voltar");

                            int opcaoAluno = scanner.nextInt();
                            scanner.nextLine(); // Consome a linha restante após a leitura do inteiro

                            switch (opcaoAluno) {
                                case 0:
                                    System.out.println("Saindo do sistema...");
                                break;

                                case 1: // Visualizar Disciplinas Matriculadas
                                    System.out.println("Disciplinas matriculadas:");
                                    for (Turma turma : aluno.getTurmas()) {
                                        System.out.println("- " + turma.getDisciplina().getNome());
                                    }
                                break;

                                case 2: // Matricular em Disciplina
                                System.out.print("Digite o nome da disciplina para matricular: ");
                                String nomeDisciplinaMatricula = scanner.nextLine().trim();
                            
                                // Encontra a lista de turmas da disciplina especificada
                                List<Turma> turmasMatricula = universidade.getCursos().stream()
                                        .flatMap(c -> c.getDisciplinas().stream())
                                        .filter(d -> d.getNome().equalsIgnoreCase(nomeDisciplinaMatricula))
                                        .map(Disciplina::getTurmas)
                                        .findFirst()
                                        .orElse(null);
                            
                                if (turmasMatricula != null && !turmasMatricula.isEmpty()) {
                                    // Matricula o aluno na primeira turma encontrada (ou adapte conforme sua lógica)
                                    Turma turmaEscolhida = turmasMatricula.get(0);
                                    turmaEscolhida.matricularAluno(aluno);
                                    System.out.println("Matrícula realizada com sucesso na turma: " + turmaEscolhida.getNumero());
                                } else {
                                    System.out.println("Disciplina não encontrada ou sem turmas disponíveis.");
                                }
                            break;   

                                case 3:
                                    System.out.print("Digite o nome da disciplina para desmatricular: ");
                                    String nomeDisciplinaDesmatricula = scanner.nextLine().trim();
                                    Turma turmaDesmatricula = aluno.getTurmas().stream()
                                            .filter(t -> t.getDisciplina().getNome().equalsIgnoreCase(nomeDisciplinaDesmatricula))
                                            .findFirst()
                                            .orElse(null);
                                    if (turmaDesmatricula != null) {
                                        turmaDesmatricula.cancelarMatricula(aluno);
                                    } else {
                                        System.out.println("Disciplina não encontrada.");
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
                        
                        List<Aluno> alunosProfessor = universidade.visualizarAlunosDoProfessor(professor);
                        System.out.println("Alunos nas turmas do Professor " + professor.getNome() + ":");
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
