/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.quadronegro.app;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author thiagocs
 */
public class RemoveDuplicate {
    private static final String[] ARQUIVOS = {
        "C:\\Users\\thiagocs\\Projetos\\mutirao\\massaEstimativa_comPPI.txt", 
        "C:\\Users\\thiagocs\\Projetos\\mutirao\\massaIPTU_comPPI.txt"};

    public static void main(String[] args) {
        for (String arquivo : ARQUIVOS) {
            exibirArquivo(arquivo);
        }
    }
    
    private static void exibirArquivo(String caminhoArquivo) {
        File file = new File(caminhoArquivo);
        
        Set<String> conjunto = new LinkedHashSet<>();
        List<String> lista = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();

                if (!linha.trim().isEmpty()) {
                    conjunto.add(linha);
                    lista.add(linha);
                }
            }

            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println(lista.size() + " :: " + conjunto.size() + "\n\n\n\n");
        
        for (String valor : conjunto) {
            System.out.println(valor);
        }
    }
}