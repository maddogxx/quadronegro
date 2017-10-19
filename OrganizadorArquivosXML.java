package lab.quadronegro.app;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class OrganizadorArquivosXML {
	private enum ANO {
		A2013,
		A2014;
	}
	
	private static final String DIRETORIO = "/home/thiagocs/Documents/Santista/notas/Amostra/";

	public static void main(String[] args) {
		File[] arquivos = new File(DIRETORIO).listFiles();
		
		for (File arquivo : arquivos) {
			try {
				processarArquivo(arquivo);
			} catch (XPathExpressionException | ParserConfigurationException | SAXException | IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void processarArquivo(File arquivo) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(arquivo.getPath());
		NodeList elementos = doc.getElementsByTagName("det");
		
		for (int i = 0; i < elementos.getLength(); i++) {
			Node elemento = elementos.item(i);
			
			Node produto = elemento.getFirstChild();
			NodeList elementosProduto = produto.getChildNodes();
			
			Node nomeProduto = elementosProduto.item(2).getFirstChild();
			
			
			
			System.out.println(converterNomeProduto(nomeProduto.getNodeValue()));
		}
		
		//FileUtils.copyFileToDirectory(srcFile, destDir);
	}
	
	private static String converterNomeProduto(String nomeProduto) {
		String nomeAlterado = nomeProduto;
		
		nomeAlterado += nomeAlterado.replaceAll(" ", "_").replaceAll("\"", "");
		
		return nomeProduto;
	}
	
	private static void gravarArquivo() {}
	


}
