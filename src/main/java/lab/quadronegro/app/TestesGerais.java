package lab.quadronegro.app;

import java.nio.charset.Charset;

public class TestesGerais {

	public static void main(String[] args) {
		
		
		String teste = new String("ÁÉ");
		String teste2 = new String(teste.getBytes(), Charset.forName("ISO-8859-1"));
		
		System.out.println(teste);
		System.out.println(teste2);
		
	}
}
