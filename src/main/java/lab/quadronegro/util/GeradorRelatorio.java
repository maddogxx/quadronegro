package lab.quadronegro.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFImageWriter;
import org.ghost4j.document.DocumentException;
import org.ghost4j.document.PDFDocument;
import org.ghost4j.renderer.RendererException;
import org.ghost4j.renderer.SimpleRenderer;

import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;

public class GeradorRelatorio {
	
	private enum SaidaEnum {PDF, JPEG}
	
	private String caminhoJasper;

	private String nomeArquivo;

	public GeradorRelatorio(String caminhoJasper, String nomeArquivo) {
		this.caminhoJasper = caminhoJasper;
		this.nomeArquivo = nomeArquivo;
	}
	
	public void executarParaPDF(Map<String, Object> parametros) throws JRException, IOException, RendererException, DocumentException {
		executar(parametros, SaidaEnum.PDF);		
	}
	
	public void executarParaImagem(Map<String, Object> parametros) throws JRException, IOException, RendererException, DocumentException {
		executar(parametros, SaidaEnum.JPEG);
	}

	private void executar(Map<String, Object> parametros, SaidaEnum saida) throws JRException, IOException, RendererException, DocumentException {
		InputStream reportStream = getClass().getClassLoader().getResourceAsStream(caminhoJasper);
		
		JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

		JREmptyDataSource jrds = new JREmptyDataSource();
		
		if (SaidaEnum.PDF.equals(saida)) {
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, jrds);
			JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo + ".pdf");

		} else if (SaidaEnum.JPEG.equals(saida)) {
			byte[] relatorioGerado = JasperRunManager.runReportToPdf(jasperReport, parametros, jrds);
			InputStream relatorioGeradoStream = new ByteArrayInputStream(relatorioGerado);
			
			PDFDocument documento = new PDFDocument();
			documento.load(relatorioGeradoStream);
			
			SimpleRenderer renderer = new SimpleRenderer();
			renderer.setResolution(500);
			
			List<Image> images = renderer.render(documento);
			
			RenderedImage imagemRenderizada = (RenderedImage) images.iterator().next();
			
			File arquivo = new File(nomeArquivo + ".jpg");
			OutputStream outputStream = new FileOutputStream(arquivo);
			
			ImageIO.write(imagemRenderizada, "jpg", outputStream);
		}
	}
}