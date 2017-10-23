package lab.quadronegro.app;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class LeitorArquivoCSV {
    
    private static String ARQUIVO_ENTRADA_CSV;
    private static String ARQUIVO_SAIDA;
    
    public static void main(String[] args) {
    	if (args.length == 2) {
    		ARQUIVO_ENTRADA_CSV = args[0];
    		ARQUIVO_SAIDA = args[1];
    	}
    	
        lerArquivoCSV();
    }
    
    private static void lerArquivoCSV() {
    	CSVParser parser = null;
    	StringBuilder scriptGeral = new StringBuilder();
    	
		try {
			Reader in = new FileReader(ARQUIVO_ENTRADA_CSV);
			
			parser = new CSVParser(in, CSVFormat.newFormat(';').withHeader());
			
			for (CSVRecord record : parser) {
				String dataArquivo = record.get("DATA");
				
				if (!dataArquivo.trim().isEmpty() && dataArquivo.trim().length() == 10) {
					StringBuilder sqlAcordo = new StringBuilder();
					sqlAcordo.append("INSERT INTO caju.tbacordo ");
					sqlAcordo.append("(aacordcodigo, ");
					sqlAcordo.append("tacordulat, ");
					sqlAcordo.append("dacorddatarealizacao, ");
					sqlAcordo.append("facordinterno, ");
					sqlAcordo.append("eacordprocessojudical, ");
					sqlAcordo.append("aadvogcpf, ");
					sqlAcordo.append("afacilcpf, ");
					sqlAcordo.append("asitacsequencial, ");
					sqlAcordo.append("atpacosequencial) ");
					sqlAcordo.append("VALUES (nextval('caju.sqacordo'), ");
					sqlAcordo.append("CURRENT_TIMESTAMP, ");
					
					sqlAcordo.append("'").append(dataArquivo).append("', ");
					
					String acordoInternoArquivo = record.get("INTERNO");
					
					if (acordoInternoArquivo.equalsIgnoreCase("NÃO")) {
						sqlAcordo.append("'N', ");
					} else if (acordoInternoArquivo.equalsIgnoreCase("SIM")) {
						sqlAcordo.append("'S', ");
					}
					
					String processoArquivo = record.get("Nº PROC");
					
					if (processoArquivo.trim().isEmpty()) {
						sqlAcordo.append("null, ");
					} else {
						String processoFormatado = processoArquivo.replaceAll("[.-]", "");
						
						sqlAcordo.append("'").append(processoFormatado).append("', ");
					}
					
					// Advogado
					sqlAcordo.append("06471976429").append(", ");
					
					// Facilitador
					sqlAcordo.append("08740736423").append(", ");
					
					sqlAcordo.append("(SELECT asitacsequencial FROM caju.tbsituacaoacordo WHERE nsitacnome = '").append(record.get("SITUAÇÃO").trim()).append("'), ");
					
					sqlAcordo.append("(SELECT atpacosequencial FROM caju.tbtipoacordo WHERE ntpaconome = '").append(record.get("TIPO").trim()).append("')); ");
					
					// System.out.println(sqlAcordo);
					scriptGeral.append(sqlAcordo).append("\n");
					
					StringBuilder sqlParteAcordo = new StringBuilder();
					sqlParteAcordo.append("INSERT INTO caju.tbacordoparte ");
					sqlParteAcordo.append("(aacparsequencial, tacparulat, nacparnome, aacordcodigo) ");
					sqlParteAcordo.append("(aacparsequencial, tacparulat, nacparnome, aacordcodigo) ");
					sqlParteAcordo.append("VALUES (nextval('caju.sqacordoparte'), ");
					sqlParteAcordo.append("CURRENT_TIMESTAMP, ");
					sqlParteAcordo.append("'#', ");
					sqlParteAcordo.append("currval('caju.sqacordo'));");
					
					// System.out.println(sqlParteAcordo.toString().replaceAll("#", record.get("AUTOR/PARTE").trim()));
					scriptGeral.append(sqlParteAcordo.toString().replaceAll("#", record.get("AUTOR/PARTE").trim())).append("\n");
					
					String represetanteParteArquivo = record.get("REPRESENTANTE/PARTE").trim();
					
					if (!represetanteParteArquivo.equalsIgnoreCase("N/T")) {
						// System.out.println(sqlParteAcordo.toString().replaceAll("#", represetanteParteArquivo));
						scriptGeral.append(sqlParteAcordo.toString().replaceAll("#", represetanteParteArquivo)).append("\n");
					}
					
					String reuParteArquivo = record.get("REU/PARTE").trim();
					
					if (!reuParteArquivo.equalsIgnoreCase("N/T")) {
						// System.out.println(sqlParteAcordo.toString().replaceAll("#", reuParteArquivo));
						scriptGeral.append(sqlParteAcordo.toString().replaceAll("#", reuParteArquivo)).append("\n");
					}
				} // Fim - if (!dataArquivo.trim().isEmpty() && dataArquivo.trim().length() == 10)
			} // Fim - for (CSVRecord record : parser)
			
			PrintWriter writer = new PrintWriter(ARQUIVO_SAIDA, "UTF-8");
			writer.println(scriptGeral);
			writer.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (parser != null && !parser.isClosed()) {
				try {
					parser.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
    }
}
