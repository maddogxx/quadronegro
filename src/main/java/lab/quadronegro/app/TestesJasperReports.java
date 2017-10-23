package lab.quadronegro.app;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.ghost4j.document.DocumentException;
import org.ghost4j.renderer.RendererException;

import lab.quadronegro.util.GeradorRelatorio;
import net.sf.jasperreports.engine.JRException;

public class TestesJasperReports {
	
	private static final String CAMINHO_JASPER_DAM = "dam.jrxml";
	private static final String CAMINHO_JASPER_CARTA_CITACAO = "cartaCitacaoPostal.jrxml";
	private static final String CAMINHO_JASPER_PETICAO_TESTE = "relatorioPeticaoTeste.jrxml";
	private static final String ASSINATURA_PROCURADOR = "assinaturaProcurador.png";
	private static final String LOGO_TJPE = "tjpe.png";
	private static final String DAM_GIF_NOVO = "NovoDamGif.png"; //"NovoDamGif.gif";
	private static final String DAM_GIF_VELHO = "DAMgifAutmProd.gif";//"DAMgifAutmProd.png";
	
	private static final String NOME_ARQUIVO_PETICAO_GERADO = "/home/thiagocs/Documents/SFTM/CDAS/testePeticao";
	private static final String NOME_ARQUIVO_CARTA_CITACAO_GERADO = "/home/thiagocs/Documents/SFTM/CDAS/cartaCitacao";
	private static final String NOME_ARQUIVO_DAM_GERADO = "/home/thiagocs/Documents/SFTM/CDAS/dam";
	private static final String URL_DAM_NOVO = "http://sanchod.recife:9080/EMPREL_DAM/NovoDamJpg?MERCANTIL++++D.A+JUDICIAL+1927/05/17+++++++016.004-0FKJMBY+TSFSE+QBTBKTS+++++++++++++++++++++++++++++++++++2.08.001621.9+++++04/06++++5000002306.07-9TOT+ATE+27/05/17++**++**+++RS+++++4.022,99****************++**++**+++**********+********************++**++**+++**********+********************++**++**+++**********+**********************************************************************PRINCIP+++++1728,03++++JUROS+++++++1226,88++++CUSTAS+++++++216,17++++MULTA++++++++172,80+++++++++++++++++++++++++++HONORA+++++++679,11++++PRINCIP+++++1728,03+++++++JUROS+++++++1226,88+++++++CUSTAS+++++++216,17+++++++MULTA++++++++172,80+++++++++++++++++++++++++++++++++HONORA+++++++679,11+++++++CAIXA:+NAO+RECEBER+APOS+27/05/17+++REDUCAO:MULTA:50%+JUROS:50%+LEI+18181/15+++22/05/17+++++818900000400229935692011705270019508000023060794RUA+GENERAL+ABREU+E+LIMA+++++++++++++++++++00285+TAMARINEIRA++++++++++++++++++++++++++ANO(S):+2004+2005+2006++++++++++++++++++++++++++++++++++++++++ANO(S):+2004+2005+2006++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++";
//	private static final String URL_DAM_NOVO = "http://localhost:8080/EMPREL_DAM/NovoDamGif?IMOBILIARIA++ADM++++++++++0608/05/17+++++++4.56757-9ODPQNTAT+ANQJTQPD+JDNYOTQPA++++++++++++++++++++++++++++++++++++++++++++++2015+++++4080767215.14-9TOT+ATE+08/05/17++**++**+++RS+++++++958,29****************++**++**+++**********+********************++**++**+++**********+********************++**++**+++**********+**********************************************************************PRINCIP++++++793,76++++JUROS+++++++++85,25+++++++++++++++++++++++++++MULTA+++++++++79,28++++++++++++++++++++++++++++++++++++++++++++++++++PRINCIP++++++793,76+++++++JUROS+++++++++85,25+++++++++++++++++++++++++++++++++MULTA+++++++++79,28+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++CAIXA:+NAO+RECEBER+APOS+08/05/17+++REDUCAO:MULTA:50%+JUROS:50%+LEI+18181/15+++03/05/17+++++818600000099582935692017705080106400807672151497RUA+CAPITAO+ARAUJO+MIRANDA+++++++++++++++++00110++++++++++++0401+IPUTINGA+++++++++++++2015+PARC:+3+4+5+6+7+8+9+10++++++++++4.1470.096.02.0161.0013.92015+PARC:+3+4+5+6+7+8+9+10++++++++++++++++++++++++IPTU+++++++++534,81TLP++++++++++258,95JUROS+++++++++85,25MULTA+++++++++79,28++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++";
	private static final String URL_DAM_VELHO = "http://sanchod.recife:9080/EMPREL_DAM/DAMgifAutmProd?IMOBILIARIA+++++++++++++++0110/09/14+++++++4.00435-3JANIO+AZEVEDO+DE+SALES++++++++++++++++++++++++++++++++++++++++++++++++++++2014++++4072407214.12-0TOT+ATE+10/11/14++20+09++++RS+++++++392,42****************++**++**+++**********+********************++**++**+++**********+********************++**++**+++**********+**********************************************************************PRINCIP++++++366,69++++MULTA+++++++++16,57+++++++++++++++++++++++++++TSD++++++++++++4,02++++JUROS++++++++++5,14+++++++++++++++++++++++++++PRINCIP++++++366,69+++++++MULTA+++++++++16,57+++++++++++++++++++++++++++++++++TSD++++++++++++4,02+++++++JUROS++++++++++5,14+++++++++++++++++++++++++++++++++CAIXA:+NAO+RECEBER+APOS+10/11/14+++PAGUE+NO+PRIMEIRO+VENCIMENTO.++++++++++++++07/11/14+++++818500000038924235692012411100101403724072141206RUA+DES+OSCAR+COUTINHO+++++++++++++++++++++00176+++++++++++++++++++IPUTINGA+++++++++++2014+PARC:+1+2+3+4+5+6+8+9+10++++++++4.1395.060.01.0284.0000.0REDUCAO+70%MULTA,+70%JUROS+-LEI+17373/07+++++++++++";
	

	public static void main(String[] args) {
		gerarImagemCartaCitacao();
//		gerarDamNovo();
//		gerarImagemPeticaoTeste();
//		baixarDamNovo();
	}
	
	private static void gerarImagemCartaCitacao() {
		GeradorRelatorio gerador = new GeradorRelatorio(CAMINHO_JASPER_CARTA_CITACAO, NOME_ARQUIVO_CARTA_CITACAO_GERADO);
		
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("NOME_EXECUTADO", "CHARQUEADA DO NORDESTE LTDA");
		parametros.put("NUMERO_PROCESSO", "0027139-65.2015.8.17.2001");
		parametros.put("ENDERECO", "AV JARDIM BRASILIA 275 INDUSTRIA 0000 PEIXINHOS");
		parametros.put("DATA_EXTENSO", "27 de Junho de 2016");
		parametros.put("DATA_DEBITO_ATUALIZADO", "27/06/16");
		parametros.put("VALOR_ATUALIZADO", "R$ 4.407,40");
		parametros.put("NOME_AGENTE", "CARLA CIBELE AMARAL CORDEIRO");
		parametros.put("ASSINATURA_AGENTE", obterRecurso(ASSINATURA_PROCURADOR));
		parametros.put("LOGO_TJPE", obterRecurso(LOGO_TJPE));
		
		try {
			parametros.put("IMAGEM_DAM", obterImagemDam(URL_DAM_NOVO));
//			parametros.put("IMAGEM_DAM", obterRecurso(DAM_GIF_NOVO));
//			parametros.put("IMAGEM_DAM", obterRecurso(DAM_GIF_VELHO));
			
//			gerador.executarParaImagem(parametros);
			gerador.executarParaImagem(parametros);
			
			System.out.println("FIIIIIM");
		} catch (JRException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RendererException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	private static void gerarImagemPeticaoTeste() {
		GeradorRelatorio gerador = new GeradorRelatorio(CAMINHO_JASPER_PETICAO_TESTE, NOME_ARQUIVO_PETICAO_GERADO);
		
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("nome", "CLAUDIO BEZERRA BANDEIRA DE MELO");
		parametros.put("enderecoAlternativo", "PRC DO ENTRONCAMENTO, 132, GRACAS, RECIFE, PE, 52011-300");
		parametros.put("numeroInscricao", "113.094-3");
		parametros.put("numeroCda", "1.01.503393-5");
		parametros.put("somaTotal", BigDecimal.ZERO);
		parametros.put("dataExtenso", "16 de Janeiro de 2009");
		
		parametros.put("nomeProcurador", "GUSTAVO SANTOS BARBOSA");
		parametros.put("oabProcurador", "PE 22008");
		parametros.put("matriculaProcurador", "66.274-2");
		
		parametros.put("SERIE_PETICAO", "IPTU/Taxas imobiliárias");
		parametros.put("ABREVIATURA_MOEDA", "R$");
		
		try {
			InputStream assinaturaStream = TestesJasperReports.class.getClassLoader().getResourceAsStream(ASSINATURA_PROCURADOR);
			parametros.put("IMAGEM_ASS2", assinaturaStream);//IOUtils.toByteArray(assinaturaStream));
			gerador.executarParaImagem(parametros);
			
			System.out.println("FIIIIIM");
		} catch (JRException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RendererException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	private static void gerarDamNovo() {
		GeradorRelatorio gerador = new GeradorRelatorio(CAMINHO_JASPER_DAM, NOME_ARQUIVO_DAM_GERADO);
		
		Map<String, Object> parametros = new HashMap<>();
		
		try {
//			parametros.put("imagemDam", obterImagemDam(URL_DAM_VELHO));
//			parametros.put("imagemDam", obterRecurso(DAM_GIF_VELHO));
			parametros.put("imagemDam", obterImagemDam(URL_DAM_NOVO));
			
			gerador.executarParaImagem(parametros);
//			gerador.executarParaPDF(parametros);
			
			System.out.println("FIIIIIM");
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		} catch (RendererException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} 
	}
	
	private static void baixarDamNovo() {
		OutputStream outputStream = null;
		InputStream damStream = null;
		
		try {
			damStream = obterImagemDam(URL_DAM_NOVO);
			
			outputStream = new FileOutputStream(new File("/home/thiagocs/Documents/SFTM/CDAS/dam.jpg"));

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = damStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (damStream != null) {
				try {
					damStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private static InputStream obterRecurso(String recurso) {
		InputStream recursoStream = TestesJasperReports.class.getClassLoader().getResourceAsStream(recurso);
		
		return recursoStream;
	}
	
	private static InputStream obterImagemDam(String linkImagemDAM) throws MalformedURLException, IOException {
		InputStream imagemDAM = (new URL(linkImagemDAM)).openStream();
		
		return imagemDAM;
	}

}
