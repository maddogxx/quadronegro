package lab.quadronegro.app;

import java.math.BigDecimal;

import org.junit.Test;

public class CurrencyWriterTest {
	
	@Test
	public void testWriter() {
		BigDecimal amount = BigDecimal.valueOf(2000000.65);
		
		
		System.out.println(CurrencyWriter.getInstance().write(amount));
	}

}