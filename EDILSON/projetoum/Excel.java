package projetoum;

import java.io.*;
import java.util.*;

public class Excel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

     
        System.out.println("Digite os nomes das colunas separados por vírgula:");
        String[] headers = scanner.nextLine().split(",");

      
        List<String[]> rows = new ArrayList<>();

     
        System.out.println("Digite os dados das linhas. Para terminar, digite 'fim'.");

        while (true) {
            System.out.println("Digite os dados da linha separado por virgula 'com a mesma quantidade de virgula' (ou 'fim' para encerrar):");
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("fim")) break;

            String[] values = line.split(",");
            if (values.length == headers.length) {
                rows.add(values);
            } else {
                System.out.println("Número de dados não corresponde ao número de colunas.");
            }
        }

     
        try (PrintWriter writer = new PrintWriter(new File("dados.csv"))) {
            
            writer.println(String.join(",", headers));
            
            for (String[] row : rows) {
                writer.println(String.join(",", row));
            }
            System.out.println("Arquivo CSV criado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao criar o arquivo CSV.");
            e.printStackTrace();
        }

        scanner.close();
    }
}
