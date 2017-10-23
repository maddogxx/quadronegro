package lab.quadronegro.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TesteAcessoBlob {
	
	public static void main(String[] args) {
		//extrairImagens();
		
		File diretorio = new File("C:\\Users\\thiagocs\\Documents\\SFTM\\Assinaturas\\Agente\\");
		
		for (File arquivo : diretorio.listFiles()) {
			String[] valores = arquivo.getName().split("_");
			Integer matricula = Integer.valueOf(valores[1].substring(0, valores[1].length() - 4));
			
			inserirAssinatura(matricula, arquivo);
		}
		
		
//		Map<Integer, File> mapa = new HashMap<Integer, File>();
//		mapa.put(662742, new File(diretorio + "gustavoBarbosa.png"));
//		mapa.put(875726, new File(diretorio + "gustavoTavares.png"));
//		mapa.put(896550, new File(diretorio + "hermanNeto.png"));
//		mapa.put(736620, new File(diretorio + "joseValarinhoFilho.png"));
//		mapa.put(874772, new File(diretorio + "joseVarejao.png"));
//		mapa.put(697841, new File(diretorio + "lorenaMassa.png"));
//		mapa.put(639028, new File(diretorio + "ricardoSilva.png"));
//		
//		for (Integer matricula : mapa.keySet()) {
//			inserirAssinaturas(matricula, mapa.get(matricula));
//		}

	}
	
	private static void extrairImagens() {
		try {
			
			String url = "jdbc:oracle:thin:@apipucos.recife:1521/dbemprel";
			String username = "sergiodore";
			String password = "dore8#";		
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection (url, username, password);
			con.setAutoCommit(false);
			
			PreparedStatement pstmt = con.prepareStatement("SELECT APROCUMATR, IPROCUASSI FROM SJPJ.TBPROCURADOR");
			
			ResultSet rs = pstmt.executeQuery();
			String diretorio = "C:\\Users\\thiagocs\\Documents\\SFTM\\Assinaturas\\BMP\\";
			
			while (rs.next()) {
				Integer matricula = rs.getInt(1);
				InputStream assinatura = rs.getBinaryStream(2);
				
				if (assinatura != null) {
					OutputStream os = new FileOutputStream(diretorio + "assinatura_" + matricula + ".bmp");

					byte[] b = new byte[2048];
					int length;

					while ((length = assinatura.read(b)) != -1) {
						os.write(b, 0, length);
					}

					assinatura.close();
					os.close();					
				}
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 		
		
	}
	
	private static void inserirAssinatura(Integer matricula, File assinatura) {
		try {
			String url = "jdbc:db2://macaxeira.recife:50000/dbdesenv";
			String username = "us_teste";
			String password = "testuser";		
			
			
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			
			Connection con = DriverManager.getConnection (url, username, password);
			con.setAutoCommit(false);
			
			PreparedStatement pstmt = con.prepareStatement("UPDATE SFAU.TBAGENTE SET IAGENTASSI = ? WHERE AAGENTMATR = ?");
			
			InputStream in = new FileInputStream(assinatura);
			
			pstmt.setBinaryStream(1, in, (int) assinatura.length());
			pstmt.setInt(2, matricula);
			
			pstmt.executeUpdate();
			con.commit();
			
			pstmt.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 		
	}

}
