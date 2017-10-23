/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.quadronegro.vo;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Properties;

/**
 *
 * @author thiagocs
 */
public class DIM {
    /**
     * Tipo da origem de impressao do DIM.
     */
    public final static String ORIGEM_SISTEMA_SISTEMA = "SISTEMA";
    /**
     * Description of the Field
     */
    public final static String ORIGEM_SISTEMA_INTERNET = "INTERNET";
    /**
     * Description of the Field
     */
    public final static String ORIGEM_SISTEMA_QUIOSQUE = "QUIOSQUE";

    /**
     * Description of the Field
     */
    public static String MENSAGEM_0 = "";
    /**
     * Description of the Field
     */
    public static String MENSAGEM_1 = "";
    /**
     * Description of the Field
     */
    public final static String NOME_ARQUIVO_PROPRIEDADES
             = "constantes_dim.properties";
    private String inscricaoImobiliaria;
    private String sequencial;
    private String contribuinte;
    private String documento;
    private String competencia;
    private String codigoLogradouro;
    private String enderecoCompleto;
    private String natureza;
    private String tipoEmpreendimento;
    private String quantidadePavimentos;
    private String dataCadastramento;
    private String superficie;
    private String topografia;
    private String inscricaoMercantil;
    private String razaoSocial;
    private String uso;
    private String coletaLixo;
    private String areaTerreno;
    private String testadaPrincipal;
    private String codigoV0;
    private String testadaFicticia;
    private String valorV0;
    private String fatorReducao;
    private String fracaoIdeal;
    private String valorVenalTerreno;
    private String matrizParteEdificacao[][] = new String[7][10];
    private String observacaoParteEdificacao;
    private String totalAreaConstruida;
    private String totalValorPartes;
    private String valorVenalEdificacao;
    private String regimeTributacaoIPTU;
    private String anoFimVigenciaReducaoIPTU;
    private String regimeTributacaoTLP;
    private String anoFimVigenciaReducaoTLP;
    private String regimeTributacaoCIP;
    private String anoFimVigenciaReducaoCIP;
    private String fatorExcedenteArea;
    private String aliquotaExcedenteArea;
    private String fatorUsoNaoResidencial;
    private String valorVenalImovel;
    private String aliquotaIPTU;
    private String IPTUSemReducao;
    private String TLPSemReducao;
    private String CIPSemReducao;
    private String totalSemDesconto;
    private String totalComDescontoNaUnica;
    private String quantidadeParcelas;
    private String mensagemLinha1;
    private String mensagemLinha2;
    private String mensagemLinha3;
    private String mensagemLinha4;
    private Date dataEmissao;

    /**
     * O construtor do DIM. Todas as vezes que este construtor é chamado, o
     * arquivo de mensagens é consultado.
     *
     * @roseuid   3E83429E0332
     */
    public DIM() {
        inicializarPropriedades();
    }

    /**
     * Inicializa as propriedades do arquivo. É necessário ler do arquivo de
     * propriedades a cada inicialização do DIM.
     */
    private synchronized void inicializarPropriedades() {
        InputStream stream = null;

        try {
            Properties propriedades = new Properties();


/*            stream = ClassLoader.getSystemClassLoader().getResourceAsStream(NOME_ARQUIVO_PROPRIEDADES);

            if (stream == null) {
                stream = DIM.class.getResourceAsStream(NOME_ARQUIVO_PROPRIEDADES);
            }

            if (stream == null) {
                stream = ClassLoader.class.getResourceAsStream(NOME_ARQUIVO_PROPRIEDADES);
            }
*/
			ClassLoader classLoader = ClassLoader.getSystemClassLoader();
			stream = classLoader.getResourceAsStream(NOME_ARQUIVO_PROPRIEDADES);
			if (stream == null) {
				stream = DIM.class.getClassLoader().getResourceAsStream(NOME_ARQUIVO_PROPRIEDADES);
			}
			if (stream == null) {
				stream = DIM.class.getResourceAsStream(NOME_ARQUIVO_PROPRIEDADES);
			}
            
            propriedades.load(stream);

            MENSAGEM_0 = propriedades.getProperty("MENSAGEM_0");
            MENSAGEM_1 = propriedades.getProperty("MENSAGEM_1");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stream != null) {
                    stream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Retorna o valor da inscricaoImobiliaria
     *
     * @return   O valor da inscricaoImobiliaria
     */
    public String getInscricaoImobiliaria() {
        return this.inscricaoImobiliaria;
    }

    /**
     * Seta o valor da inscricaoImobiliaria
     *
     * @param inscricaoImobiliaria  O novo valor da inscricaoImobiliaria
     */
    public void setInscricaoImobiliaria(String inscricaoImobiliaria) {
        this.inscricaoImobiliaria = inscricaoImobiliaria;
    }

    /**
     * Retorna o valor do sequencial
     *
     * @return   O valor do sequencial
     */
    public String getSequencial() {
        return this.sequencial;
    }

    /**
     * Seta o valor do sequencial
     *
     * @param sequencial  O novo valor do sequencial
     */
    public void setSequencial(String sequencial) {
        this.sequencial = sequencial;
    }

    /**
     * Retorna o valor do contribuinte
     *
     * @return   O valor do contribuinte
     */
    public String getContribuinte() {
        return this.contribuinte;
    }

    /**
     * Seta o valor do contribuinte
     *
     * @param contribuinte  O novo valor do contribuinte
     */
    public void setContribuinte(String contribuinte) {
        this.contribuinte = contribuinte;
    }

    /**
     * Retorna o valor do documento
     *
     * @return   O valor do documento
     */
    public String getDocumento() {
        return this.documento;
    }

    /**
     * Seta o valor do documento
     *
     * @param documento  O novo valor do documento
     */
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    /**
     * Retorna o valor da competencia
     *
     * @return   O valor da competencia
     */
    public String getCompetencia() {
        return this.competencia;
    }

    /**
     * Seta o valor do competencia
     *
     * @param competencia  O novo valor do competencia
     */
    public void setCompetencia(String competencia) {
        this.competencia = competencia;
    }

    /**
     * Retorna o valor do codigoLogradouro
     *
     * @return   O valor do codigoLogradouro
     */
    public String getCodigoLogradouro() {
        return this.codigoLogradouro;
    }

    /**
     * Seta o valor do codigoLogradouro
     *
     * @param codigoLogradouro  O novo valor do codigoLogradouro
     */
    public void setCodigoLogradouro(String codigoLogradouro) {
        this.codigoLogradouro = codigoLogradouro;
    }

    /**
     * Retorna o valor do enderecoCompleto
     *
     * @return   O valor do enderecoCompleto
     */
    public String getEnderecoCompleto() {
        return this.enderecoCompleto;
    }

    /**
     * Seta o valor do enderecoCompleto
     *
     * @param enderecoCompleto  O novo valor do enderecoCompleto
     */
    public void setEnderecoCompleto(String enderecoCompleto) {
        this.enderecoCompleto = enderecoCompleto;
    }

    /**
     * Retorna o valor da natureza
     *
     * @return   O valor da natureza
     */
    public String getNatureza() {
        return this.natureza;
    }

    /**
     * Seta o valor do natureza
     *
     * @param natureza  O novo valor do natureza
     */
    public void setNatureza(String natureza) {
        this.natureza = natureza;
    }

    /**
     * Retorna o valor do tipoEmpreendimento
     *
     * @return   O valor do tipoEmpreendimento
     */
    public String getTipoEmpreendimento() {
        return this.tipoEmpreendimento;
    }

    /**
     * Seta o valor do tipoEmpreendimento
     *
     * @param tipoEmpreendimento  O novo valor do tipoEmpreendimento
     */
    public void setTipoEmpreendimento(String tipoEmpreendimento) {
        this.tipoEmpreendimento = tipoEmpreendimento;
    }

    /**
     * Retorna o valor da quantidadePavimentos
     *
     * @return   O valor da quantidadePavimentos
     */
    public String getQuantidadePavimentos() {
        return this.quantidadePavimentos;
    }

    /**
     * Seta o valor do quantidadePavimentos
     *
     * @param quantidadePavimentos  O novo valor do quantidadePavimentos
     */
    public void setQuantidadePavimentos(String quantidadePavimentos) {
        this.quantidadePavimentos = quantidadePavimentos;
    }

    /**
     * Retorna o valor da dataCadastramento
     *
     * @return   O valor da dataCadastramento
     */
    public String getDataCadastramento() {
        return this.dataCadastramento;
    }

    /**
     * Seta o valor do dataCadastramento
     *
     * @param dataCadastramento  O novo valor do dataCadastramento
     */
    public void setDataCadastramento(String dataCadastramento) {
        this.dataCadastramento = dataCadastramento;
    }

    /**
     * Retorna o valor da superficie
     *
     * @return   O valor da superficie
     */
    public String getSuperficie() {
        return this.superficie;
    }

    /**
     * Seta o valor do superficie
     *
     * @param superficie  O novo valor do superficie
     */
    public void setSuperficie(String superficie) {
        this.superficie = superficie;
    }

    /**
     * Retorna o valor da topografia
     *
     * @return   O valor da topografia
     */
    public String getTopografia() {
        return this.topografia;
    }

    /**
     * Seta o valor do topografia
     *
     * @param topografia  O novo valor do topografia
     */
    public void setTopografia(String topografia) {
        this.topografia = topografia;
    }

    /**
     * Retorna o valor da inscricaoMercantil
     *
     * @return   O valor da inscricaoMercantil
     */
    public String getInscricaoMercantil() {
        return this.inscricaoMercantil;
    }

    /**
     * Seta o valor do inscricaoMercantil
     *
     * @param inscricaoMercantil  O novo valor do inscricaoMercantil
     */
    public void setInscricaoMercantil(String inscricaoMercantil) {
        this.inscricaoMercantil = inscricaoMercantil;
    }

    /**
     * Retorna o valor da razaoSocial
     *
     * @return   O valor da razaoSocial
     */
    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    /**
     * Seta o valor do razaoSocial
     *
     * @param razaoSocial  O novo valor do razaoSocial
     */
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    /**
     * Retorna o valor do uso
     *
     * @return   O valor do uso
     */
    public String getUso() {
        return this.uso;
    }

    /**
     * Seta o valor do uso
     *
     * @param uso  O novo valor do uso
     */
    public void setUso(String uso) {
        this.uso = uso;
    }

    /**
     * Retorna o valor da coletaLixo
     *
     * @return   O valor da coletaLixo
     */
    public String getColetaLixo() {
        return this.coletaLixo;
    }

    /**
     * Seta o valor do coletaLixo
     *
     * @param coletaLixo  O novo valor do coletaLixo
     */
    public void setColetaLixo(String coletaLixo) {
        this.coletaLixo = coletaLixo;
    }

    /**
     * Retorna o valor da areaTerreno
     *
     * @return   O valor da areaTerreno
     */
    public String getAreaTerreno() {
        return this.areaTerreno;
    }

    /**
     * Seta o valor do areaTerreno
     *
     * @param areaTerreno  O novo valor do areaTerreno
     */
    public void setAreaTerreno(String areaTerreno) {
        this.areaTerreno = areaTerreno;
    }

    /**
     * Retorna o valor da TestadaPrincipal
     *
     * @return   O valor da TestadaPrincipal
     */
    public String getTestadaPrincipal() {
        return this.testadaPrincipal;
    }

    /**
     * Seta o valor do TestadaPrincipal
     *
     * @param testadaPrincipal  O novo valor de testadaPrincipal
     */
    public void setTestadaPrincipal(String testadaPrincipal) {
        this.testadaPrincipal = testadaPrincipal;
    }

    /**
     * Retorna o valor do codigoV0
     *
     * @return   O valor do codigoV0
     */
    public String getCodigoV0() {
        return this.codigoV0;
    }

    /**
     * Seta o valor do codigoV0
     *
     * @param codigoV0  O novo valor do codigoV0
     */
    public void setCodigoV0(String codigoV0) {
        this.codigoV0 = codigoV0;
    }

    /**
     * Retorna o valor da testadaFicticia
     *
     * @return   O valor da testadaFicticia
     */
    public String getTestadaFicticia() {
        return this.testadaFicticia;
    }

    /**
     * Seta o valor do testadaFicticia
     *
     * @param testadaFicticia  O novo valor do testadaFicticia
     */
    public void setTestadaFicticia(String testadaFicticia) {
        this.testadaFicticia = testadaFicticia;
    }

    /**
     * Retorna o valor do valorV0
     *
     * @return   O valor do valorV0
     */
    public String getValorV0() {
        return this.valorV0;
    }

    /**
     * Seta o valor do valorV0
     *
     * @param valorV0  O novo valor do valorV0
     */
    public void setValorV0(String valorV0) {
        this.valorV0 = valorV0;
    }

    /**
     * Retorna o valor do fatorReducao
     *
     * @return   O valor do fatorReducao
     */
    public String getFatorReducao() {
        return this.fatorReducao;
    }

    /**
     * Seta o valor do fatorReducao
     *
     * @param fatorReducao  O novo valor do fatorReducao
     */
    public void setFatorReducao(String fatorReducao) {
        this.fatorReducao = fatorReducao;
    }

    /**
     * Retorna o valor da fracaoIdeal
     *
     * @return   O valor da fracaoIdeal
     */
    public String getFracaoIdeal() {
        return this.fracaoIdeal;
    }

    /**
     * Seta o valor do fracaoIdeal
     *
     * @param fracaoIdeal  O novo valor do fracaoIdeal
     */
    public void setFracaoIdeal(String fracaoIdeal) {
        this.fracaoIdeal = fracaoIdeal;
    }

    /**
     * Retorna o valor do valorVenalTerreno
     *
     * @return   O valor do valorVenalTerreno
     */
    public String getValorVenalTerreno() {
        return this.valorVenalTerreno;
    }

    /**
     * Seta o valor do valorVenalTerreno
     *
     * @param valorVenalTerreno  O novo valor do valorVenalTerreno
     */
    public void setValorVenalTerreno(String valorVenalTerreno) {
        this.valorVenalTerreno = valorVenalTerreno;
    }

    /**
     * Retorna o valor da MatrizParteEdificacao
     *
     * @return   O valor da matrizParteEdificacao
     */
    public String[][] getMatrizParteEdificacao() {
        return this.matrizParteEdificacao;
    }

    /**
     * Seta o valor da MatrizParteEdificacao
     *
     * @param matrizParteEdificacao  O novo valor do matrizParteEdificacao
     */
    public void setMatrizParteEdificacao(String[][] matrizParteEdificacao) {
        this.matrizParteEdificacao = matrizParteEdificacao;
    }

    /**
     * Retorna o valor da observacaoParteEdificacao
     *
     * @return   O valor da observacaoParteEdificacao
     */
    public String getObservacaoParteEdificacao() {
        return this.observacaoParteEdificacao;
    }

    /**
     * Seta o valor do observacaoParteEdificacao
     *
     * @param observacaoParteEdificacao  O novo valor do
     *      observacaoParteEdificacao
     */
    public void setObservacaoParteEdificacao(String observacaoParteEdificacao) {
        this.observacaoParteEdificacao = observacaoParteEdificacao;
    }

    /**
     * Retorna o valor do totalAreaConstruida
     *
     * @return   O valor do totalAreaConstruida
     */
    public String getTotalAreaConstruida() {
        return this.totalAreaConstruida;
    }

    /**
     * Seta o valor do totalAreaConstruida
     *
     * @param totalAreaConstruida  O novo valor do totalAreaConstruida
     */
    public void setTotalAreaConstruida(String totalAreaConstruida) {
        this.totalAreaConstruida = totalAreaConstruida;
    }

    /**
     * Retorna o valor do totalValorPartes
     *
     * @return   O valor do totalValorPartes
     */
    public String getTotalValorPartes() {
        return this.totalValorPartes;
    }

    /**
     * Seta o valor do totalValorPartes
     *
     * @param totalValorPartes  O novo valor do totalValorPartes
     */
    public void setTotalValorPartes(String totalValorPartes) {
        this.totalValorPartes = totalValorPartes;
    }

    /**
     * Retorna o valor do valorVenalEdificacao
     *
     * @return   O valor do valorVenalEdificacao
     */
    public String getValorVenalEdificacao() {
        return this.valorVenalEdificacao;
    }

    /**
     * Seta o valor do valorVenalEdificacao
     *
     * @param valorVenalEdificacao  O novo valor do valorVenalEdificacao
     */
    public void setValorVenalEdificacao(String valorVenalEdificacao) {
        this.valorVenalEdificacao = valorVenalEdificacao;
    }

    /**
     * Retorna o valor do regimeTributacaoIPTU
     *
     * @return   O valor do regimeTributacaoIPTU
     */
    public String getRegimeTributacaoIPTU() {
        return this.regimeTributacaoIPTU;
    }

    /**
     * Seta o valor do regimeTributacaoIPTU
     *
     * @param regimeTributacaoIPTU  O novo valor do regimeTributacaoIPTU
     */
    public void setRegimeTributacaoIPTU(String regimeTributacaoIPTU) {
        this.regimeTributacaoIPTU = regimeTributacaoIPTU;
    }

    /**
     * Retorna o valor do anoFimVigenciaReducaoIPTU
     *
     * @return   O valor do anoFimVigenciaReducaoIPTU
     */
    public String getAnoFimVigenciaReducaoIPTU() {
        return this.anoFimVigenciaReducaoIPTU;
    }

    /**
     * Seta o valor do anoFimVigenciaReducaoIPTU
     *
     * @param anoFimVigenciaReducaoIPTU  O novo valor do
     *      anoFimVigenciaReducaoIPTU
     */
    public void setAnoFimVigenciaReducaoIPTU(String anoFimVigenciaReducaoIPTU) {
        this.anoFimVigenciaReducaoIPTU = anoFimVigenciaReducaoIPTU;
    }

    /**
     * Retorna o valor do regimeTributacaoTLP
     *
     * @return   O valor do regimeTributacaoTLP
     */
    public String getRegimeTributacaoTLP() {
        return this.regimeTributacaoTLP;
    }

    /**
     * Seta o valor do regimeTributacaoTLP
     *
     * @param regimeTributacaoTLP  O novo valor do regimeTributacaoTLP
     */
    public void setRegimeTributacaoTLP(String regimeTributacaoTLP) {
        this.regimeTributacaoTLP = regimeTributacaoTLP;
    }

    /**
     * Retorna o valor do anoFimVigenciaReducaoTLP
     *
     * @return   O valor do anoFimVigenciaReducaoTLP
     */
    public String getAnoFimVigenciaReducaoTLP() {
        return this.anoFimVigenciaReducaoTLP;
    }

    /**
     * Seta o valor do anoFimVigenciaReducaoTLP
     *
     * @param anoFimVigenciaReducaoTLP  O novo valor do anoFimVigenciaReducaoTLP
     */
    public void setAnoFimVigenciaReducaoTLP(String anoFimVigenciaReducaoTLP) {
        this.anoFimVigenciaReducaoTLP = anoFimVigenciaReducaoTLP;
    }

    /**
     * Retorna o valor do regimeTributacaoCIP
     *
     * @return   O valor do regimeTributacaoCIP
     */
    public String getRegimeTributacaoCIP() {
        return this.regimeTributacaoCIP;
    }

    /**
     * Seta o valor do regimeTributacaoCIP
     *
     * @param regimeTributacaoCIP  O novo valor do regimeTributacaoCIP
     */
    public void setRegimeTributacaoCIP(String regimeTributacaoCIP) {
        this.regimeTributacaoCIP = regimeTributacaoCIP;
    }

    /**
     * Retorna o valor do anoFimVigenciaReducaoCIP
     *
     * @return   O valor do anoFimVigenciaReducaoCIP
     */
    public String getAnoFimVigenciaReducaoCIP() {
        return this.anoFimVigenciaReducaoCIP;
    }

    /**
     * Seta o valor do anoFimVigenciaReducaoCIP
     *
     * @param anoFimVigenciaReducaoCIP  O novo valor do anoFimVigenciaReducaoCIP
     */
    public void setAnoFimVigenciaReducaoCIP(String anoFimVigenciaReducaoCIP) {
        this.anoFimVigenciaReducaoCIP = anoFimVigenciaReducaoCIP;
    }

    /**
     * Retorna o valor do fatorExcedenteArea
     *
     * @return   O valor do fatorExcedenteArea
     */
    public String getFatorExcedenteArea() {
        return this.fatorExcedenteArea;
    }

    /**
     * Seta o valor do fatorExcedenteArea
     *
     * @param fatorExcedenteArea  O novo valor do fatorExcedenteArea
     */
    public void setFatorExcedenteArea(String fatorExcedenteArea) {
        this.fatorExcedenteArea = fatorExcedenteArea;
    }

    /**
     * Retorna o valor da aliquotaExcedenteArea
     *
     * @return   O valor da aliquotaExcedenteArea
     */
    public String getAliquotaExcedenteArea() {
        return this.aliquotaExcedenteArea;
    }

    /**
     * Seta o valor do aliquotaExcedenteArea
     *
     * @param aliquotaExcedenteArea  O novo valor do aliquotaExcedenteArea
     */
    public void setAliquotaExcedenteArea(String aliquotaExcedenteArea) {
        this.aliquotaExcedenteArea = aliquotaExcedenteArea;
    }

    /**
     * Retorna o valor do fatorUsoNaoResidencial
     *
     * @return   O valor do fatorUsoNaoResidencial
     */
    public String getFatorUsoNaoResidencial() {
        return this.fatorUsoNaoResidencial;
    }

    /**
     * Seta o valor do fatorUsoNaoResidencial
     *
     * @param fatorUsoNaoResidencial  O novo valor do fatorUsoNaoResidencial
     */
    public void setFatorUsoNaoResidencial(String fatorUsoNaoResidencial) {
        this.fatorUsoNaoResidencial = fatorUsoNaoResidencial;
    }

    /**
     * Retorna o valor do valorVenalImovel
     *
     * @return   O valor do valorVenalImovel
     */
    public String getValorVenalImovel() {
        return this.valorVenalImovel;
    }

    /**
     * Seta o valor do valorVenalImovel
     *
     * @param valorVenalImovel  O novo valor do valorVenalImovel
     */
    public void setValorVenalImovel(String valorVenalImovel) {
        this.valorVenalImovel = valorVenalImovel;
    }

    /**
     * Retorna o valor da aliquotaIPTU
     *
     * @return   O valor da aliquotaIPTU
     */
    public String getAliquotaIPTU() {
        return this.aliquotaIPTU;
    }

    /**
     * Seta o valor do aliquotaIPTU
     *
     * @param aliquotaIPTU  O novo valor do aliquotaIPTU
     */
    public void setAliquotaIPTU(String aliquotaIPTU) {
        this.aliquotaIPTU = aliquotaIPTU;
    }

    /**
     * Retorna o valor do IPTUSemReducao
     *
     * @return   O valor do IPTUSemReducao
     */
    public String getIPTUSemReducao() {
        return this.IPTUSemReducao;
    }

    /**
     * Seta o valor do IPTUSemReducao
     *
     * @param IPTUSemReducao  O novo valor do IPTUSemReducao
     */
    public void setIPTUSemReducao(String IPTUSemReducao) {
        this.IPTUSemReducao = IPTUSemReducao;
    }

    /**
     * Retorna o valor do TLPSemReducao
     *
     * @return   O valor do TLPSemReducao
     */
    public String getTLPSemReducao() {
        return this.TLPSemReducao;
    }

    /**
     * Seta o valor do TLPSemReducao
     *
     * @param TLPSemReducao  O novo valor do TLPSemReducao
     */
    public void setTLPSemReducao(String TLPSemReducao) {
        this.TLPSemReducao = TLPSemReducao;
    }

    /**
     * Retorna o valor do CIPSemReducao
     *
     * @return   O valor do CIPSemReducao
     */
    public String getCIPSemReducao() {
        return this.CIPSemReducao;
    }

    /**
     * Seta o valor do CIPSemReducao
     *
     * @param CIPSemReducao  O novo valor do CIPSemReducao
     */
    public void setCIPSemReducao(String CIPSemReducao) {
        this.CIPSemReducao = CIPSemReducao;
    }

    /**
     * Retorna o valor do totalSemDesconto
     *
     * @return   O valor do totalSemDesconto
     */
    public String getTotalSemDesconto() {
        return this.totalSemDesconto;
    }

    /**
     * Seta o valor do totalSemDesconto
     *
     * @param totalSemDesconto  O novo valor do totalSemDesconto
     */
    public void setTotalSemDesconto(String totalSemDesconto) {
        this.totalSemDesconto = totalSemDesconto;
    }

    /**
     * Retorna o valor do totalComDescontoNaUnica
     *
     * @return   O valor do totalComDescontoNaUnica
     */
    public String getTotalComDescontoNaUnica() {
        return this.totalComDescontoNaUnica;
    }

    /**
     * Seta o valor do totalComDescontoNaUnica
     *
     * @param totalComDescontoNaUnica  O novo valor do totalComDescontoNaUnica
     */
    public void setTotalComDescontoNaUnica(String totalComDescontoNaUnica) {
        this.totalComDescontoNaUnica = totalComDescontoNaUnica;
    }

    /**
     * Retorna o valor da quantidadeParcelas
     *
     * @return   O valor da quantidadeParcelas
     */
    public String getQuantidadeParcelas() {
        return this.quantidadeParcelas;
    }

    /**
     * Seta o valor do quantidadeParcelas
     *
     * @param quantidadeParcelas  O novo valor do quantidadeParcelas
     */
    public void setQuantidadeParcelas(String quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    /**
     * Retorna o valor da mensagemLinha1
     *
     * @return   O valor da mensagemLinha1
     */
    public String getMensagemLinha1() {
        return this.mensagemLinha1;
    }

    /**
     * Seta o valor do mensagemLinha1
     *
     * @param mensagemLinha1  O novo valor do mensagemLinha1
     */
    public void setMensagemLinha1(String mensagemLinha1) {
        this.mensagemLinha1 = mensagemLinha1;
    }

    /**
     * Retorna o valor da mensagemLinha2
     *
     * @return   O valor da mensagemLinha2
     */
    public String getMensagemLinha2() {
        return this.mensagemLinha2;
    }

    /**
     * Seta o valor de mensagemLinha2
     *
     * @param mensagemLinha2  O novo valor de mensagemLinha2
     */
    public void setMensagemLinha2(String mensagemLinha2) {
        this.mensagemLinha2 = mensagemLinha2;
    }

    /**
     * Retorna o valor da mensagemLinha3
     *
     * @return   O valor da mensagemLinha3
     */
    public String getMensagemLinha3() {
        return this.mensagemLinha3;
    }

    /**
     * Seta o valor do mensagemLinha3
     *
     * @param mensagemLinha3  O novo valor do mensagemLinha3
     */
    public void setMensagemLinha3(String mensagemLinha3) {
        this.mensagemLinha3 = mensagemLinha3;
    }

    /**
     * Retorna o valor da mensagemLinha4
     *
     * @return   O valor da mensagemLinha4
     */
    public String getMensagemLinha4() {
        return this.mensagemLinha4;
    }

    /**
     * Seta o valor do mensagemLinha4
     *
     * @param mensagemLinha4  O novo valor do mensagemLinha4
     */
    public void setMensagemLinha4(String mensagemLinha4) {
        this.mensagemLinha4 = mensagemLinha4;
    }

    /**
     * Retorna o valor de dataEmissao
     *
     * @return   O valor de dataEmissao
     */
    public Date getDataEmissao() {
        return dataEmissao;
    }

    /**
     * Seta o valor de dataEmissao
     *
     * @param dataEmissao  O novo valor de dataEmissao
     */
    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    /**
     * Obtém a data formatada como dd/MM/yyyy.
     *
     * @return   A data de emissão formatada.
     */
    public String getDataEmissaoFormatada() {
        return getDataEmissaoFormatada("dd/MM/yyyy");
    }

    /**
     * Obtém a data formatada conforme o formato de data fornecido.
     *
     * @param formato  O formato da data conforme a classe <code>java.text.SimpleDateFormat</code>
     *      .
     * @return         A data de emissão formatada.
     * @see            java.text.SimpleDateFormat
     */
    public String getDataEmissaoFormatada(String formato) {
        SimpleDateFormat formatoData = new SimpleDateFormat(formato);
        String dataFormatada = "";

        if (dataEmissao != null) {
            dataFormatada = formatoData.format(dataEmissao);
        }

        return dataFormatada;
    }


    /**
     * Retorna uma Hashtable com os parametros do DIM que serão utilizados para
     * a construção do formulário GIF deste.
     *
     * @param origem    O sistema de origem do pedido do DIM. As constantes para
     * os sistemas de origem podem ser pegas nesta classe.
     *
     * @return    Os parâmetros necessários para a construção do formulário GIF.
     */
    public Hashtable getParametrosFormularioGIF( String origem ) {
        Hashtable retorno = new Hashtable();

        retorno.put("InscricaoImobiliaria", this.getInscricaoImobiliaria());
        retorno.put("Sequencial", this.getSequencial());
        retorno.put("Contribuinte", this.getContribuinte());
        retorno.put("Documento", this.getDocumento());
        retorno.put("Competencia", this.getCompetencia());
        retorno.put("CodigoLogradouro", this.getCodigoLogradouro());
        retorno.put("EnderecoCompleto", this.getEnderecoCompleto());
        retorno.put("Natureza", this.getNatureza());
        retorno.put("TipoEmpreendimento", this.getTipoEmpreendimento());
        retorno.put("QuantidadePavimentos", this.getQuantidadePavimentos());
        retorno.put("DataCadastramento", this.getDataCadastramento());
        retorno.put("Superficie", this.getSuperficie());
        retorno.put("Topografia", this.getTopografia());
        retorno.put("InscricaoMercantil", this.getInscricaoMercantil());
        retorno.put("RazaoSocial", this.getRazaoSocial());
        retorno.put("Uso", this.getUso());
        retorno.put("ColetaLixo", this.getColetaLixo());
        retorno.put("AreaTerreno", this.getAreaTerreno());
        retorno.put("TestadaPrincipal", this.getTestadaPrincipal());
        retorno.put("CodigoV0", this.getCodigoV0());
        retorno.put("TestadaFicticia", this.getTestadaFicticia());
        retorno.put("ValorV0", this.getValorV0());
        retorno.put("FatorReducao", this.getFatorReducao());
        retorno.put("FracaoIdeal", this.getFracaoIdeal());
        retorno.put("ValorVenalTerreno", this.getValorVenalTerreno());

        String matriz[][] = new String[6][9];

        matriz = this.getMatrizParteEdificacao();
		int linha = 0;

        for (int i = 0; i < 6; i++) {
            if (matriz[i][1] != null ) {
                linha++;

                retorno.put("ParteEdificacaoLinha"+linha+"_1", matriz[i][0]);
                retorno.put("ParteEdificacaoLinha"+linha+"_2", matriz[i][1]);
                retorno.put("ParteEdificacaoLinha"+linha+"_3", matriz[i][2]);
                retorno.put("ParteEdificacaoLinha"+linha+"_4", matriz[i][3]);
                retorno.put("ParteEdificacaoLinha"+linha+"_5", matriz[i][4]);
                retorno.put("ParteEdificacaoLinha"+linha+"_6", matriz[i][5]);
                retorno.put("ParteEdificacaoLinha"+linha+"_7", matriz[i][6]);
                retorno.put("ParteEdificacaoLinha"+linha+"_8", matriz[i][7]);
                retorno.put("ParteEdificacaoLinha"+linha+"_9", matriz[i][8]);
                if (i==5) {
                    if ((this.getObservacaoParteEdificacao().equals("")) ||
                        (this.getObservacaoParteEdificacao() == null)) {
                        retorno.put("ObservacaoLinha6", "");
                    }else{
                        retorno.put("ObservacaoLinha6", this.getObservacaoParteEdificacao());

                    }
                }
           }
        }
		for (int i = ++linha; i <= matriz.length; i++) {
	        for (int j = 1; j < 10; j++) {
	            retorno.put("ParteEdificacaoLinha"+ i +"_"+j, "");
	        }
		}
        retorno.put("ObservacaoLinha6", "");

        retorno.put("TotalAreaConstruida", this.getTotalAreaConstruida());
        retorno.put("TotalValorPartes", this.getTotalValorPartes());
        retorno.put("FatorReducao1", this.getFatorReducao());
        retorno.put("ValorVenalEdificacao", this.getValorVenalEdificacao());
        retorno.put("RegimeTributacaoIPTU", this.getRegimeTributacaoIPTU());
        retorno.put("AnoFimVigenciaReducaoIPTU", this.getAnoFimVigenciaReducaoIPTU());
        retorno.put("RegimeTributacaoTLP", this.getRegimeTributacaoTLP());
        retorno.put("AnoFimVigenciaReducaoTLP", this.getAnoFimVigenciaReducaoTLP());
        retorno.put("RegimeTributacaoCIP", this.getRegimeTributacaoCIP());
        retorno.put("AnoFimVigenciaReducaoCIP", this.getAnoFimVigenciaReducaoCIP());
        retorno.put("FatorExcedenteArea", this.getFatorExcedenteArea());
        retorno.put("AliquotaExcedenteArea", this.getAliquotaExcedenteArea());
        retorno.put("FatorUsoNaoResidencial", this.getFatorUsoNaoResidencial());
        retorno.put("ValorVenalImovel", this.getValorVenalImovel());
        retorno.put("AliquotaIPTU", this.getAliquotaIPTU());
        retorno.put("IPTUSemReducao", this.getIPTUSemReducao());
        retorno.put("TLPSemReducao", this.getTLPSemReducao());
        retorno.put("CIPSemReducao", this.getCIPSemReducao());
        retorno.put("TotalSemDesconto", this.getTotalSemDesconto());
        retorno.put("TotalComDescontoNaUnica", this.getTotalComDescontoNaUnica());
        retorno.put("QuantidadeParcelas", this.getQuantidadeParcelas());
        retorno.put("MensagemLinha1", this.getMensagemLinha1());
        retorno.put("MensagemLinha2", this.getMensagemLinha2());
        retorno.put("MensagemLinha3", this.getMensagemLinha3());
        retorno.put("MensagemLinha4", this.getMensagemLinha4());
        retorno.put("Emissao", "EMISSÃO - " + origem + " "
                + this.getDataEmissaoFormatada());

        return retorno;
    }

	public String toString() {
		String resultado = "DIM [";
		boolean virgula = false;

		if (sequencial != null) {
			resultado = resultado + "sequencial=" + sequencial;
			virgula = true;
		}

		if (inscricaoImobiliaria != null) {
			if (virgula) {
				resultado = resultado + ", inscricaoImobiliaria=" + inscricaoImobiliaria;
			} else {
				resultado = resultado + "inscricaoImobiliaria=" + inscricaoImobiliaria;
				virgula = true;
			}
		}

		if (contribuinte != null) {
			if (virgula) {
				resultado = resultado + ", contribuinte=" + contribuinte;
			} else {
				resultado = resultado + "contribuinte=" + contribuinte;
				virgula = true;
			}
		}

		if (documento != null) {
			if (virgula) {
				resultado = resultado + ", documento=" + documento;
			} else {
				resultado = resultado + "documento=" + documento;
				virgula = true;
			}
		}

		if (competencia != null) {
			if (virgula) {
				resultado = resultado + ", competencia=" + competencia;
			} else {
				resultado = resultado + "competencia=" + competencia;
				virgula = true;
			}
		}

		if (codigoLogradouro != null) {
			if (virgula) {
				resultado = resultado + ", codigoLogradouro=" + codigoLogradouro;
			} else {
				resultado = resultado + "codigoLogradouro=" + codigoLogradouro;
				virgula = true;
			}
		}

		if (enderecoCompleto != null) {
			if (virgula) {
				resultado = resultado + ", enderecoCompleto=" + enderecoCompleto;
			} else {
				resultado = resultado + "enderecoCompleto=" + enderecoCompleto;
				virgula = true;
			}
		}

		if (natureza != null) {
			if (virgula) {
				resultado = resultado + ", natureza=" + natureza;
			} else {
				resultado = resultado + "natureza=" + natureza;
				virgula = true;
			}
		}
		if (tipoEmpreendimento != null) {
			if (virgula) {
				resultado = resultado + ", tipoEmpreendimento=" + tipoEmpreendimento;
			} else {
				resultado = resultado + "tipoEmpreendimento=" + tipoEmpreendimento;
				virgula = true;
			}
		}
		if (quantidadePavimentos != null) {
			if (virgula) {
				resultado = resultado + ", quantidadePavimentos=" + quantidadePavimentos;
			} else {
				resultado = resultado + "quantidadePavimentos=" + quantidadePavimentos;
				virgula = true;
			}
		}
		if (dataCadastramento != null) {
			if (virgula) {
				resultado = resultado + ", dataCadastramento=" + dataCadastramento;
			} else {
				resultado = resultado + "dataCadastramento=" + dataCadastramento;
				virgula = true;
			}
		}
		if (superficie != null) {
			if (virgula) {
				resultado = resultado + ", superficie=" + superficie;
			} else {
				resultado = resultado + "superficie=" + superficie;
				virgula = true;
			}
		}
		if (topografia != null) {
			if (virgula) {
				resultado = resultado + ", topografia=" + topografia;
			} else {
				resultado = resultado + "topografia=" + topografia;
				virgula = true;
			}
		}
		if (inscricaoMercantil != null) {
			if (virgula) {
				resultado = resultado + ", inscricaoMercantil=" + inscricaoMercantil;
			} else {
				resultado = resultado + "inscricaoMercantil=" + inscricaoMercantil;
				virgula = true;
			}
		}
		if (razaoSocial != null) {
			if (virgula) {
				resultado = resultado + ", razaoSocial=" + razaoSocial;
			} else {
				resultado = resultado + "razaoSocial=" + razaoSocial;
				virgula = true;
			}
		}
		if (uso != null) {
			if (virgula) {
				resultado = resultado + ", uso=" + uso;
			} else {
				resultado = resultado + "uso=" + uso;
				virgula = true;
			}
		}
		if (coletaLixo != null) {
			if (virgula) {
				resultado = resultado + ", coletaLixo=" + coletaLixo;
			} else {
				resultado = resultado + "coletaLixo=" + coletaLixo;
				virgula = true;
			}
		}
		if (areaTerreno != null) {
			if (virgula) {
				resultado = resultado + ", areaTerreno=" + areaTerreno;
			} else {
				resultado = resultado + "areaTerreno=" + areaTerreno;
				virgula = true;
			}
		}
		if (testadaPrincipal != null) {
			if (virgula) {
				resultado = resultado + ", testadaPrincipal=" + testadaPrincipal;
			} else {
				resultado = resultado + "testadaPrincipal=" + testadaPrincipal;
				virgula = true;
			}
		}
		if (codigoV0 != null) {
			if (virgula) {
				resultado = resultado + ", codigoV0=" + codigoV0;
			} else {
				resultado = resultado + "codigoV0=" + codigoV0;
				virgula = true;
			}
		}
		if (testadaFicticia != null) {
			if (virgula) {
				resultado = resultado + ", testadaFicticia=" + testadaFicticia;
			} else {
				resultado = resultado + "testadaFicticia=" + testadaFicticia;
				virgula = true;
			}
		}
		if (valorV0 != null) {
			if (virgula) {
				resultado = resultado + ", valorV0=" + valorV0;
			} else {
				resultado = resultado + "valorV0=" + valorV0;
				virgula = true;
			}
		}
		if (fatorReducao != null) {
			if (virgula) {
				resultado = resultado + ", fatorReducao=" + fatorReducao;
			} else {
				resultado = resultado + "fatorReducao=" + fatorReducao;
				virgula = true;
			}
		}
		if (fracaoIdeal != null) {
			if (virgula) {
				resultado = resultado + ", fracaoIdeal=" + fracaoIdeal;
			} else {
				resultado = resultado + "fracaoIdeal=" + fracaoIdeal;
				virgula = true;
			}
		}
		if (valorVenalTerreno != null) {
			if (virgula) {
				resultado = resultado + ", valorVenalTerreno=" + valorVenalTerreno;
			} else {
				resultado = resultado + "valorVenalTerreno=" + valorVenalTerreno;
				virgula = true;
			}
		}
		if (observacaoParteEdificacao != null) {
			if (virgula) {
				resultado = resultado + ", observacaoParteEdificacao=" + observacaoParteEdificacao;
			} else {
				resultado = resultado + "observacaoParteEdificacao=" + observacaoParteEdificacao;
				virgula = true;
			}
		}
		if (totalAreaConstruida != null) {
			if (virgula) {
				resultado = resultado + ", totalAreaConstruida=" + totalAreaConstruida;
			} else {
				resultado = resultado + "totalAreaConstruida=" + totalAreaConstruida;
				virgula = true;
			}
		}
		if (totalValorPartes != null) {
			if (virgula) {
				resultado = resultado + ", totalValorPartes=" + totalValorPartes;
			} else {
				resultado = resultado + "totalValorPartes=" + totalValorPartes;
				virgula = true;
			}
		}
		if (valorVenalEdificacao != null) {
			if (virgula) {
				resultado = resultado + ", valorVenalEdificacao=" + valorVenalEdificacao;
			} else {
				resultado = resultado + "valorVenalEdificacao=" + valorVenalEdificacao;
				virgula = true;
			}
		}
		if (regimeTributacaoIPTU != null) {
			if (virgula) {
				resultado = resultado + ", regimeTributacaoIPTU=" + regimeTributacaoIPTU;
			} else {
				resultado = resultado + "regimeTributacaoIPTU=" + regimeTributacaoIPTU;
				virgula = true;
			}
		}
		if (anoFimVigenciaReducaoIPTU != null) {
			if (virgula) {
				resultado = resultado + ", anoFimVigenciaReducaoIPTU=" + anoFimVigenciaReducaoIPTU;
			} else {
				resultado = resultado + "anoFimVigenciaReducaoIPTU=" + anoFimVigenciaReducaoIPTU;
				virgula = true;
			}
		}
		if (regimeTributacaoTLP != null) {
			if (virgula) {
				resultado = resultado + ", regimeTributacaoTLP=" + regimeTributacaoTLP;
			} else {
				resultado = resultado + "regimeTributacaoTLP=" + regimeTributacaoTLP;
				virgula = true;
			}
		}
		if (anoFimVigenciaReducaoTLP != null) {
			if (virgula) {
				resultado = resultado + ", anoFimVigenciaReducaoTLP=" + anoFimVigenciaReducaoTLP;
			} else {
				resultado = resultado + "anoFimVigenciaReducaoTLP=" + anoFimVigenciaReducaoTLP;
				virgula = true;
			}
		}
		if (regimeTributacaoCIP != null) {
			if (virgula) {
				resultado = resultado + ", regimeTributacaoCIP=" + regimeTributacaoCIP;
			} else {
				resultado = resultado + "regimeTributacaoCIP=" + regimeTributacaoCIP;
				virgula = true;
			}
		}
		if (anoFimVigenciaReducaoCIP != null) {
			if (virgula) {
				resultado = resultado + ", anoFimVigenciaReducaoCIP=" + anoFimVigenciaReducaoCIP;
			} else {
				resultado = resultado + "anoFimVigenciaReducaoCIP=" + anoFimVigenciaReducaoCIP;
				virgula = true;
			}
		}
		if (fatorExcedenteArea != null) {
			if (virgula) {
				resultado = resultado + ", fatorExcedenteArea=" + fatorExcedenteArea;
			} else {
				resultado = resultado + "fatorExcedenteArea=" + fatorExcedenteArea;
				virgula = true;
			}
		}
		if (aliquotaExcedenteArea != null) {
			if (virgula) {
				resultado = resultado + ", aliquotaExcedenteArea=" + aliquotaExcedenteArea;
			} else {
				resultado = resultado + "aliquotaExcedenteArea=" + aliquotaExcedenteArea;
				virgula = true;
			}
		}
		if (fatorUsoNaoResidencial != null) {
			if (virgula) {
				resultado = resultado + ", fatorUsoNaoResidencial=" + fatorUsoNaoResidencial;
			} else {
				resultado = resultado + "fatorUsoNaoResidencial=" + fatorUsoNaoResidencial;
				virgula = true;
			}
		}
		if (valorVenalImovel != null) {
			if (virgula) {
				resultado = resultado + ", valorVenalImovel=" + valorVenalImovel;
			} else {
				resultado = resultado + "valorVenalImovel=" + valorVenalImovel;
				virgula = true;
			}
		}
		if (aliquotaIPTU != null) {
			if (virgula) {
				resultado = resultado + ", aliquotaIPTU=" + aliquotaIPTU;
			} else {
				resultado = resultado + "aliquotaIPTU=" + aliquotaIPTU;
				virgula = true;
			}
		}
		if (IPTUSemReducao != null) {
			if (virgula) {
				resultado = resultado + ", IPTUSemReducao=" + IPTUSemReducao;
			} else {
				resultado = resultado + "IPTUSemReducao=" + IPTUSemReducao;
				virgula = true;
			}
		}
		if (TLPSemReducao != null) {
			if (virgula) {
				resultado = resultado + ", TLPSemReducao=" + TLPSemReducao;
			} else {
				resultado = resultado + "TLPSemReducao=" + TLPSemReducao;
				virgula = true;
			}
		}
		if (CIPSemReducao != null) {
			if (virgula) {
				resultado = resultado + ", CIPSemReducao=" + CIPSemReducao;
			} else {
				resultado = resultado + "CIPSemReducao=" + CIPSemReducao;
				virgula = true;
			}
		}
		if (totalSemDesconto != null) {
			if (virgula) {
				resultado = resultado + ", totalSemDesconto=" + totalSemDesconto;
			} else {
				resultado = resultado + "totalSemDesconto=" + totalSemDesconto;
				virgula = true;
			}
		}
		if (totalComDescontoNaUnica != null) {
			if (virgula) {
				resultado = resultado + ", totalComDescontoNaUnica=" + totalComDescontoNaUnica;
			} else {
				resultado = resultado + "totalComDescontoNaUnica=" + totalComDescontoNaUnica;
				virgula = true;
			}
		}
		if (quantidadeParcelas != null) {
			if (virgula) {
				resultado = resultado + ", quantidadeParcelas=" + quantidadeParcelas;
			} else {
				resultado = resultado + "quantidadeParcelas=" + quantidadeParcelas;
				virgula = true;
			}
		}
		if (mensagemLinha1 != null) {
			if (virgula) {
				resultado = resultado + ", mensagemLinha1=" + mensagemLinha1;
			} else {
				resultado = resultado + "mensagemLinha1=" + mensagemLinha1;
				virgula = true;
			}
		}
		if (mensagemLinha2 != null) {
			if (virgula) {
				resultado = resultado + ", mensagemLinha2=" + mensagemLinha2;
			} else {
				resultado = resultado + "mensagemLinha2=" + mensagemLinha2;
				virgula = true;
			}
		}
		if (mensagemLinha3 != null) {
			if (virgula) {
				resultado = resultado + ", mensagemLinha3=" + mensagemLinha3;
			} else {
				resultado = resultado + "mensagemLinha3=" + mensagemLinha3;
				virgula = true;
			}
		}
		if (mensagemLinha4 != null) {
			if (virgula) {
				resultado = resultado + ", mensagemLinha4=" + mensagemLinha4;
			} else {
				resultado = resultado + "mensagemLinha4=" + mensagemLinha4;
				virgula = true;
			}
		}
		if (dataEmissao != null) {
			if (virgula) {
				resultado = resultado + ", dataEmissao=" + dataEmissao;
			} else {
				resultado = resultado + "dataEmissao=" + dataEmissao;
				virgula = true;
			}
		}
		
		if (virgula) {
			resultado = resultado + ", " + toStringMatriz(matrizParteEdificacao, "matrizParteEdificacao");
		} else {
			resultado = resultado + toStringMatriz(matrizParteEdificacao, "matrizParteEdificacao");
		}
		
		resultado = resultado + "]";

		return resultado;
	}
	
	private String toStringMatriz(String[][] matriz, String titulo) {
		String resultado = titulo + " [";
		
		boolean virgula = false;
		
		int linha = 0;

		for (int i = 0; i < 6; i++) {
			if (matriz[i][1] != null) {
				linha++;
				
				if (virgula) {
					resultado = resultado + ", L" + linha + "[";
				} else {
					resultado = resultado + "L" + linha + "[";
					virgula = true;
				}
				
				resultado = resultado + "ParteEdificacaoLinha" + linha + "_1 = " + matriz[i][0];
				resultado = resultado + ", ParteEdificacaoLinha" + linha + "_2 = " + matriz[i][1];
				resultado = resultado + ", ParteEdificacaoLinha" + linha + "_3 = " + matriz[i][2];
				resultado = resultado + ", ParteEdificacaoLinha" + linha + "_4 = " + matriz[i][3];
				resultado = resultado + ", ParteEdificacaoLinha" + linha + "_5 = " + matriz[i][4];
				resultado = resultado + ", ParteEdificacaoLinha" + linha + "_6 = " + matriz[i][5];
				resultado = resultado + ", ParteEdificacaoLinha" + linha + "_7 = " + matriz[i][6];
				resultado = resultado + ", ParteEdificacaoLinha" + linha + "_8 = " + matriz[i][7];
				resultado = resultado + ", ParteEdificacaoLinha" + linha + "_9 = " + matriz[i][8];				

				if (i == 5) {
					if ((this.getObservacaoParteEdificacao().equals("")) || (this.getObservacaoParteEdificacao() == null)) {
						resultado = resultado + ", ObservacaoLinha6 =";
					} else {
						resultado = resultado + ", ObservacaoLinha6 =" + this.getObservacaoParteEdificacao();
					}
				}
				
				resultado = resultado + "]";
			}
		}
		/*
		for (int i = ++linha; i <= matriz.length; i++) {
			for (int j = 1; j < 10; j++) {
				retorno.put("ParteEdificacaoLinha" + i + "_" + j, "");
			}
		}
		*/		
		
		resultado = resultado + "]";
		
		return resultado;
	}

}