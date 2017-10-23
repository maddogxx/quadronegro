package lab.quadronegro.app;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class TesteGravarImagens {
	
	public static void main(String[] args) throws IOException {
		String[] urls = {"http://sancho.recife/EMPREL_DAM/DAMgifAutmProd?+++++++++++++ITBI+++++++++1122/02/2016743079.5++++++ANSELMO+MONTENEGRO+DA+SILVA++++++++++++++++++++++++++++*************+++++01/01+15.946806.15.01+++TOT+ATE+22/02/16++++++++R$+1653,24++++++++****************++**+**+**********+****+++****************++**+**+**********+****+++****************++**+**+**********+****+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++PRINCIPAL+++++++1648,95TSD++++++++++++++++4,29++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++PRINCIPAL+++++++1648,95+++TSD++++++++++++++++4,29+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++CAIXA:+NAO+RECEBER+APOS+22/02/16+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++818700000163532435692011602224111153946806152600AV+CAXANGA+125+++++++++++++++++++++++++++++APTO+1502+EDF+MARIA+MANUELLA+-+BLOCO+B	+MADITBI/PARC+1594680615++++++++++++++++++++++++++++++++++++++++++ITBI/PARC+1594680615++++++++++++++++++++++++++++++++++++++++++++++++++++++++",
				"http://sancho.recife/EMPREL_DAM/DAMgifAutmProd?+++++++++++++ITBI+++++++++7822/02/2016743079.5++++++ANSELMO+MONTENEGRO+DA+SILVA++++++++++++++++++++++++++++*************+++++02/01+15.946806.15.02+++TOT+ATE+22/02/16++++++++R$+1653,24++++++++****************++**+**+**********+****+++****************++**+**+**********+****+++****************++**+**+**********+****+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++PRINCIPAL+++++++1648,95TSD++++++++++++++++4,29++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++PRINCIPAL+++++++1648,95+++TSD++++++++++++++++4,29+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++CAIXA:+NAO+RECEBER+APOS+22/02/16+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++818000000160532435692011602224178150946806152732AV+CAXANGA+125+++++++++++++++++++++++++++++APTO+1502+EDF+MARIA+MANUELLA+-+BLOCO+B	+MADITBI/PARC+1594680615++++++++++++++++++++++++++++++++++++++++++ITBI/PARC+1594680615++++++++++++++++++++++++++++++++++++++++++++++++++++++++"};
		
		int contador = 1;
		for (String url : urls) {
			salvarImagem(url, "dam" + contador);
			
			contador++;
		}
	}
	
	private static void salvarImagem(String imageUrl, String destinationFile) throws IOException {
		String destino = destinationFile + ".jpg";
		
		URL url = new URL(imageUrl);
		InputStream is = url.openStream();
		OutputStream os = new FileOutputStream(destino);

		byte[] b = new byte[2048];
		int length;

		while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);
		}

		is.close();
		os.close();
	}	

}
