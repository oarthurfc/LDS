package code;

import code.entities.Universidade;
import java.io.*;

public class Serializacao {
    
    public static void inserirUniversidade(Universidade universidade, String nomeArquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(universidade);
        }
    }

    public static Universidade carregarUniversidade(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            return (Universidade) ois.readObject();
        }
    }
}
