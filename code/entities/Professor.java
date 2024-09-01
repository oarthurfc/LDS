package code.entities;

import java.io.Serializable;

public class Professor implements Serializable {
   private String matricula;
    private String nome;
    private String CPF;

    public Professor(String matricula, String nome, String CPF) {
        this.matricula = matricula;
        this.nome = nome;
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

	public String getMatricula() {
		return matricula;
	}

    public String getCPF() {
        return CPF;
    }

}
