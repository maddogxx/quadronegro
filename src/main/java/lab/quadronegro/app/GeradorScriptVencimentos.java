/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.quadronegro.app;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import lab.quadronegro.vo.Vencimento;

/**
 *
 * @author thiagocs
 */
public class GeradorScriptVencimentos {
    
    public static void main(String[] args) {
        Integer anoInicial = 2016;
        Integer anoFinal = 2066;
        
        for (Integer anoCorrente = anoInicial; anoCorrente <= anoFinal; anoCorrente++ ) {
            //System.out.println("\n---------" + anoCorrente + "-----------\n");
            for (Integer mesCorrente = 1; mesCorrente < 13; mesCorrente++) {
                imprimirComandos(mesCorrente, anoCorrente);
            }
        }
    }
    
    private static void imprimirComandos(Integer mes, Integer ano) {
        String mesFormatado = mes < 10 ? "0" + mes : String.valueOf(mes);
        
        Vencimento vencimento = new Vencimento(mesFormatado + ano);
        
        Calendar calendario = Calendar.getInstance();
        calendario.set(Calendar.DATE, 1);
        calendario.set(Calendar.MONTH, mes - 1);
        calendario.set(Calendar.YEAR, ano);
        
        vencimento.setDataInicial(formatarData(calendario.getTime()));
        
        calendario.set(Calendar.MONTH, mes + 1);
        calendario.add(Calendar.DATE, -1);
        
        vencimento.setDataFinal(formatarData(calendario.getTime()));
        
        System.out.println(vencimento);
    }
    
    private static String formatarData(Date data) {
        SimpleDateFormat formatadorData = new SimpleDateFormat("yyyy-MM-dd");
        
        return formatadorData.format(data);
    }
}