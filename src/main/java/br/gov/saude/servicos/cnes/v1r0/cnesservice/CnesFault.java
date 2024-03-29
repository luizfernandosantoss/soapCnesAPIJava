
package br.gov.saude.servicos.cnes.v1r0.cnesservice;

import javax.xml.ws.WebFault;

import br.gov.saude.servicos.cnes.mensageria.falha.v5r0.msfalha.MSFalha;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "MSFalha", targetNamespace = "http://servicos.saude.gov.br/wsdl/mensageria/falha/v5r0/msfalha")
public class CnesFault
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private MSFalha faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public CnesFault(String message, MSFalha faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public CnesFault(String message, MSFalha faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: MSFalha
     */
    public MSFalha getFaultInfo() {
        return faultInfo;
    }

}
