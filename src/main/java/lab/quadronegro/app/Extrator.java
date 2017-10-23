/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.quadronegro.app;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author thiagocs
 */
public class Extrator {

    private static final String ARQUIVO_FASE1 = "C:\\Users\\thiagocs\\Projetos\\lab\\InventSkill.txt";
    private static final String ARQUIVO_FASE2 = "C:\\Users\\thiagocs\\Projetos\\lab\\InventSkill.txt";
    private static final Integer OPCAO = 2;

    public static void main(String[] args) {
        if (OPCAO == 1) {
            fase1();
        } else {
            fase2();
        }
    }

    private static void fase1() {
        Map<Integer, String> resultado = new LinkedHashMap<>();

        File file = new File(ARQUIVO_FASE1);

        try (Scanner scanner = new Scanner(file)) {
            Integer contador = 1;

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();

                if (!linha.trim().isEmpty()) {
                    if (linha.contains(contador + ".")) {
                        resultado.put(contador, linha.trim());
                    } else {
                        resultado.put(contador, resultado.get(contador) + linha.trim());
                    }

                    if (linha.substring(linha.length() - 1, linha.length()).equals(".")) {
                        contador++;
                    }
                }

            }

            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Integer chave : resultado.keySet()) {
            System.out.println(resultado.get(chave));
        }
    }
    
    private static void fase2() {
        StringBuilder resultado = new StringBuilder();

        File file = new File(ARQUIVO_FASE2);

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
