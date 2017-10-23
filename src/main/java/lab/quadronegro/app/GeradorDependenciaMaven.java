package lab.quadronegro.app;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class GeradorDependenciaMaven {
    private static final String ARQUIVO_CSV = "C:\\Users\\thiagocs\\Projetos\\lab\\dependenciasMaven.txt";
    
    public static void main(String[] args) {
        lerArquivoCSV(ARQUIVO_CSV);
//    	System.out.println(obterDependenciaMaven("commons-logging", "commons-logging-1.1.1.jar", "1.1.1"));
//    	System.out.println(obterComandoMaven("commons-logging", "commons-logging-1.1.1.jar", "1.1.1"));
    }
    
    private static void lerArquivoCSV(String arquivoCSV) {
        StringBuilder dependenciaExcluida = new StringBuilder();
        StringBuilder dependenciaMaven = new StringBuilder();
        StringBuilder comandoInstalacaodependenciaMaven = new StringBuilder();

        File file = new File(arquivoCSV);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                if (linha.trim().isEmpty() || linha.contains("--")) {
                	dependenciaExcluida.append("EXCLUIDO: " + linha.trim() + "\n");
                	
                } else {
                	String[] vetor = linha.split(";");
                	
                	if (vetor.length > 2) {
                		dependenciaMaven.append(obterDependenciaMaven(vetor[0], vetor[1], vetor[2]) + "\n\n");
                		comandoInstalacaodependenciaMaven.append(obterComandoMaven(vetor[0], vetor[1], vetor[2]) + "\n");
                		
                	} else {
                		dependenciaMaven.append(obterDependenciaMaven(vetor[0], vetor[1], "1.0") + "\n\n");
                		comandoInstalacaodependenciaMaven.append(obterComandoMaven(vetor[0], vetor[1], "1.0") + "\n");
                	}
                }
            }

            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(dependenciaExcluida.toString());
        System.out.println("\n-----------------------------------------------------------------------------------\n");
        System.out.println(dependenciaMaven.toString());
        System.out.println("\n-----------------------------------------------------------------------------------\n");
        System.out.println(comandoInstalacaodependenciaMaven.toString());
    }
    
    private static String obterDependenciaMaven(String artefatoId, String nomeLib, String versao) {
    	StringBuilder resultado = new StringBuilder();
    	resultado.append("<dependency>\n\t")
    			.append("<groupId>br.gov.emprel</groupId>\n\t")
    			.append("<artifactId>#artefato#</artifactId>\n\t")
    			.append("<version>#versao#</version>\n\t")
    			.append("<scope>system</scope>\n\t")
    			.append("<systemPath>${basedir}/WebContent/WEB-INF/lib/#nomeLib#</systemPath>\n")
    			.append("</dependency>");
    	
    	return resultado.toString().replace("#artefato#", artefatoId).replace("#versao#", versao).replace("#nomeLib#", nomeLib);
    }
    
    private static String obterComandoMaven(String artefatoId, String nomeLib, String versao) {
    	StringBuilder resultado = new StringBuilder();
    	resultado.append("call mvn install:install-file ")
    			.append("-Dfile=./WebContent/WEB-INF/lib/#nomeLib# ")
    			.append("-DgroupId=br.gov.emprel ")
    			.append("-DartifactId=#artefato# ")
    			.append("-Dversion=#versao# ")
    			.append("-Dpackaging=jar");
    	
    	return resultado.toString().replace("#artefato#", artefatoId).replace("#versao#", versao).replace("#nomeLib#", nomeLib); 
    }
}
