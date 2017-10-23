package lab.quadronegro.app;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TesteDiffTimestamp {

	public static void main(String[] args) {
		Date d1 = converterData(31, 8, 2017, 13, 9, 0);
		Date d2 = converterData(31, 8, 2017, 17, 0, 0);

		System.out.println(d1);
		System.out.println(d2);
		
		Map<TimeUnit, Long> resultado = computeDiff(d1, d2);
		
		for (TimeUnit unidade : resultado.keySet()) {
			System.out.println(unidade.name() + " = " + resultado.get(unidade));
		}
		
		System.out.println(calcularDiferencaDatas(d1, d2));
	}

	public static Map<TimeUnit, Long> computeDiff(Date date1, Date date2) {
		long diffInMillies = date2.getTime() - date1.getTime();
		List<TimeUnit> units = new ArrayList<TimeUnit>(EnumSet.allOf(TimeUnit.class));
		Collections.reverse(units);
		Map<TimeUnit, Long> result = new LinkedHashMap<TimeUnit, Long>();
		long milliesRest = diffInMillies;
		for (TimeUnit unit : units) {
			long diff = unit.convert(milliesRest, TimeUnit.MILLISECONDS);
			long diffInMilliesForUnit = unit.toMillis(diff);
			milliesRest = milliesRest - diffInMilliesForUnit;
			result.put(unit, diff);
		}
		return result;
	}

	private static Date converterData(Integer dia, Integer mes, Integer ano, Integer hora, Integer minuto,
			Integer segundo) {
		Calendar calendario = Calendar.getInstance();

		if (dia != null) {
			calendario.set(Calendar.DAY_OF_MONTH, dia);
		}

		if (mes != null) {
			calendario.set(Calendar.MONTH, mes - 1);
		}

		if (ano != null) {
			calendario.set(Calendar.YEAR, ano);
		}

		if (hora != null) {
			calendario.set(Calendar.HOUR_OF_DAY, hora);
		}

		if (minuto != null) {
			calendario.set(Calendar.MINUTE, minuto);
		}

		if (segundo != null) {
			calendario.set(Calendar.SECOND, segundo);
		}

		return calendario.getTime();
	}
	
	private static String calcularDiferencaDatas(Date d1, Date d2) {
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

}
