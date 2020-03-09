package lab.quadronegro.app;

import org.junit.Assert;
import org.junit.Test;

import lab.quadronegro.util.Util;

/**
 * 
 * @author https://gist.github.com/rponte/893494
 *
 */
public class StringNormalizeTest {
	
	private static final String accents 	= "È,É,Ê,Ë,Û,Ù,Ï,Î,À,Â,Ô,è,é,ê,ë,û,ù,ï,î,à,â,ô,Ç,ç,Ã,ã,Õ,õ";
	private static final String expected	= "E,E,E,E,U,U,I,I,A,A,O,e,e,e,e,u,u,i,i,a,a,o,C,c,A,a,O,o";
	
	private static final String accents2	= "çÇáéíóúýÁÉÍÓÚÝàèìòùÀÈÌÒÙãõñäëïöüÿÄËÏÖÜÃÕÑâêîôûÂÊÎÔÛ";
	private static final String expected2	= "cCaeiouyAEIOUYaeiouAEIOUaonaeiouyAEIOUAONaeiouAEIOU";
	
	private static final String accents3	= "Gisele Bündchen da Conceição e Silva foi batizada assim em homenagem à sua conterrânea de Horizontina, RS.";
	private static final String expected3	= "Gisele Bundchen da Conceicao e Silva foi batizada assim em homenagem a sua conterranea de Horizontina, RS.";
	
	private static final String accents4	= "/Users/rponte/arquivos-portalfcm/Eletron/Atualização_Diária-1.23.40.exe";
	private static final String expected4	= "/Users/rponte/arquivos-portalfcm/Eletron/Atualizacao_Diaria-1.23.40.exe";
	
	private static final String accents5 	= "º,ª,§";
	private static final String expected5	= ",,";

	
	@Test
	public void replacingAllAccents() {
		Assert.assertEquals(expected,  Util.unaccent(accents));
		Assert.assertEquals(expected2, Util.unaccent(accents2));
		Assert.assertEquals(expected3, Util.unaccent(accents3));
		Assert.assertEquals(expected4, Util.unaccent(accents4));
		Assert.assertEquals(expected5, Util.unaccent(accents5));
	}
}
