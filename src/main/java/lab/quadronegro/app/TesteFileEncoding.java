package lab.quadronegro.app;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;

public class TesteFileEncoding {
	private static final String ARQUIVO = "C:\\Users\\thiagocs\\Projetos\\lab\\çafé.txt";
	
	public static void main(String[] args) {
		
        File file = new File(ARQUIVO);
        
        try {
			String conteudo = FileUtils.readFileToString(file, "ISO8859-1");
			
			String teste = new String(conteudo.getBytes(), Charset.forName("UTF-8"));
			
			System.out.println(conteudo);
			System.out.println(teste);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
