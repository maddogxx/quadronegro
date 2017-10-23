/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.quadronegro.app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thiagocs
 */
public class DiffProperties {

    private static final String ARQUIVO_COMUM = "C:\\Users\\thiagocs\\Projetos\\lab\\Compare\\msgPMATCOMUN.properties";
    private static final String ARQUIVO_CN = "C:\\Users\\thiagocs\\Projetos\\lab\\Compare\\msgPMATCN.properties";

    public static void main(String[] args) {
        Properties propriedadesComum = obterPropriedade(ARQUIVO_COMUM);
        Properties propriedadesCN = obterPropriedade(ARQUIVO_CN);

        for (Object chave : propriedadesCN.keySet()) {
            String mensagemDiferente = "";
            String mensagemIgual = "";
            String mensagemExclusivoCN = "";
            
            if (propriedadesComum.containsKey(chave)) {
                if (propriedadesComum.containsValue(propriedadesCN.getProperty(chave.toString()))) {
                    mensagemIgual += chave.toString() + " - IGUAL";
                } else {
                    mensagemDiferente += chave.toString() + " - DIFERENTE";
                    mensagemDiferente += "\n\tCOMUM=" + propriedadesComum.getProperty(chave.toString()) + "\n\tCN=" + propriedadesCN.getProperty(chave.toString());
                }
            } else {
                mensagemExclusivoCN += chave.toString() + " - EXCLUSIVO CN";
            }
            
            if (!mensagemIgual.isEmpty()) {
                System.out.println(mensagemIgual);
            }
            
//            if (!mensagemExclusivoCN.isEmpty()) {
//                System.out.println(mensagemExclusivoCN);
//            }

//            if (!mensagemDiferente.isEmpty()) {
//                System.out.println(mensagemDiferente);
//            }            
        }
    }
    
    private static final Properties obterPropriedade(String caminhoArquivo) {
        Properties propriedades = new Properties();
        
        try {
            FileInputStream input = new FileInputStream(caminhoArquivo);
            
            propriedades.load(input);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DiffProperties.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DiffProperties.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return propriedades;
    }
}
