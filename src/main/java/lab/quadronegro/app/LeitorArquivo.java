/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.quadronegro.app;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author thiagocs
 */
public class LeitorArquivo {
    
    private static final String ARQUIVO_CSV = "C:\\Users\\thiagocs\\Projetos\\lab\\InventSkill.txt";
    
    public static void main(String[] args) {
        lerArquivoCSV(ARQUIVO_CSV);
    }
    
    private static void lerArquivoCSV(String arquivoCSV) {
        StringBuilder resultado = new StringBuilder();

        File file = new File(arquivoCSV);

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                if (!linha.trim().isEmpty()) {
                    String[] vetor = linha.split(";");
                    
                    Boolean primeiro = Boolean.TRUE;
                    for (String valor : vetor) {
                        if (primeiro) {
                            resultado.append(valor.trim());
                            primeiro = Boolean.FALSE;
                        } else {
                            resultado.append(";" + valor.trim());
                        }
                    }
                    
                    resultado.append("\n");
                }

            }

            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(resultado.toString());
    }
}