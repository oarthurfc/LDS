package code;

import java.io.IOException;
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
    
            // Criação de alguns objetos para exemplo
            Universidade universidade = new Universidade("UNI ESQUINA", "Pça da Liberdade", "12222222");
            Curso curso = new Curso("Engenharia de Software", 180);
            Disciplina disciplina = new Disciplina("Cálculo 1", curso);
            Professor professor = new Professor("123", "Professor Exemplo", "CPF123456");
            Aluno aluno = new Aluno("1", "Aluno 1", "111");
            Turma turma = new Turma(1, disciplina, professor);
    
            universidade.adicionarCurso(curso);
            disciplina.ativarDisciplina();
            turma.matricularAluno(aluno);
    
            int mainChoice, subChoice;

            System.out.println("----------------------------------------");
            do {
                System.out.println("Qual o seu acesso?");
                System.out.println("1- Secretaria");
                System.out.println("2- Aluno");
                System.out.println("3- Professor");
                System.out.println("0- Sair do Sistema");
                mainChoice = scanner.nextInt();
    
                switch (mainChoice) {
                    case 1: // Secretaria
                        do {
                            System.out.println("1- Gerar Curriculo");
                            System.out.println("2- Visualizar Cursos");
                            System.out.println("3- Visualizar Disciplinas");
                            System.out.println("0- Voltar");
                            subChoice = scanner.nextInt();
    
                            switch (subChoice) {
                                case 1:
                                    universidade.gerarCurriculo();
                                    System.out.println("Curriculo gerado com sucesso.");
                                    break;
                                case 2:
                                    System.out.println("Visualizando Cursos");
                                    System.out.println("1- Adicionar Curso");
                                    System.out.println("2- Remover Curso");
                                    System.out.println("0- Voltar");
                                    int courseChoice = scanner.nextInt();
                                    switch (courseChoice) {
                                        case 1:
                                            universidade.adicionarCurso(curso);
                                            System.out.println("Curso adicionado com sucesso.");
                                            break;
                                        case 2:
                                            universidade.getCursos().remove(curso);
                                            System.out.println("Curso removido com sucesso.");
                                            break;
                                        case 0:
                                            break;
                                        default:
                                            System.out.println("Opção inválida.");
                                    }
                                    break;
                                case 3:
                                    System.out.println("Visualizando Disciplinas.");
                                    System.out.println("1- Adicionar Disciplina");
                                    System.out.println("2- Remover Disciplina");
                                    System.out.println("3- Verificar Quantidade De alunos");
                                    System.out.println("4- Ativar Disciplina");
                                    System.out.println("5- Desativar Disciplina");
                                    System.out.println("0- Voltar");
                                    int disciplineChoice = scanner.nextInt();
                                    switch (disciplineChoice) {
                                        case 1:
                                            curso.adicionarDisciplina(disciplina);
                                            System.out.println("Disciplina adicionada com sucesso.");
                                            break;
                                        case 2:
                                            curso.removerDisciplina(disciplina);
                                            System.out.println("Disciplina removida com sucesso.");
                                            break;
                                        case 3:
                                            System.out.println("Quantidade de alunos: " + disciplina.verificarQntdAlunos());
                                            break;
                                        case 4:
                                            disciplina.ativarDisciplina();
                                            System.out.println("Disciplina ativada com sucesso.");
                                            break;
                                        case 5:
                                            disciplina.desativarDisciplina();
                                            System.out.println("Disciplina desativada com sucesso.");
                                            break;
                                        case 0:
                                            break;
                                        default:
                                            System.out.println("Opção inválida.");
                                    }
                                    break;
                                case 0:
                                    break;
                                default:
                                    System.out.println("Opção inválida.");
                            }
                        } while (subChoice != 0);
                        break;
                    case 2: // Aluno
                    do {
                        System.out.println("1- Visualizar Disciplinas do Curso");
                        System.out.println("0- Voltar");
                        subChoice = scanner.nextInt();

                        switch (subChoice) {
                            case 1:
                                System.out.println("Visualizando Disciplinas.");
                                curso.getDisciplinas(); // Visualiza as disciplinas do curso
                                System.out.println("1- Gerenciar Disciplinas");
                                System.out.println("0- Voltar");
                                int manageChoice = scanner.nextInt();
                                switch (manageChoice) {
                                    case 1:
                                        System.out.println("1- Matricular em Disciplina");
                                        System.out.println("2- Visualizar Disciplinas Matriculadas");
                                        System.out.println("0- Voltar");
                                        int enrollChoice = scanner.nextInt();
                                        switch (enrollChoice) {
                                            case 1:
                                                turma.matricularAluno(aluno);
                                                System.out.println("Aluno matriculado com sucesso.");
                                                break;
                                            case 2:
                                                aluno.visualizarTurmas();
                                                System.out.println("1- Desmatricular em Disciplina");
                                                System.out.println("0- Voltar");
                                                int unenrollChoice = scanner.nextInt();
                                                switch (unenrollChoice) {
                                                    case 1:
                                                        turma.cancelarMatricula(aluno);
                                                        System.out.println("Desmatriculado com sucesso.");
                                                        break;
                                                    case 0:
                                                        break;
                                                    default:
                                                        System.out.println("Opção inválida.");
                                                }
                                                break;
                                            case 0:
                                                break;
                                            default:
                                                System.out.println("Opção inválida.");
                                        }
                                        break;
                                    case 0:
                                        break;
                                    default:
                                        System.out.println("Opção inválida.");
                                }
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Opção inválida.");
                        }
                    } while (subChoice != 0);
                    break;
                    case 3: // Professor
                        do {
                            System.out.println("1- Visualizar Alunos");
                            System.out.println("0- Voltar");
                            subChoice = scanner.nextInt();
    
                            switch (subChoice) {
                                case 1:
                                System.out.println("Visualizando Alunos.");
                                    professor.visualizarAlunos();
                                    break;
                                case 0:
                                    break;
                                default:
                                    System.out.println("Opção inválida.");
                            }
                        } while (subChoice != 0);
                        break;
                    case 0: // Sair do Sistema
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } while (mainChoice != 0);
    
            scanner.close();
        }


    

   
}
