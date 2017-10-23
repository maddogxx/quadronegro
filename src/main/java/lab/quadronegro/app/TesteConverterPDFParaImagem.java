package lab.quadronegro.app;

import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.ghost4j.document.DocumentException;
import org.ghost4j.document.PDFDocument;
import org.ghost4j.renderer.RendererException;
import org.ghost4j.renderer.SimpleRenderer;

public class TesteConverterPDFParaImagem {
	
	private static final String DIRETORIO_RECUROS = "/home/thiagocs/Documents/SFTM/CDAS/";
	private static final String CARTA_CITACAO = DIRETORIO_RECUROS + "cartaCitacao.pdf";
	private static final String CARTA_CITACAO_SAIDA = DIRETORIO_RECUROS + "cartaCitacao_#.jpg";
	
	public static void main(String[] args) {

        PDFDocument document = new PDFDocument();
        
        try {
			document.load(new File(CARTA_CITACAO));
			
	         // create renderer
	         SimpleRenderer renderer = new SimpleRenderer();
	 
	         // set resolution (in DPI)
	         renderer.setResolution(500);
	         
	         List<Image> images = renderer.render(document);
	         
             for (int i = 0; i < images.size(); i++) {
                 ImageIO.write((RenderedImage) images.get(i), "jpg", new File(CARTA_CITACAO_SAIDA.replace("#", String.valueOf(i + 1))));
             }
             
             System.out.println("FIIIIIIIIIIIIIM");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RendererException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

}
