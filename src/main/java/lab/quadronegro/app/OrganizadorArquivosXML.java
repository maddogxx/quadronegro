package lab.quadronegro.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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
		
		Node noDataEmissao = doc.getElementsByTagName("dEmi").item(0);
		String dataEmissao = noDataEmissao.getFirstChild().getNodeValue();
		dataEmissao = dataEmissao.substring(0, 4);
		
		for (int i = 0; i < elementos.getLength(); i++) {
			Node elemento = elementos.item(i);
			
			Node produto = elemento.getFirstChild();
			NodeList elementosProduto = produto.getChildNodes();
			
			Node nomeProduto = elementosProduto.item(2).getFirstChild();
			
			String nomeProdutoConvertido = converterNomeProduto(nomeProduto.getNodeValue());
			
			new File(DIRETORIO + nomeProdutoConvertido + File.pathSeparator + dataEmissao).mkdirs(); 
		}
		
		//FileUtils.copyFileToDirectory(srcFile, destDir);
	}
	
	private static String converterNomeProduto(String nomeProduto) {
		String nomeProdutoAlterado = nomeProduto;
		
		nomeProdutoAlterado = nomeProdutoAlterado.replaceAll(" ", "_").replaceAll("\"", "").replaceAll("\\.", "");
		
		return nomeProdutoAlterado;
	}
	
	private static void gravarArquivo(File origem, File destino) throws IOException {
	    InputStream is = null;
	    OutputStream os = null;
	    try {
	        is = new FileInputStream(origem);
	        os = new FileOutputStream(destino);
	        byte[] buffer = new byte[1024];
	        int length;
	        while ((length = is.read(buffer)) > 0) {
	            os.write(buffer, 0, length);
	        }
	    } finally {
	        is.close();
	        os.close();
	    }
	}
}