package lab.quadronegro.util;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public final class Util {

	public static String calcularDiferencaDatas(Date d1, Date d2) {
		String resultado = "";
		
		long diferencaEmMilisegundos = d2.getTime() - d1.getTime();
		List<TimeUnit> unidades = new ArrayList<TimeUnit>(EnumSet.allOf(TimeUnit.class));
		Collections.reverse(unidades);
		Map<TimeUnit, String> mapaTempo = new LinkedHashMap<TimeUnit, String>();
		long milisegundosRestantes = diferencaEmMilisegundos;
		for (TimeUnit unidade : unidades) {
			long diferenca = unidade.convert(milisegundosRestantes, TimeUnit.MILLISECONDS);
			long diferencaEmMilisegundosPorUnidade = unidade.toMillis(diferenca);
			milisegundosRestantes = milisegundosRestantes - diferencaEmMilisegundosPorUnidade;
			
			String diferencaString = String.valueOf(diferenca);
			if (diferenca < 10) {
				diferencaString = "0" + diferencaString;
			}
			
			mapaTempo.put(unidade, diferencaString);
		}
		
		if (!"00".equals(mapaTempo.get(TimeUnit.DAYS))) {
			resultado += mapaTempo.get(TimeUnit.DAYS) + " dia(s) ";
		}
		
		if (!"00".equals(mapaTempo.get(TimeUnit.HOURS))) {
			resultado += mapaTempo.get(TimeUnit.HOURS) + "h";
		}
		
		if (!"00".equals(mapaTempo.get(TimeUnit.MINUTES))) {
			resultado += mapaTempo.get(TimeUnit.MINUTES) + "min";
		}
		
		if (!"00".equals(mapaTempo.get(TimeUnit.SECONDS))) {
			resultado += mapaTempo.get(TimeUnit.SECONDS) + "s";
		}
		
		if (!"00".equals(mapaTempo.get(TimeUnit.MILLISECONDS))) {
			resultado += mapaTempo.get(TimeUnit.MILLISECONDS) + "ms";
		}
		
		return resultado;
	}
	
	/**
	 * Remove toda a acentuação da string substituindo por caracteres simples sem acento.
	 * @author https://gist.github.com/rponte/893494
	 */
	public static String unaccent(String src) {
		return Normalizer
				.normalize(src, Normalizer.Form.NFD)
				.replaceAll("[^\\p{ASCII}]", "");
	}
}