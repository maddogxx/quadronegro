package lab.quadronegro.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExtrairAbasExcel {
	private static final String DIRETORIO = "/home/thiagocs/Documents/Santista/";
	private static final String ARQUIVO_ENTRADA = DIRETORIO + "PICANHAS.xlsx";

	public static void main(String[] args) {
		Map<String, Integer> mapa = obterMapa();
		
		try {
			Integer removerAnteriores = 0;
			for (String chave : mapa.keySet()) {
				System.out.println("PROCESSANDO " + chave);
				
				// Ler planilha
				FileInputStream arquivo = new FileInputStream(new File(ARQUIVO_ENTRADA));
				XSSFWorkbook workbook = new XSSFWorkbook(arquivo);
				
				System.out.println("removerAnteriores = " + removerAnteriores);
				
				for (int i = 0; i < removerAnteriores; i++) {
					System.out.println("Removendo Anterior planilha: " + workbook.getSheetAt(0).getSheetName());
					workbook.removeSheetAt(0);
				}
				
				Integer indice = mapa.get(chave) + 1;
				while (workbook.getNumberOfSheets() > indice) {
					System.out.println(indice + " - total = " + workbook.getNumberOfSheets());
					
					workbook.removeSheetAt(indice);
				}
				
				String nomeArquivo = DIRETORIO + "Gerados/" + chave + ".xlsx";
				
				gravarArquivo(workbook, nomeArquivo);
				
				removerAnteriores += indice;
			}
			
			System.out.println("FIIIIM");
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	

	private static void gravarArquivo(XSSFWorkbook workbook, String nomeArquivo) {
		try {
			FileOutputStream outputStream = new FileOutputStream(nomeArquivo);
			workbook.write(outputStream);
			workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static Map<String, Integer> obterMapa() {
		Map<String, Integer> mapa = new LinkedHashMap<>();
		
		List<String> lista = new ArrayList<>();

		lista.add("PICANHA COCARSA 2958 2013");
		lista.add("PICANHA COCARSA 2958 2014");
		lista.add("PICANHA COCARSA 2959");
		lista.add("PICANHA COCARSA 2960");
		lista.add("PICANHA COCARSA 2963");
		lista.add("PICANHA SEARA ANGUS");
		lista.add("PICANHA PATAGONIA FB 2013");
		lista.add("PICANHA PATAGONIA FB 2014");
		lista.add("PICANHA PATAGONIA A 2013");
		lista.add("PICANHA PATAGONIA A 2014");
		lista.add("PICANHA AMANCAY B 2013");
		lista.add("PICANHA AMANCAY B 2014");
		lista.add("PICANHA AMANCAY A 2013");
		lista.add("PICANHA COTO CIUDAD 2013");
		lista.add("PICANHA COTO CIUDAD 2014");
		lista.add("PICANHA CIRIBE 2013");
		lista.add("PICANHA CIRIBE 2014");
		lista.add("PICANHA ARREBEEF A 2013");
		lista.add("PICANHA ARREBEEF A 2014");
		lista.add("PICANHA O CONNERS 2013");
		lista.add("PICANHA O CONNERS 2014");
		lista.add("PICANHA FINEXCOR 2013");
		lista.add("PICANHA FINEXCOR 2014");
		lista.add("PICANHA FINEXCOR A 2013");
		lista.add("PICANHA FINEXCOR A 2014");
		lista.add("PICANHA FRIAR 2013");
		lista.add("PICANHA GORINA B 2013");
		lista.add("PICANHA GORINA B 2014");
		lista.add("PICANHA GORINA 0865 2013");
		lista.add("PICANHA GORINA 0865 2014");
		lista.add("PICANHA GORINA 2830 2013");
		lista.add("PICANHA GORINA 2830 2014");
		lista.add("PICANHA GORINA 2901 2013");
		lista.add("PICANHA GORINA 2901 2014");
		lista.add("PICANHA JBS LA BLANCA 2013");
		lista.add("PICANHA JBS LA BLANCA 2014");
		lista.add("PICANHA JBS SWIFT 2013");
		lista.add("PICANHA JBS SWIFT 2014");
		lista.add("PICANHA LA GANADEIRA 2013");
		lista.add("PICANHA LA GANADEIRA 2014");
		lista.add("PICANHA TEYS B 2013");
		lista.add("PICANHA TEYS B 2014");
		lista.add("PICANHA TEYS A 2013");
		lista.add("PICANHA TEYS A 2014");
		lista.add("PICANHA QUICK FOOD 2013");
		lista.add("PICANHA QUICK FOOD 2014");
		lista.add("PICANHA QUICK FOOD A 2013");
		lista.add("PICANHA BOV QUICK FOOD 2013");
		lista.add("PICANHA BOV QUICK FOOD 2014");
		lista.add("PICANHA QUICK FOOD A 2014");
		lista.add("PICANHA SUPER QUICK FOOD 2013");
		lista.add("PICANHA SUPER QUICK FOOD 2014");
		lista.add("PICANHA RAFAELA 2013");
		lista.add("PICANHA RAFAELA 2014");
		lista.add("PICANHA LORSINAL 2013");
		lista.add("PICANHA LORSINAL 2014");
		lista.add("PICANHA MARFRIG 071661");
		lista.add("PICANHA COTO A 2013");
		lista.add("PICANHA COTO A 2014");
		lista.add("PICANHA COTO B 2013");
		lista.add("PICANHA COTO B 2014");
		lista.add("PICANHA COTO 2014");
		lista.add("PICANHA COTO 55 2014");
		lista.add("PICANHA CATTER MEAT CPC A 2013");
		lista.add("PICANHA CATTER MEAT CPC A 2014");
		lista.add("PICANHA CATTER MEAT CPC 2013");
		lista.add("PICANHA CATTER MEAT CPC 2014");
		lista.add("PICANHA RIO PLATENSE");
		lista.add("Planilha3");
		
		for (String valor : lista) {
			String valorEditado = valor.replaceAll(" 2013", "").replaceAll(" 2014", "");
			
			if (mapa.containsKey(valorEditado)) {
				Integer contador = mapa.get(valorEditado);
				contador++;
				mapa.put(valorEditado, contador);
			} else {
				mapa.put(valorEditado, 0);
			}
		}
		
		for (String chave : mapa.keySet()) {
			System.out.println(chave + " = " + mapa.get(chave));
		}
		
		return mapa;
	}
	
}
