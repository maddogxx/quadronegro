/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.quadronegro.vo;

/**
 *
 * @author thiagocs
 */
public class CarnetImobiliario {
    /**
     * Seqüencial do carnê no arquivo de emissão do lanamento anual.
     * O sequencial já deverá estar formatado.
     */
    private String sequencial;

    /**
     * Seqüencial do imóvel já formatado.
     */
    private String sequencialImovel;
    
    /**
     * Ano do exercício do lançamento já formatado.
     */
    private String exercicio;

    /**
     * Código de controle de impressão do carnê na emissão do lançamento anual.
     */
    private String codigoImpressao;

    /**
     * Titulo que é impresso na capa do carnê, podendo assumir os valores: IPTU
     * e Taxas 9999; ou Taxas 9999 (Imune do IPTU), onde 9999 é o ano do exercício.
     */
    private String tituloCapa;

    /**
     * Endereço de correspondência  em 3 linhas, que é impresso  na capa do carnê.
     */
    private String[] enderecoCorrespondencia = new String [3];

    /**
     * Endereço do imóvel em 2 linhas, que é impresso na notificação de
     * lançamento do carnê.
     */
    private String[] enderecoImovel = new String [2];

    /**
     * Mensagem a respeito da situação de adimplência do imóvel no último 10 de
     * novembro, que é impressa em 5 linhas na notificação de lançamento. A situação
     * de adimplência do imóvel determina o percentual de desconto que ele tem nesse
     * lançamento.
     */
    private String[] mensagemNotificacao = new String [5];

    /**
    * Indica a observacao da notificacao do lancamento para o protocolo,
    */
    private String  observacaoNotificacaoLancamento;

    /**
    * Indica a observacao protocolo entrega para o protocolo,
    */
    private String  observacaoProtocoloEntrega;

    /**
     * Número do protocolo de entrega que é colocado no seu código de barras.
     * Seu conteúdo é: I.SS.SSSS.SSSA.AAAD, onde:
     * I => 1 para carnês imobiliários;
     * SSSSSSSSS => seqüencial do imóvel sem o dígito verificador;
     * AAAA => ano do exercício do lançamento;
     * D => dígito verificador do número, calculadopelo módulo 11.
     */
    private String numeroProtocolo;

    /**
     * DIM do carnet imobiliário. Este objeto contém todos os dados necessários
     * para o DIM do carnet.
     */
    private DIM dim;

    /**
     * Construtor da classe.
     */
    public CarnetImobiliario() {
    }

    /**
     * Retorna o código da impressão.
     * @return    O código da impressão.
     */
    public String getCodigoImpressao() {
        return codigoImpressao;
    }

    /**
     * Retorna o DIM do carnet.
     * @return    O DIM do carnet.
     */
    public DIM getDIM() {
        return dim;
    }

    /**
     * Retorna todas as linhas do endereço de correspondencia.
     * @return    As linhas do endereço de correspondencia.
     */
    public String[] getEnderecoCorrespondencia() {
        return enderecoCorrespondencia;
    }

    /**
     * Retorna todas as linhas do endereço do imóvel.
     * @return    As linhas do endereço do imóvel.
     */
    public String[] getEnderecoImovel() {
        return enderecoImovel;
    }

    /**
     * Retorna o exercício do carnet.
     * @return    O exercício.
     */
    public String getExercicio() {
        return exercicio;
    }

    /**
     * Retorna todas as linhas da mensagem de notificação.
     * @return    As linhas da mensagem de notificação.
     */
    public String[] getMensagemNotificacao() {
        return mensagemNotificacao;
    }

    /**
     * Retorna o número do protocolo.
     * @return    O número do protocolo.
     */
    public String getNumeroProtocolo() {
        return numeroProtocolo;
    }

    /**
     * Retorna o sequencial do carnet.
     * @return    O sequencial do carnet.
     */
    public String getSequencial() {
        return sequencial;
    }
    /**
     * Retorna o sequencial do imóvel para o qual será emitido este carnet.
     * @return    O sequencial do imóvel.
     */
    public String getSequencialImovel() {
        return sequencialImovel;
    }

    /**
     * Retorna o título da capa do carnet.
     * @return    O título.
     */
    public String getTituloCapa() {
        return tituloCapa;
    }

    /**
     * Retorna todas as linhas da observacao de notificacao lancamento.
     * @return    As linhas da mensagem de notificação.
     */
    public String getObservacaoNotificacaoLancamento() {
        return observacaoNotificacaoLancamento;
    }

    /**
     * Retorna a observacao do protocolo de entrega.
     * @return    A linha da mensagem de entrega.
     */
    public String getObservacaoProtocoloEntrega() {
        return observacaoProtocoloEntrega;
    }


    /**
     * Altera o sequencial do imóvel que está vinculado a este carnet.
     * @param sequencialImovel    O novo sequencial do imóvel, formatado.
     */
    public void setSequencialImovel(String sequencialImovel) {
        this.sequencialImovel = sequencialImovel;
    }

    /**
     * Altera o sequencial do carnet.
     * @param sequencialImovel    O sequencial do carnet já formatado.
     */
    public void setSequencial(String sequencial) {

        this.sequencial = sequencial;
    }

    /**
     * O número do protocolo deste carnet.
     * @param numeroProtocolo    O número do protocolo.
     */
    public void setNumeroProtocolo(String numeroProtocolo) {
        this.numeroProtocolo = numeroProtocolo;
    }

    /**
     * Altera a mensagem de notificação deste carnet.
     * @param mensagemNotificacao    As linhas da mensagem de notificação.
     */
    public void setMensagemNotificacao(String[] mensagemNotificacao) {
        this.mensagemNotificacao = mensagemNotificacao;
    }

    /**
     * Altera o exercício ao qual se refere ao carnet.
     * @param exercicio    O novo exercício.
     */
    public void setExercicio(String exercicio) {
        this.exercicio = exercicio;
    }

    /**
     * Altera o endereço do imóvel do carnet.
     * @param enderecoImovel    As linhas do endereço do imóvel.
     */
    public void setEnderecoImovel(String[] enderecoImovel) {
        this.enderecoImovel = enderecoImovel;
    }

    /**
     * Altera o endereço de correspondência para o carnet.
     * @param enderecoCorrespondencia    As linhas do novo endereço de
     * correspondência.
     */
    public void setEnderecoCorrespondencia(String[] enderecoCorrespondencia) {
        this.enderecoCorrespondencia = enderecoCorrespondencia;
    }

    /**
     * Altera o DIM que está vinculado a este carnet.
     * @param dim    O novo DIM.
     */
    public void setDIM(DIM dim) {
        this.dim = dim;
    }

    /**
     * Altera o código da impressão do carnet.
     * @param codigoImpressao    O novo código de impressão.
     */
    public void setCodigoImpressao(String codigoImpressao) {
        this.codigoImpressao = codigoImpressao;
    }

    /**
     * Altera o título da capa do carnet.
     * @param tituloCapa    O novo título.
     */
    public void setTituloCapa(String tituloCapa) {
        this.tituloCapa = tituloCapa;
    }

    /**
     * Altera as linhas da observacao de notificacao lancamento.
     * @return    As linhas da mensagem de notificação.
     */
    public void setObservacaoProtocoloEntrega(String observacaoProtocoloEntrega) {
        this.observacaoProtocoloEntrega = observacaoProtocoloEntrega;
    }

    /**
     * Altera a observacao do protocolo de entrega.
     * @return    A linha da mensagem de entrega.
     */
    public void setObservacaoNotificacaoLancamento(String observacaoNotificacaoLancamento) {
        this.observacaoNotificacaoLancamento = observacaoNotificacaoLancamento;
    }
    
	public String toString() {
		String resultado = "CarnetImobiliario [";
		boolean virgula = false;
		
		if (sequencial != null) {
			resultado = resultado + "sequencial=" + sequencial;
			virgula = true;
		}
		
		if (sequencialImovel != null) {
			if (virgula) {
				resultado = resultado + ", sequencialImovel=" + sequencialImovel;
			} else {
				resultado = resultado + "sequencialImovel=" + sequencialImovel;
				virgula = true;
			}
		}
		
		if (exercicio != null) {
			if (virgula) {
				resultado = resultado + ", exercicio=" + exercicio;
			} else {
				resultado = resultado + "exercicio=" + exercicio;
				virgula = true;
			}
		}
		
		if (codigoImpressao != null) {
			if (virgula) {
				resultado = resultado + ", codigoImpressao=" + codigoImpressao;
			} else {
				resultado = resultado + "codigoImpressao=" + codigoImpressao;
				virgula = true;
			}
		}

		if (tituloCapa != null) {
			if (virgula) {
				resultado = resultado + ", tituloCapa=" + tituloCapa;
			} else {
				resultado = resultado + "tituloCapa=" + tituloCapa;
				virgula = true;
			}
		}
		
		if (virgula) {
			resultado = resultado + ", " + toStringArray(enderecoCorrespondencia, "enderecoCorrespondencia");
		} else {
			resultado = resultado + toStringArray(enderecoCorrespondencia, "enderecoCorrespondencia");
			virgula = true;
		}
		
		if (virgula) {
			resultado = resultado + ", " + toStringArray(enderecoImovel, "enderecoImovel");
		} else {
			resultado = resultado + toStringArray(enderecoImovel, "enderecoImovel");
			virgula = true;
		}
		
		if (virgula) {
			resultado = resultado + ", " + toStringArray(mensagemNotificacao, "mensagemNotificacao");
		} else {
			resultado = resultado + toStringArray(mensagemNotificacao, "mensagemNotificacao");
			virgula = true;
		}

		if (observacaoNotificacaoLancamento != null) {
			if (virgula) {
				resultado = resultado + ", observacaoNotificacaoLancamento=" + observacaoNotificacaoLancamento;
			} else {
				resultado = resultado + "observacaoNotificacaoLancamento=" + observacaoNotificacaoLancamento;
				virgula = true;
			}
		}
		
		if (observacaoProtocoloEntrega != null) {
			if (virgula) {
				resultado = resultado + ", observacaoProtocoloEntrega=" + observacaoProtocoloEntrega;
			} else {
				resultado = resultado + "observacaoProtocoloEntrega=" + observacaoProtocoloEntrega;
				virgula = true;
			}
		}
		
		if (numeroProtocolo != null) {
			if (virgula) {
				resultado = resultado + ", numeroProtocolo=" + numeroProtocolo;
			} else {
				resultado = resultado + "numeroProtocolo=" + numeroProtocolo;
				virgula = true;
			}
		}
		
		if (dim != null) {
			if (virgula) {
				resultado = resultado + ", " + dim.toString();
			} else {
				resultado = resultado + dim.toString();
				virgula = true;
			}
		}
		
		resultado = resultado + "]";		

		return resultado;
	} // Fim do toString
	
	private String toStringArray(String[] vetor, String titulo) {
		String resultado = titulo + "[";
		String auxiliar = "";
		boolean virgula = false;
		
		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] != null) {
				if (virgula) {
					auxiliar = "i" + i + "="+ auxiliar + ", " + vetor[i];
				} else {
					auxiliar = "i" + i + "="+ auxiliar + vetor[i];
					virgula = true;
				}
			}
		}
		
		resultado = resultado + auxiliar + "]";
		
		return resultado;
	}
}