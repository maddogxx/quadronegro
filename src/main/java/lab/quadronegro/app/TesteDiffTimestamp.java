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

}
