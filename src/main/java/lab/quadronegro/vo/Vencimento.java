/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.quadronegro.vo;

import java.text.SimpleDateFormat;

/**
 *
 * @author thiagocs
 */
public class Vencimento {
    private String referencia;
    
    private String dataInicial;
    
    private String dataFinal;
    
    public Vencimento(String referencia) {
        this.referencia = referencia;
    }

    public String getReferencia() {
        return "'" + referencia + "'";
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    
    public String getDataInicial() {
        return "TO_DATE('" + dataInicial + "', 'yyyy-MM-dd')";
    }
    
    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getDataFinal() {
        return "TO_DATE('" + dataFinal + "', 'yyyy-MM-dd')";
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }
    
    public String getMatricula() {
        return "'12807'";
    }
    
    public Integer getEmpresa() {
        return 1;
    }
    
    public String getUlat() {
        return "CURRENT_TIMESTAMP";
    }
    
    public String toString() {
        StringBuilder retorno = new StringBuilder("INSERT INTO deop.tbvencimento (");
        retorno.append("nvenci_referencia, ")
                .append("dvenci_data_inicial, ")
                .append("dvenci_data_final, ")
                .append("nvenci_matricula, ")
                .append("cvenci_empresa, ")
                .append("tvenci_ultima_atualizacao")
                .append(") VALUES (")
                .append(getReferencia())
                .append(", ")
                .append(getDataInicial())
                .append(", ")
                .append(getDataFinal())
                .append(", ")
                .append(getMatricula())
                .append(", ")
                .append(getEmpresa())
                .append(", ")
                .append(getUlat())
                .append(");");
        
        return retorno.toString();
    }

}
