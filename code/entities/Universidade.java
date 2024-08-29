package code.entities;

import java.io.Serializable;

import java.util.List;
import java.util.ArrayList;

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

    public void adicionarCurso(Curso curso) {
        this.cursos.add(curso);
    }

    public void gerarCurriculo() {
        // Lógica para gerar o currículo para cada semestre
    }

    // Getters e Setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String cNPJ) {
        CNPJ = cNPJ;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

}
