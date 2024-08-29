package code;

import java.io.IOException;
import code.entities.Universidade;
import code.entities.Aluno;
import code.entities.Curso;
import code.entities.Disciplina;
import code.entities.Professor;

public class App {

    public static final String caminhoDoArquivo = "./code/file/universidade.dat";

    public static void main(String[] args) throws IOException, ClassNotFoundException  {

        criarEntidades();

        // Carrega universidade do arquivo e imprime seus cursos
        Universidade universidadeCarregada = Serializacao.carregarUniversidade(caminhoDoArquivo);

        // Exibindo os cursos
        escreverLinha();
            System.out.println("        CURRÍCULO DA " + universidadeCarregada.getNome());
        escreverLinha();
        System.out.println("               C U R S O S              ");
        escreverLinha();
        for (Curso curso : universidadeCarregada.getCursos()) {
            System.out.println("- " + curso.getNome() + "\n" + "    |-> Créditos: " + curso.getNumCreditos());
            System.out.println("    |-> Disciplinas");
            curso.getDisciplinas().forEach(disciplina -> System.out.println("       |-> " + disciplina.getNome()));
        }
    }

    private static void criarEntidades() throws IOException {
        Universidade universidade = new Universidade("UNI ESQUINA", "Pça da Liberdade", "12222222");

        // Criar cursos
        Curso engenhariaDeSoftware = new Curso("Engenharia de Software", 180);
        Curso medicina = new Curso("Medicina", 160);

        // Criar disciplinas
        Disciplina calculo1 = new Disciplina("Cálculo 1", engenhariaDeSoftware);
        Disciplina anatomia = new Disciplina("Anatomia", medicina);
        
        // Criar alunos
        Aluno  aluno1 = new Aluno("1", "Aluno 1", "111");
        Aluno  aluno2 = new Aluno("2", "Aluno 2", "222");
        Aluno  aluno3 = new Aluno("3", "Aluno 3", "333");

        // Criar professor
        Professor professor1 = new Professor("157", "Agnaldo", "2345678");
        
        universidade.adicionarCurso(engenhariaDeSoftware);
        universidade.adicionarCurso(medicina);

        engenhariaDeSoftware.adicionarDisciplina(calculo1);
        medicina.adicionarDisciplina(anatomia);

        // Serializa universidade
        Serializacao.inserirUniversidade(universidade, caminhoDoArquivo);
    }

    public static void escreverLinha() {
        System.out.println("----------------------------------------");
    }
}
